package file;

import java.io.File;

public class FileList {
    public static void main(String[] args) {
        File dir = new File("..");
        execute(dir);
    }
    static void execute(File dir) {
        for (File f : dir.listFiles()) {
            if (f.isDirectory()) {
                System.out.println("D " + f);
                execute(f);
            } else if (f.isFile()) {
                System.out.println("F " + f);
            }
        }
    }
}
