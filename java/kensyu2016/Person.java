package kensyu2016;

public class Person implements Comparable<Person> {
	public int compareTo(Person p) {
		return name.compareTo(p.name);
	}
    
    private String name;
    private int age;
    private String[] hobby;

    public Person() {
        name = "";
    }
    
    public Person(String name, int age, String[] hobby) {
        this();
        setName(name);
        setAge(age);
        this.hobby = hobby;
    }
    
    public String toString() {
    	return "name=" + name + ", age=" + age;
    }

    public void setName(String name) {
        if (name == null) return;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        if (age < 0) return;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }
    
    public String[] getHobby() {
    	return hobby;
    }
}
