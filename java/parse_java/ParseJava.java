import java.io.*;

public class ParseJava {
    public static void main(String[] args) {
        execute("ParseJava.java");
    }
    static final String S_PACKAGE = "package ";
    static final String S_IMPORT = "import ";
    static final String S_PUBLIC_CLASS = "public class ";
    static final String S_CLASS = "class ";
    static void execute(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                if (line.startsWith(S_PACKAGE)) {
                    parsePackage(line);
                } else if (line.startsWith(S_IMPORT)) {
                    parseImport(line);
                } else if (line.startsWith(S_PUBLIC_CLASS)) {
                    parsePublicClass(line);
                } else if (line.startsWith(S_CLASS)) {
                    parseClass(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void parsePackage(String line) {
        line = line.substring(S_PACKAGE.length());
        System.out.println("P " + line);
    }
    static void parseImport(String line) {
        line = line.substring(S_IMPORT.length());
        int idx = line.indexOf(";");
        if (idx >= 0) line = line.substring(0, idx);
        line = line.trim();
        System.out.println("I " + line);
    }
    static void parsePublicClass(String line) {
        line = line.substring(S_PUBLIC_CLASS.length());
        int idx = line.indexOf("{");
        if (idx >= 0) line = line.substring(0, idx);
        line = line.trim();
        System.out.println("PC " + line);
    }
    static void parseClass(String line) {
        line = line.substring(S_CLASS.length());
        int idx = line.indexOf("{");
        if (idx >= 0) line = line.substring(0, idx);
        line = line.trim();
        System.out.println("C " + line);
    }
}
