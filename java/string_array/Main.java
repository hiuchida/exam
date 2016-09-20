package string_array;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        StringArray sa = new StringArray();
        sa.add("one");
        sa.add("two");
        sa.add("three");
        System.out.println("" + sa);
        sa.save("test.txt");
        sa.clear();
        sa.load("test.txt");
        System.out.println("" + sa);
        StringArray sa2 = new StringArray(10);
        System.out.println("" + sa2);
        StringArray sa3 = new StringArray(sa);
        System.out.println("" + sa3);
    }
}
