import java.util.*;

public class LinkedHashMapAO extends LinkedHashMap {
    public static void main(String[] args) {
        test(new LinkedHashMap(16, 0.75f, false));
        System.out.println("");
        test(new LinkedHashMap(16, 0.75f, true));
    }
    static void test(Map map) {
        for (int i=0; i<10; i++) {
            map.put(i, i);
        }
        for (int i=0; i<10; i++) {
            map.get(10-i-1);
            System.out.println(map);
        }
    }
}
