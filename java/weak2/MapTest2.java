import java.lang.ref.*;
import java.util.*;

public class MapTest2 {
    public static void main(String[] args) {
        Map<Object,SoftReference<Object>> map = new HashMap<Object,SoftReference<Object>>();
        test(map, 70*1000);
        test(map, 80*1000);
    }
    
    static void test(Map<Object,SoftReference<Object>> map, int maxCount) {
        System.out.println(map.getClass().getName());
        for (int i=0; i<maxCount; i++) {
            map.put(new String("key"+i), new SoftReference<Object>(new String("value"+i)));
        }
        System.out.println("map.size()=" + map.size());
        int size = 0;
        for (Object key : map.keySet()) {
            if (map.get(key).get() != null) size++;
        }
        System.out.println("softRef size=" + size);
        System.out.println("");
    }
}
