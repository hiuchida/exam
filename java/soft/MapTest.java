import java.lang.ref.*;
import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<Object,Object> map1 = new HashMap<>();
        test(map1);
        Map<Object,SoftReference<Object>> map3 = new HashMap<Object,SoftReference<Object>>();
        test2(map3);
        Map<Object,Object> map4 = new SoftValueHashMap<Object,Object>();
        test(map4);
    }
    
    static void test(Map<Object,Object> map) {
        System.out.println(map.getClass().getName());
        map.put(new String("key"), new String("value"));
        System.out.println("key=" + map.get("key"));
        System.out.println(map.toString());
        System.out.println("gc");
        System.gc();
        System.out.println("key=" + map.get("key"));
        System.out.println(map.toString());
        System.out.println("");
    }
    
    static void test2(Map<Object,SoftReference<Object>> map) {
        System.out.println(map.getClass().getName());
        map.put(new String("key"), new SoftReference<Object>(new String("value")));
        System.out.println("key=" + map.get("key").get());
        System.out.println("gc");
        System.gc();
        System.out.println("key=" + map.get("key").get());
        System.out.println("");
    }
}
