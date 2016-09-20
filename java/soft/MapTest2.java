package soft;

import java.lang.ref.SoftReference;
import java.util.Map;

public class MapTest2 {
    static final String VALUE;
    static {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<20*1000; i++) {
            sb.append("value");
        }
        VALUE = sb.toString();
    }
    
    public static void main(String[] args) {
        Map<Object, Object> map = new SoftValueHashMap<Object, Object>();
        test(map, 60);
        map.clear();
        test(map, 70);
    }
    
    static void test(Map<Object,Object> map, int maxCount) {
        System.out.println(map.getClass().getName());
        for (int i=0; i<maxCount; i++) {
            map.put(new String("key"+i), new SoftReference<Object>(new String(VALUE+i)));
        }
        System.out.println("map.size()=" + map.size());
        int size = 0;
        for (Object key : map.keySet()) {
            if (map.get(key) != null) size++;
        }
        System.out.println("softRef size=" + size);
        System.out.println("");
    }
}
