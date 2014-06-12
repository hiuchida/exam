import java.util.concurrent.atomic.*;

public class Atomic {
    static AtomicInteger ai = new AtomicInteger();
    public static void main(String[] args) throws Exception {
        CountThread[] thread = new CountThread[10];
        for (int i=0; i<thread.length; i++) {
            thread[i] = new CountThread();
        }
        long start = System.currentTimeMillis();
        for (int i=0; i<thread.length; i++) {
            thread[i].start();
        }
        for (int i=0; i<thread.length; i++) {
            thread[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("" + (end - start) + "ms");
        System.out.println("val=" + ai.get() + ", Integer.MAX_VALUE/10*10=" + Integer.MAX_VALUE/10*10);
    }
    static class CountThread extends Thread {
        public void run() {
            for (int i=0; i<Integer.MAX_VALUE/10; i++) {
                ai.incrementAndGet();
            }
        }
    }
}
