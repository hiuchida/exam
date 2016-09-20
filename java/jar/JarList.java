package jar;

import java.io.IOException;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class JarList {
    public static void main(String[] args) throws IOException {
        JarFile jf = new JarFile("opencsv-1.8.jar");
        for (Enumeration<JarEntry> e = jf.entries(); e.hasMoreElements(); ) {
            JarEntry je = e.nextElement();
            System.out.println("" + je.getName());
        }
        jf.close();
    }
}
