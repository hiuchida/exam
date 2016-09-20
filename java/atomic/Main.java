package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        noSync();
        long end = System.currentTimeMillis();
        System.out.println("noSync: " + (end - start) + "ms");
        
        start = System.currentTimeMillis();
        sync();
        end = System.currentTimeMillis();
        System.out.println("sync: " + (end - start) + "ms");
        
        start = System.currentTimeMillis();
        atomic();
        end = System.currentTimeMillis();
        System.out.println("atomic: " + (end - start) + "ms");
    }
    static void noSync() {
        int val = 0;
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            val++;
        }
    }
    static void sync() {
        int val = 0;
        Object sync = new Object();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            synchronized(sync) {
                val++;
            }
        }
    }
    static void atomic() {
        AtomicInteger ai = new AtomicInteger();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            ai.incrementAndGet();
        }
    }
}
