package weak;

import java.util.Map;
import java.util.WeakHashMap;

public class MapTest2 {
    public static void main(String[] args) {
        Map<Object,Object> map = new WeakHashMap<>();
        test(map);
    }
    
    static void test(Map<Object,Object> map) {
        String[] keys = new String[4];
        String[] vals = new String[4];
        System.out.println(map.getClass().getName());
        for (int i=0; i<keys.length; i++) {
            keys[i] = new String("key" + i);
            vals[i] = new String("val" + i);
            map.put(keys[i], vals[i]);
        }
        System.out.println(map.toString());
        System.out.println("gc");
        System.gc();
        System.out.println(map.toString());
        keys[1] = null;
        vals[2] = null;
        keys[3] = null;
        vals[3] = null;
        System.out.println("gc");
        System.gc();
        System.out.println(map.toString());
        System.out.println("");
    }
}
