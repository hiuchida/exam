import java.util.concurrent.atomic.*;

public class Main {
    static int noSyncVal = 0;
    static int syncVal = 0;
    static Object sync = new Object();
    static AtomicInteger ai = new AtomicInteger();
    public static void main(String[] args) throws Exception {
        System.out.println("noSync:");
        NoSyncThread[] noSyncThread = new NoSyncThread[10];
        for (int i=0; i<noSyncThread.length; i++) {
            noSyncThread[i] = new NoSyncThread();
        }
        test(noSyncThread);
        System.out.println("noSyncVal=" + noSyncVal + ", Integer.MAX_VALUE/10*10=" + Integer.MAX_VALUE/10*10);
        System.out.println("");
        
        System.out.println("sync:");
        SyncThread[] syncThread = new SyncThread[10];
        for (int i=0; i<syncThread.length; i++) {
            syncThread[i] = new SyncThread();
        }
        test(syncThread);
        System.out.println("syncVal=" + syncVal + ", Integer.MAX_VALUE/10*10=" + Integer.MAX_VALUE/10*10);
        System.out.println("");
        
        System.out.println("atomic:");
        AtomicThread[] atomicThread = new AtomicThread[10];
        for (int i=0; i<atomicThread.length; i++) {
            atomicThread[i] = new AtomicThread();
        }
        test(atomicThread);
        System.out.println("atomicVal=" + ai.get() + ", Integer.MAX_VALUE/10*10=" + Integer.MAX_VALUE/10*10);
        System.out.println("");
    }
    static void test(Thread[] thread) throws Exception {
        long start = System.currentTimeMillis();
        for (int i=0; i<thread.length; i++) {
            thread[i].start();
        }
        for (int i=0; i<thread.length; i++) {
            thread[i].join();
        }
        long end = System.currentTimeMillis();
        System.out.println("" + (end - start) + "ms");
    }
    static class NoSyncThread extends Thread {
        public void run() {
            for (int i=0; i<Integer.MAX_VALUE/10; i++) {
                noSyncVal++;
            }
        }
    }
    static class SyncThread extends Thread {
        public void run() {
            for (int i=0; i<Integer.MAX_VALUE/10; i++) {
                synchronized(sync) {
                    syncVal++;
                }
            }
        }
    }
    static class AtomicThread extends Thread {
        public void run() {
            for (int i=0; i<Integer.MAX_VALUE/10; i++) {
                ai.incrementAndGet();
            }
        }
    }
}
