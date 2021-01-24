package cf.mindaugas.sdademos._03_design._02_patterns._02_structural._05_Facade.nonsda;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;

public class _01_FacadeUsage {
    public static void main(String args[]) throws Exception {
        // ... URL hides a lot behind it, but we just interact with a nice facade ...
        URL url = new URL("https", "www.delfi.lt", 443, "/");
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
    }
}
