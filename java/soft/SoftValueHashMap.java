package soft;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class SoftValueHashMap<K,V> implements Map<K,V> {
    private HashMap<K,SoftReference<V>> map = new HashMap<K,SoftReference<V>>();
    private ReferenceQueue<Object> queue = new ReferenceQueue<>();
    
    class Entry<K, V> implements Map.Entry<K, V> {
        K key;
        V value;
        int hash;
        
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = key != null ? key.hashCode() : 0;
        }
        
        public K getKey() {
            return key;
        }
        
        public V getValue() {
            return value;
        }
        
        public V setValue(V value) {
            this.value = value;
            return this.value;
        }
        
        public boolean equals(Object o) {
            if (!(o instanceof Map.Entry))
                return false;
            Map.Entry e = (Map.Entry)o;
            Object k1 = getKey();
            Object k2 = e.getKey();
            if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                Object v1 = getValue();
                Object v2 = e.getValue();
                if (v1 == v2 || (v1 != null && v1.equals(v2)))
                    return true;
            }
            return false;
        }
        
        public int hashCode() {
            return hash;
        }
    }
    
    private void expungeStaleEntries() {
        while (true) {
            Object x = queue.poll();
            if (x == null) {
                break;
            }
            Set<Map.Entry<K, SoftReference<V>>> entrySet = map.entrySet();
            K key = null;
            for (Map.Entry<K, SoftReference<V>> e : entrySet) {
                if (e.getValue() == x) {
                    key = e.getKey();
                    break;
                }
            }
            if (key != null) {
                map.remove(key);
            }
        }
    }
    
    public String toString() {
        expungeStaleEntries();
        Iterator<Map.Entry<K,V>> i = entrySet().iterator();
        if (! i.hasNext())
            return "{}";

        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (;;) {
            Map.Entry<K,V> e = i.next();
            K key = e.getKey();
            V value = e.getValue();
            sb.append(key   == this ? "(this Map)" : key);
            sb.append('=');
            sb.append(value == this ? "(this Map)" : value);
            if (! i.hasNext())
                return sb.append('}').toString();
            sb.append(',').append(' ');
        }
    }
    
    public int size() {
        expungeStaleEntries();
        return map.size();
    }
    
    public boolean isEmpty() {
        expungeStaleEntries();
        return map.isEmpty();
    }
    
    public boolean containsKey(Object key) {
        expungeStaleEntries();
        return containsKey(key);
    }
    
    public boolean containsValue(Object value) {
        expungeStaleEntries();
        return containsValue(value);
    }
    
    public V get(Object key) {
        expungeStaleEntries();
        if (map.get(key) == null) {
            return null;
        }
        return map.get(key).get();
    }
    
    public V put(K key, V value) {
        expungeStaleEntries();
        SoftReference<V> o = map.put(key, new SoftReference(value, queue));
        return o != null ? o.get() : null;
    }
    
    public V remove(Object key) {
        expungeStaleEntries();
        return map.remove(key).get();
    }
    
    public void putAll(Map<? extends K, ? extends V> m) {
        expungeStaleEntries();
        for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
            put(e.getKey(), e.getValue());
        }
    }
    
    public void clear() {
        expungeStaleEntries();
        map.clear();
    }
    
    public Set<K> keySet() {
        expungeStaleEntries();
        return map.keySet();
    }
    
    public Collection<V> values() {
        expungeStaleEntries();
        ArrayList<V> ary = new ArrayList<V>();
        Collection<SoftReference<V>> vals = map.values();
        for (SoftReference<V> v : vals) {
            if (v != null && v.get() != null) {
                ary.add(v.get());
            }
        }
        return ary;
    }
    
    public Set<Map.Entry<K, V>> entrySet() {
        expungeStaleEntries();
        HashSet<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
        Set<Map.Entry<K, SoftReference<V>>> entrySet = map.entrySet();
        for (Map.Entry<K, SoftReference<V>> e : entrySet) {
            if (e.getValue() != null) {
                Map.Entry<K, V> entry = new Entry<K, V>(e.getKey(), e.getValue().get());
                set.add(entry);
            }
        }
        return set;
    }
    
    public boolean equals(Object o) {
        expungeStaleEntries();
        return map.equals(o);
    }
    
    public int hashCode() {
        expungeStaleEntries();
        return map.hashCode();
    }
}
