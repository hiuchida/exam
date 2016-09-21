package kensyu2016;

import java.util.Arrays;

public class Main {
	enum Status { STOP, START };

    public static void main(String[] args) {
    	Person[] ary = new Person[2];
    	ary[0] = new Person(null, -42, new String[] { "食う", "寝る" });
    	ary[1] = new Person(null, -42, new String[] { "食う", "寝る" });
        Person p = new Person(null, -42, new String[] { "食う", "寝る" });
        //p.name = null; //error
        //p.age = -42; //error
        p.setName(null);
        p.setAge(-42);
        System.out.println(Arrays.toString(p.getHobby()));
        System.out.println(p.getHobby());
        System.out.println(p.getHobby().hashCode());
        Employee.setTeinen(65);
        President.getInstance().setName("Uchida");
        Status status = Status.STOP;
        switch (status) {
        case STOP:
        case START:
        	break;
        }
        new Main().func(null);
        new Main().func(1);
        new Main().func(1.0);
        long m1 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        long m2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        long m3 = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println(m1 + ", " + m2 + ", " + m3);
        System.gc();
        System.gc();
        System.gc();
        m1 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        m2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        m3 = Runtime.getRuntime().freeMemory() / 1024 / 1024;
        System.out.println(m1 + ", " + m2 + ", " + m3);
        System.out.println(Integer.parseInt("FF", 16));
    }
    
    void func(Person p) {
    	System.out.println("Person");
    }
    
    void func(Employee r) {
    	System.out.println("Employee");
    }
    
    void func(byte i) {
    	System.out.println("byte");
    }

    void func(short i) {
    	System.out.println("short");
    }

    void func(int i) {
    	System.out.println("int");
    }
    
    void func(long i) {
    	System.out.println("long");
    }
    
    void func(char i) {
    	System.out.println("char");
    }
    
    void func(float i) {
    	System.out.println("float");
    }
    
    void func(double i) {
    	System.out.println("double");
    }
    
}
