/*
Code is based on LookupTask.java from Java Network Programming, 4th edition by Elliotte Rusty Harold, page 115.
 */
import java.net.*;
import java.util.concurrent.Callable;

public class GetHostTask implements Callable<String>{
    private String line;

    public GetHostTask(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        try {
            // separate out the IP address
            int index = line.indexOf(' ');
            String address = line.substring(0, index);
            return InetAddress.getByName(address).getHostName();
        }
        catch (Exception ex) {
            return line;
        }
    }
}
