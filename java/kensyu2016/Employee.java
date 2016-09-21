package kensyu2016;

public class Employee extends Person {
    private static int teinen = 60;
    
    public static void setTeinen(int teinen) {
        Employee.teinen = teinen;
    }
    
    public Employee() {
        super();
    }
    
    public Employee(String name, int age) {
        super(name, age, null);
        //super.age
    }
}
