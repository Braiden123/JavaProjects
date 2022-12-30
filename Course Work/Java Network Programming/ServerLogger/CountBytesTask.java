/*
Code is based on LookupTask.java from Java Network Programming, 4th edition by Elliotte Rusty Harold, page 115.
 */
import java.util.concurrent.Callable;
import java.util.regex.PatternSyntaxException;

public class CountBytesTask implements Callable<String>{
    private String line;

    public CountBytesTask(String line) {
        this.line = line;
    }

    @Override
    public String call() {
        try {
            //Find the bytes transmitted.
            try {
                String[] splitLine = line.split(" ");
                return splitLine[splitLine.length - 1];
            }
            catch (PatternSyntaxException ex) { //Error getting the bytes transmitted send 0 bytes.
                return "0";
            }
        }
        catch (Exception ex) { //No bytes found in line, return 0.
            return "0";
        }
    }
}
