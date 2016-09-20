package atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger();
        long start = System.currentTimeMillis();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            ai.incrementAndGet();
        }
        long end = System.currentTimeMillis();
        System.out.println("" + (end - start) + "ms");
    }
}
