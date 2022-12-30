/*
Code is based on LookupTask.java from Java Network Programming, 4th edition by Elliotte Rusty Harold, page 115.
 */
import java.net.*;
import java.util.concurrent.Callable;
import java.util.regex.PatternSyntaxException;

public class CountHostBytesTask implements Callable<String>{
    private String line;

    public CountHostBytesTask(String line) {
        this.line = line;
    }

    @Override
    /*@Return hostnameWithBytes: returns hostname and its number of bytes transmitted separated by a space.
    Original line will be returned if errors occur.*/
    public String call() {
        String hostnameWithBytes = "";
        try {
            // separate out the IP address
            int index = line.indexOf(' ');
            String address = line.substring(0, index);
            hostnameWithBytes += InetAddress.getByName(address).getHostName();
        }
        catch (Exception ex) {
            return line;
        }
        try { //Get number of bytes transmitted in this line.
            String[] lineSplit = line.split(" ");
            hostnameWithBytes += " " + lineSplit[lineSplit.length - 1];
        }
        catch (PatternSyntaxException ex) {
            return line;
        }
        return hostnameWithBytes;
    }
}
