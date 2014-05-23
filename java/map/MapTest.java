import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        test(new HashMap());
        test(new TreeMap());
        test(new LinkedHashMap());
    }
    static void test(Map map) {
        System.out.println(map.getClass().toString());
        test(map, 1, 1);
        test(map, 40, 2);
        test(map, 70, 3);
        test(map, 100, 4);
        test(map, 3, 5);
        test(map, 2, 6);
        test(map, 8, 7);
        test(map, 6, 8);
        test(map, 9, 9);
        test(map, 5, 10);
    }
    static void test(Map map, int key, int value) {
        map.put(key, value);
        System.out.println(map);
    }
}
