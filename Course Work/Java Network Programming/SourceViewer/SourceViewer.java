/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: October 12, 2022
Assignment 1

Acknowledgement: This code was modified from the program SourceViewer4 from Java Network Programming,
4th Edition by Elliotte Rusty Harold on page 236 as per the assignment requirements.

Purpose: To edit the SourceViewer4 program by Harold in Java Network Programming, 4th Edition,
to find all instances of a given search string on a web page, and display the line numbers that the
given search string appears on.

Instructions(CLI):
To compile this program enter the command into the command line:
javac SourceViewer.java
To run this program in the command line enter:
java SourceViewer URL/IP searchstring, where URL/IP is the URL or IP of the web page to be searched,
and searchstring is the string to be searched in the web page.
 */

import java.io.*;
import java.net.*;

public class SourceViewer {
    public static void main(String[] args) {
        if (args.length != 2) { //No URL, IP address, or search string entered.
            System.out.println("Please enter a valid URL or IP address, and a search string." +
                    "\nIn the form java SourceViewer URL/IP {SearchString}.");
            System.exit(0);
        }
            try {
                URL u = new URL(args[0]);
                HttpURLConnection uc = (HttpURLConnection) u.openConnection();
                try (InputStream raw = uc.getInputStream()) {
                    searchFromStream(raw, args[1]);
                } catch (IOException ex) {
                    searchFromStream(uc.getErrorStream(), "");
                }
            } catch (MalformedURLException ex) {
                System.err.println(args[0] + " is not a parseable URL");
            } catch (IOException ex) {
                System.err.println(ex);
            }
    }
    private static void searchFromStream(InputStream raw, String searchStr) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(raw))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (line.contains(searchStr)) {
                    System.out.println(line);
                    System.out.println("\n");
                }
            }
        }
    }
}