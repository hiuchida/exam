package weak;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class MapTest {
    public static void main(String[] args) {
        Map<Object,Object> map1 = new HashMap<>();
        test(map1);
        Map<Object,Object> map2 = new WeakHashMap<>();
        test(map2);
    }
    
    static void test(Map<Object,Object> map) {
        System.out.println(map.getClass().getName());
        map.put(new String("key"), new String("value"));
        System.out.println(map.toString());
        System.out.println("gc");
        System.gc();
        System.out.println(map.toString());
        System.out.println("");
    }
}
