package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapLRU5 extends LinkedHashMap {
    public LinkedHashMapLRU5() { super(); }
    public LinkedHashMapLRU5(int i, float f, boolean b) { super(i, f, b); }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > 5;
    }

    public static void main(String[] args) {
        test(new LinkedHashMapLRU5(16, 0.75f, true));
    }
    static void test(Map map) {
        for (int i=0; i<5; i++) {
            map.put(i, i);
        }
        System.out.println(map);
        map.get(1);
        map.get(3);
        System.out.println(map);
        map.put(5, 5);
        map.put(6, 6);
        map.put(7, 7);
        System.out.println(map);
        map.get(1);
        map.get(3);
        map.get(5);
        map.get(7);
        System.out.println(map);
    }
}
