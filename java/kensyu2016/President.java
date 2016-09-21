package kensyu2016;

public class President extends Person {
    private static President singleton = new President();
    
    public static President getInstance() {
        return singleton;
    }
    
    private President() {}
}
