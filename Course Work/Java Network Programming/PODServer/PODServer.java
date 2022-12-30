/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: December 12, 2022
Assignment 3

Acknowledgement: This code was based on the program SingleFileHTTPServer from Java Network Programming,
4th Edition by Elliotte Rusty Harold on page 314.

Purpose: To create a Poem of the Day(Pod) network application using the ServerSocket class.
This application will allow a client to connect to this machine as the server. The client will
be given a welcome message along with instructions for acceptable input. Depending on the client
input, they will be delivered a certain poem or an error message.

Instructions(CLI):
To compile this program enter the command into the command line:
javac PODServer.java
To run this program in the command line enter:
java PODServer {poem file} {port number}
With the recommended peom file being called mypoems.txt, and the port will default to 1200
if no port or incorrect port number is selected.


Test Plan:

Good Input:

Test 1: java PODServer mypoems.txt 1200 With client entering 1 when prompted after connecting to the server via telnet.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then, the poem, Ozymandias by Percy Bysshe Shelley to be displayed in the client’s terminal.

Actual Result:
As expected.

Test 2: java PODServer mypoems.txt 1200 With client entering 2 when prompted after connecting to the server via telnet.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then, the poem, The Road Not Taken by Robert Frost to be displayed in the client’s terminal.

Actual Result:
As expected.

Test 3: java PODServer mypoems.txt 1200 With client entering 3 when prompted after connecting to the server via telnet.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then, the poem, Invictus by William Ernest Henley to be displayed in the client’s terminal.

Actual Result:
As expected.

Test 5: java PODServer mypoems.txt 1200 With client entering 4 when prompted after connecting to the server via telnet.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then, the poem, Nothing Gold Can Stay by Robert Frost to be displayed in the client’s terminal.

Actual Result:
As expected.

Bad Input:

Test 1: java PODServer mypoems.txt 1200 with client entering test when prompted after connecting to the server via telnet.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then the server should instruct the user on proper input before closing the connection.

Actual Result:
As expected.

Test 2: java PODServer mypoems.txt 1200 with client doing nothing.

Expected Result: A welcome message with instructions appearing on the client’s telnet terminal.
Then the server connection should timeout and close the connection after 30 seconds.

Actual Result:
As expected.

Test 3: java PODServer dne.txt 1200.

Expected Result: A FileNotFound exception should be thrown and a message saying “not a valid file”,
with the server shutting down.

Actual Result:
As expected.

Test 4: java PODServer mypoems.txt 2000

Expected Result: Server should default to port 1200, allowing the client to connect at that port.

Actual Result:
As expected.

Test 5: java PODServer mypoems.txt -1

Expected Result: The server should connect to port 1200, with the client able to connect via port 1200.

Actual Result:
As expected.

 */
import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.logging.*;

public class PODServer {

    private static final Logger logger = Logger.getLogger("PODServer");


    private final int port;
    private String[] poems = new String[4];
    private final String welcomeMes = "Welcome to the Poem of the Day (PoD) server!\n" +
            "Please enter a number between 1-4, inclusive for a poem.\n" +
            "1: Ozymandias by Percy Bysshe Shelley\n" +
            "2: The Road Not Taken by Robert Frost\n" +
            "3: Invictus by William Ernest Henley\n" +
            "4: Nothing Gold Can Stay by Robert Frost\n" +
            "Enter your choice: \n";

    //Read from the specified file from CLI, and insert poems into an array for clients to request.
    private void getPoems(String file) {
        try {
            File poemFile = new File(file);
            Scanner poemReader = new Scanner(poemFile);
            int poemNum = -1;
            while (poemReader.hasNextLine()) {
                String nextLine = poemReader.nextLine();
                try { //New poem, insert into next array element.
                    int x = Integer.parseInt(nextLine);
                    poemNum++;
                } catch (NumberFormatException ex) { //Append to array element.
                    if (poems[poemNum] == null) { //To avoid null appearing at the beginning of the poem.
                        this.poems[poemNum] = nextLine + "\n";
                    }
                    else {
                        this.poems[poemNum] += nextLine + "\n";
                    }
                }
            }
            poemReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Not a valid file");
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public PODServer(String poemFile, int port) {
        this.port = port;
        getPoems(poemFile); //Load the poems into the poems array.
    }

    public void start() {
        ExecutorService pool = Executors.newFixedThreadPool(100);
        try (ServerSocket server = new ServerSocket(this.port)) {
            logger.info("Accepting connections on port " + server.getLocalPort());

            while (true) {
                try {
                    Socket connection = server.accept();
                    logger.info("Host: " + connection.getRemoteSocketAddress() + " connected.");
                    pool.submit(new PODHandler(connection));
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

    private class PODHandler implements Callable<Void> {
        private final Socket connection;

        PODHandler(Socket connection) throws SocketException {
            this.connection = connection;
            this.connection.setSoTimeout(30000); //30 second timeout.
        }

        @Override
        public Void call() throws IOException {
            try {
                OutputStream out = new BufferedOutputStream(connection.getOutputStream());
                InputStream in = new BufferedInputStream(connection.getInputStream());
                out.write(welcomeMes.getBytes());
                out.flush();
                StringBuilder request = new StringBuilder(80);
                while (true) {
                    int c = in.read();
                    if (c == -1) break;
                    request.append((char) c);
                    if (!request.isEmpty()) {
                        break;
                    }
                }
                switch (request.toString()) { //The + "\n" is for improved readability.
                    case "1" -> out.write((poems[0] + "\n").getBytes());
                    case "2" -> out.write((poems[1] + "\n").getBytes());
                    case "3" -> out.write((poems[2] + "\n").getBytes());
                    case "4" -> out.write((poems[3] + "\n").getBytes());
                    default -> out.write((("Please enter a number between 1-4, inclusive " +
                            "after reconnecting to the server.").getBytes()));
                }
                out.flush();
            } catch (IOException ex) {
                logger.log(Level.WARNING, "Error writing to client", ex);
            } finally {
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
            if (port < 1 || port > 65535) port = 1200;
        } catch (RuntimeException ex) {
            port = 1200;
        }

        try {
            PODServer server = new PODServer(args[0], port);
            server.start();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Usage: java PODServer filename port");
        }
    }
}
