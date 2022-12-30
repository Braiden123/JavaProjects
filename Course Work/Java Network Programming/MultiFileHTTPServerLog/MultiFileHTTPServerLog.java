/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: November 18, 2022
Assignment 2

Acknowledgement: This code was modified from the program SingleFileHTTPServer from Java Network Programming,
4th Edition by Elliotte Rusty Harold on page 314 as per the assignment requirements. I also took some
inspiration from the JHTTP.java and RequestProcessor.java programs from the same book by Elliote Rusty Harold
on pages 323-328

Purpose: To edit the MultiFileHTTPServer program made in the previous part of the assignment
to support logging in the same method as what was used for assignment 1.

Instructions(CLI):
To compile this program enter the command into the command line:
javac MultiFileHTTPServerLog.java
To run this program in the command line enter:
java MultiFileHTTPServerLog {root directory} {port number}
With the recommended root directory being the current directory, "." in UNIX.


Test Plan:

Good Input:

Test 1: java MultiFileHTTPServerLog . 1200

Connect to the server at localhost:1200 in the Firefox browser, access the jpg,
png, and pdf files, then terminate the server.

Expected Result:

A file called MultiFileAccess_Log with the host IP address(since connecting from the server machine),
date, time, timezone, HTTP request, response code, and total bytes sent from each request.

Actual Result:

As expected, but with a favicon.ico file being unable to send as I do not have that
as part of my html site, so it sends a 404 error in response, but does not affect
the user's ability to access the files.

Test 2: java MyPooledWebLog MultiFileAccess_Log

Testing the output for correctness in the MyPooledWebLog program from assignment 1.

Expected Result:

Since I am connecting to the same local machine, a dns lookup will fail and print out each line
from the MultiFileAccess_Log as is.

Actual Result:

As expected.

Test 3: java MyPooledWebLog MultiFileAccess_Log 1

Expected Result:

Total host access count from my machine: 11

Actual Result:

As expected.

Test 4: java MyPooledWebLog MultiFileAccess_Log 2

Expected Result:

Total Bytes Sent: 291331

Actual Result:

As expected.

Test 5: java MyPooledWebLog MultiFileAccess_Log 3

Expected Result:

/127.0.0.1 Total Bytes Sent: 291331

Actual Result: As expected.

Bad Input:

Test 1: java MultiFileHTTPServerLog . 1200

Connect to the server at localhost:1200 with the Firefox browser and request dne.html.

Expected Result:

An access entry from my local host machine with the
404 response code with length of 117 bytes appended to the MultiFileAccess_Log.

Actual Result:

As expected.
 */

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.*;
import java.util.logging.*;

public class MultiFileHTTPServerLog {

    private static final Logger logger = Logger.getLogger("MultiFileHTTPServer");
    private final File rootDir;
    private byte[] content;
    private byte[] headerBytes;
    private final int port;
    private final String encoding;
    private final String indexFileName = "index.html";

    public MultiFileHTTPServerLog(
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
                        ZoneId zone = ZoneId.systemDefault(); //Get system timezone.
                        Date now = new Date();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss Z",
                                Locale.ENGLISH);
                        ZonedDateTime zonedTime = ZonedDateTime.ofInstant(now.toInstant(), zone);
                        BufferedWriter logOut = new BufferedWriter(new FileWriter(
                                "./MultiFileAccess_Log", true));// Append to file.
                        logOut.write(connection.getInetAddress().toString() + " - - ["
                                + formatter.format(zonedTime) + "] \"" + get + "\" " + 200 + " " + content.length + "\n");
                        logOut.flush();
                        logOut.close();
                        }
                    } else { //Can't find file
                        String body = new StringBuilder("<HTML>\r\n")
                                .append("<HEAD><TITLE.File Not Found</TITLE>\r\n")
                                .append("</HEAD.\r\n")
                                .append("<BODY>")
                                .append("<H1>HTTP Error 404: File Not Found</H1>\r\n")
                                .append("</BODY></HTML>\r\n").toString();
                        if (version.startsWith("HTTP/")) { //send an HTTP header
                            Date now = new Date();
                            String header = "HTTP/1.0 404 File Not Found\r\n"
                                    + "Date: " + now + "\r\n"
                                    + "Server:MultiFileHTTPServer 1.0\r\n"
                                    + "Content-length:" + content.length + "\r\n"
                                    + "Content-type:" + mimeType + "\r\n\r\n";
                            headerBytes = header.getBytes(Charset.forName("US-ASCII"));//Convert to Bytes.
                            out.write(headerBytes);//Send header and data then flush.
                            out.write(body.getBytes());
                            out.flush();
                            ZoneId zone = ZoneId.systemDefault(); //Get system timezone.
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy:HH:mm:ss Z",
                                    Locale.ENGLISH);
                            ZonedDateTime zonedTime = ZonedDateTime.ofInstant(now.toInstant(), zone);
                            BufferedWriter logOut = new BufferedWriter(new FileWriter("./MultiFileAccess_Log", true));
                            logOut.write(connection.getInetAddress().toString() + " - - ["
                                    + formatter.format(zonedTime) + "] \"" + get + "\" " + 404 + " "
                                    + body.getBytes().length + "\n");
                            logOut.flush();
                            logOut.close();
                        }
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
            MultiFileHTTPServerLog server = new MultiFileHTTPServerLog(rootDir, encoding, port);
            server.start();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usage: java MultiFileHTTPServer filename port encoding");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
