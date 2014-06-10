public class Sync {
    public static void main(String[] args) {
        int val = 0;
        Object sync = new Object();
        long start = System.currentTimeMillis();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            synchronized(sync) {
                val++;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("" + (end - start) + "ms");
    }
}
