import java.io.*;
import java.util.*;

public class StringArray extends ArrayList<String> {
    static final String UTF8 = "UTF-8";
    static final String EOL = "\n";
    public StringArray() {
        super();
    }
    public StringArray(int i) {
        super(i);
    }
    public StringArray(Collection c) {
        super(c);
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("---").append(EOL);
        for (String s : this) {
            sb.append(s).append(EOL);
        }
        sb.append("---");
        return sb.toString();
    }
    public void save(String filepath) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filepath), UTF8))) {
            for (String s : this) {
                bw.write(s);
                bw.newLine();
            }
        }
    }
    public void load(String filepath) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filepath), UTF8))) {
            while (true) {
                String line = br.readLine();
                if (line == null) break;
                this.add(line);
            }
        }
    }
}
