import java.util.*;

class MyClass {
    byte a;
    int c;
    boolean d;
    long e;
    Object f;
}

class A3 {
    long a;
    int b;
    int c;
}

class B3 extends A3 {
    long d;
}

class A4 {
    byte a;
}

class B4 extends A4 {
    byte b;
}

class A5 {
    byte a;
}

class B5 extends A5 {
    long b;
    short c;
    byte d;
}

public class HprofTest {
    static List list = new ArrayList();
    
    public static void main(String[] args) {
        add(new MyClass());
        add(new Boolean(true));
        add(new A3());
        add(new B3());
        add(new A4());
        add(new B4());
        add(new A5());
        add(new B5());
        add(new byte[3]);
        add(new long[3]);
        add("");
        add("1");
        add("12");
        add("123");
        add("1234");
        add("12345");
        add("123456");
        add("1234567");
        add("12345678");
        add("123456789");
    }
    
    static void add(Object o) {
        System.out.println("" + o + " : " + getObjectSize(o) + "B");
        list.add(o);
    }
    
    static long getObjectSize(Object o) {
        if (Agent.getInstrumentation() != null) {
            return Agent.getInstrumentation().getObjectSize(o);
        }
        return 0;
    }
}
