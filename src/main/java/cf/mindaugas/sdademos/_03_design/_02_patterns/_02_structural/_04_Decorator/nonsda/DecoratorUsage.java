package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._04_Decorator.nonsda;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class DecoratorUsage {
    public static void main(String[] args) throws Exception {
        File file = new File("./output.txt");
        file.createNewFile();

        // File output stream is a decorator for File object
        OutputStream oStream = new FileOutputStream(file);

        // DataOutputStream decorates OutputStream
        DataOutputStream doStream = new DataOutputStream(oStream);
        doStream.writeChars("text");

        doStream.close();
        oStream.close();
    }
}
