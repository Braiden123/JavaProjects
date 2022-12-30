/*
I declare that this assignment is my own work and that all material previously written or published
in any source by any other person has been duly acknowledged in the assignment.
I have not submitted this work, or a significant part thereof, previously as part of any academic program.
In submitting this assignment I give permission to copy it for assessment purposes only.

Author: Braiden Little
Date: September 26, 2022
Assignment 1

Acknowledgement: This code was modified from the program PooledWeblog from Java Network Programming,
4th Edition by Elliotte Rusty Harold on pages 115-116 as per the assignment requirements.

Purpose: To edit the Weblog program by Harold in Java Network Programming, 4th Edition,
to read a weblog and tally statistics on the log entries based on an input option choice.

Instructions(CLI):
To compile this program enter the command into the command line:
javac MyPooledWebLog.java
To run this program in the command line enter:
java MyPooledWeblog 'Logname' option, where option is an integer between 1-3,
with 1 to count the number of accesses by each remote host, 2 to count the total bytes transmitted,
and 3 to count total bytes by each remote host.
 */
import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.HashMap;

public class MyPooledWebLog {
    private final static int NUM_THREADS = 4;

    public static void main(String[] args) throws IOException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        Queue<LogEntry> results = new LinkedList<LogEntry>();

        try {
            if (args.length == 1) { // Default option.
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
                    for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                        LookupTask task = new LookupTask(entry);
                        Future<String> future = executor.submit(task);
                        LogEntry result = new LogEntry(entry, future);
                        results.add(result);
                    }
                }

                // Start printing the results. This blocks each time a result isn't ready.
                for (LogEntry result : results) {
                    try {
                        System.out.println(result.future.get());
                    } catch (InterruptedException | ExecutionException ex) {
                        System.out.println(result.original);
                    }
                }
            } else if (args[1].equals("1")) { //Option 1, total accesses by each host.
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
                    for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                        GetHostTask task = new GetHostTask(entry);
                        Future<String> future = executor.submit(task);
                        LogEntry result = new LogEntry(entry, future);
                        results.add(result);
                    }
                }

                HashMap<String, Integer> hostCount = new HashMap<String, Integer>(); /* Used to count each occurrence of
                                                                                        each remote host. */
                for (LogEntry result : results) {
                    try {
                        String hostname;
                        try { //If hostname lookup does not work, use given address in log.
                            int index = result.future.get().indexOf(' ');
                            hostname = result.future.get().substring(0, index);
                        } catch (Exception ex) { //Hostname lookup successful.
                            hostname = result.future.get();
                        }
                        if (hostCount.containsKey(hostname)) { //Hostname has already been counted, increment.
                            hostCount.put(hostname, hostCount.get(hostname) + 1);
                        } else { //First instance of hostname.
                            hostCount.put(hostname, 1);
                        }
                    } catch (InterruptedException | ExecutionException ex) {
                        System.out.println(result.original);
                    }
                }

                for (String hostname : hostCount.keySet()) { //Iterate through each hostname and print its occurrence.
                    System.out.println("Hostname:" + hostname + " \nNumber of accesses: " + hostCount.get(hostname));
                }
            } else if (args[1].equals("2")) { //Option 2, total bytes transmitted
                int totalBytes = 0;
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
                    for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                        CountBytesTask task = new CountBytesTask(entry);
                        Future<String> future = executor.submit(task);
                        LogEntry result = new LogEntry(entry, future);
                        try {
                            try {
                                totalBytes += Integer.parseInt(result.future.get());
                            } catch (NumberFormatException ex) {
                                //No bytes transmitted, do nothing.
                            }
                        } catch (InterruptedException | ExecutionException ex) {
                            System.out.println(result.original);
                        }
                    }
                }
                System.out.println("Total number of bytes transmitted: " + totalBytes + " bytes.");

            } else if (args[1].equals("3")) {
                try (BufferedReader in = new BufferedReader(
                        new InputStreamReader(new FileInputStream(args[0]), "UTF-8"));) {
                    for (String entry = in.readLine(); entry != null; entry = in.readLine()) {
                        CountHostBytesTask task = new CountHostBytesTask(entry);
                        Future<String> future = executor.submit(task);
                        LogEntry result = new LogEntry(entry, future);
                        results.add(result);
                    }
                }

                HashMap<String, Integer> hostBytes = new HashMap<String, Integer>(); /* Used to record each remote host
                                                                                        and their associated bytes transmitted.*/
                for (LogEntry result : results) {
                    try {
                        String[] splitLine = result.future.get().split(" ");
                        String hostname = splitLine[0];
                        try {
                            int hostnameBytes = Integer.parseInt(splitLine[splitLine.length - 1]);
                            if (hostBytes.containsKey(hostname)) { //Hostname has been encountered before add bytes.
                                hostBytes.put(hostname, hostBytes.get(hostname) + hostnameBytes);
                            } else { //Hostname has not been encountered before create new hash entry with hostnameBytes.
                                hostBytes.put(hostname, hostnameBytes);
                            }
                        } catch (NumberFormatException ex) { //Number of bytes cannot be read as an integer.
                            if (!hostBytes.containsKey(hostname)) { //Hostname has not been encountered before 0 bytes.
                                hostBytes.put(hostname, 0);
                            }
                        }
                    } catch (Exception ex) {
                        System.out.println(result.original);
                    }
                }

                for (String hostWithBytes : hostBytes.keySet()) {
                    System.out.println("Hostname: " + hostWithBytes +
                            "\nTotal bytes transmitted: " + hostBytes.get(hostWithBytes));
                }
        }
            else {
                System.out.println("To run this program enter on a command line:\n" +
                        "java MyPooledWebLog {file_name} {option}\n" +
                        "Where option is left blank for printing out all host names with the rest of the line.\n" +
                        "Option 1 is to print the number of occurrences of each host.\n" +
                        "Option 2 is to print the total number of bytes transmitted.\n" +
                        "And Option 3 is to print the total number of bytes transmitted by each host.");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println("To run this program enter on a command line:\n" +
                    "java MyPooledWebLog {file_name} {option}\n" +
                    "Where option is left blank for printing out all host names with the rest of the line.\n" +
                    "Option 1 is to print the number of occurrences of each host.\n" +
                    "Option 2 is to print the total number of bytes transmitted.\n" +
                    "And Option 3 is to print the total number of bytes transmitted by each host.");
        }
        executor.shutdown();
    }

    private static class LogEntry {
        String original;
        Future<String> future;

        LogEntry(String original, Future<String> future) {
            this.original = original;
            this.future = future;
        }
    }
}