import java.io.*;
import java.util.*;
import java.util.jar.*;

public class JarList {
    public static void main(String[] args) throws IOException {
        JarFile jf = new JarFile("opencsv-1.8.jar");
        for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
            JarEntry je = e.nextElement();
            System.out.println("" + je.getName());
        }
    }
}
