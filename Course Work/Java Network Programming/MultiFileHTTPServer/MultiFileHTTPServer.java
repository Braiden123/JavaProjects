/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: October 25, 2022
Assignment 2

Acknowledgement: This code was modified from the program SingleFileHTTPServer from Java Network Programming,
4th Edition by Elliotte Rusty Harold on page 314 as per the assignment requirements. I also took some
inspiration from the JHTTP.java and RequestProcessor.java programs from the same book by Elliote Rusty Harold
on pages 323-328

Purpose: To edit the SingleFileHTTPServer program by Harold in Java Network Programming, 4th Edition,
to be able to provide multiple files, essentially a proper HTTP server.

Instructions(CLI):
To compile this program enter the command into the command line:
javac MultiFileHTTPServer.java
To run this program in the command line enter:
java MultiFileHTTPServer {root directory} {port number}
With the recommended root directory being the current directory, "." in UNIX.


Test Plan:

Good Input:

Test 1: java MultiFileHTTPServer . 1200

Expected Result: Displaying of the index.html file when connecting to LocalHost:1200 on Firefox browser,
with the ability to click links on the index.html page and display the desired content, with jpgs, pngs
and pdfs able to display correctly.

Actual Result: As expected.

Test 2: java MultiFileHTTPServer . 1200 US-ASCII (Testing encoding)

Expected Result: Displaying of the index.html file, with the kanji character within it
to incorrectly display, as expected of US-ASCII.

Actual Result: As expected.

Test 3: java MultiFileHTTPServer . 1200 With connection left idle for over 30 seconds.

Expected Result: Server socket should close the connection to the client after 30 seconds of inactivity.

Actual Result: As expected.

Bad Input:

Test 1: java MultiFileHTTP Server . 1200 with Firefox connecting to localhost:1200/dne.html

Expected Result: A HTTP: 404 File Not Found error will be displayed in the browser

Actual Result:As expected

Test 2: java MultiFileHTTPServer . -1 Test for incorrect port.

Expected Result: Server should be set to port 80.

Actual Result: As expected.

Test 3: java MultiFileHTTPServer . 65536 Test for incorrect port.

Expected Result: Server should be set to port 80.

Actual Result: As expected.

Test 4: java MultiFileHTTPServer . 1200 abc098 Test for incorrect encoding.

Expected Result: Firefox should use the default US-ASCII encoding, and display the kanji
character incorrectly.

Actual Result: As expected

 */

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Date;
import java.util.concurrent.*;
import java.util.logging.*;

public class MultiFileHTTPServer {

    private static final Logger logger = Logger.getLogger("MultiFileHTTPServer");
    private final File rootDir;
    private byte[] content;
    private byte[] headerBytes;
    private final int port;
    private final String encoding;
    private final String indexFileName = "index.html";

    public MultiFileHTTPServer(
            File rootDir, String encoding, int port) throws IOException {
        if (!rootDir.isDirectory()) {
            throw new IOException(rootDir + "does not exist as a directory");
        }
        try {
            rootDir = rootDir.getCanonicalFile();
        } catch (IOException ex) {
        }
        this.rootDir = rootDir;
        this.port = port;
        this.encoding = encoding;
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        try (ServerSocket server = new ServerSocket(this.port)) {
            logger.info("Accepting connections on port " + server.getLocalPort());
            server.setSoTimeout(30000); //Set timeout of 30 seconds.
            while (true) {
                try {
                    Socket connection = server.accept();
                    pool.submit(new HTTPHandler(connection));
                } catch (IOException ex) {
                    logger.log(Level.WARNING, "Exception accepting connection", ex);
                } catch (RuntimeException ex) {
                    logger.log(Level.SEVERE, "Unexpected error", ex);
                }
            }
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Could not start server", ex);
        }
    }

    private class HTTPHandler implements Callable<Void> {
        private final Socket connection;

        HTTPHandler(Socket connection) {
            this.connection = connection;
        }

        @Override
        public Void call() throws IOException {
            String root = rootDir.getPath(); //For security
            try {
                OutputStream out = new BufferedOutputStream(
                        connection.getOutputStream()
                );
                InputStream in = new BufferedInputStream(
                        connection.getInputStream()
                );
                StringBuilder request = new StringBuilder();
                while (true) { //Read incoming request.
                    int c = in.read();
                    if (c == '\r' || c == '\n') break;
                    request.append((char) c);
                }
                String get = request.toString();

                logger.info(connection.getRemoteSocketAddress() + " " + get);

                String[] tokens = get.split("\\s+"); //Get the HTTP method, version, and requested file.
                String method = tokens[0];
                String version = "";
                if (method.equals("GET")) {
                    String fileName = tokens[1];
                    if (fileName.endsWith("/")) fileName += indexFileName; //No file requested, go to index.html
                    String mimeType = URLConnection.getFileNameMap().getContentTypeFor(fileName);
                    if (tokens.length > 2) { //HTTP version sent with GET request.
                        version = tokens[2];
                    }

                    File sentFile = new File(rootDir, fileName.substring(1)); /*append filename to rootDir
                                                                                        and create new File to send*/
                    if (sentFile.canRead() && sentFile.getCanonicalPath().startsWith(root)) {//File exists in root.
                        content = Files.readAllBytes(sentFile.toPath());
                        if (version.startsWith("HTTP/")) {
                        String header = "HTTP/1.0 200 OK\r\n" //Create the HTTP header
                                + "Server: MultiFileHTTPServer 1.0\r\n"
                                + "Content-length:" + content.length + "\r\n"
                                + "Content-type:" + mimeType + "; charset=" + encoding + "\r\n\r\n";
                        headerBytes = header.getBytes(Charset.forName("US-ASCII"));//Convert to byte array
                        out.write(headerBytes);//Send header and data then flush.
                        out.write(content);
                        out.flush();
                        }
                    } else { //Can't find file
                        String body = new StringBuilder("<HTML>\r\n")
                                .append("<HEAD><TITLE.File Not Found</TITLE>\r\n")
                                .append("</HEAD.\r\n")
                                .append("<BODY>")
                                .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                                .append("</BODY></HTML>\r\n").toString();
                        if (version.startsWith("HTTP/")) { //send a HTTP header
                            Date now = new Date();
                            String header = "HTTP/1.0 404 File Not Found\r\n"
                                    + "Date: " + now + "\r\n"
                                    + "Server:MultiFileHTTPServer 1.0\r\n"
                                    + "Content-length:" + content.length + "\r\n"
                                    + "Content-type:" + mimeType + "\r\n\r\n";
                            headerBytes = header.getBytes(Charset.forName("US-ASCII"));//Convert to Bytes.
                        }
                        out.write(headerBytes);//Send header and data then flush.
                        out.write(body.getBytes());
                        out.flush();
                    }
                }
            } catch (IOException ex) {
                logger.log(Level.WARNING, "Error writing to client");
            }finally {
                connection.close();
            }
            return null;
        }
    }

    public static void main(String[] args) {

        //set the port to listen on
        int port;
        try {
            port = Integer.parseInt(args[1]);
            if (port < 1 || port > 65535) { //Invalid port number, set to 80.
                port = 80;
            }
        } catch (RuntimeException ex) {
            port = 80;
        }

        String encoding = "UTF-8";
        if (args.length > 2) {
            encoding = args[2];
        }
        try {
            File rootDir = new File(args[0]);
            MultiFileHTTPServer server = new MultiFileHTTPServer(rootDir, encoding, port);
            server.start();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usage: java MultiFileHTTPServer filename port encoding");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
