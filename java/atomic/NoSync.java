package atomic;

public class NoSync {
    public static void main(String[] args) {
        int val = 0;
        long start = System.currentTimeMillis();
        for (int i=0; i<Integer.MAX_VALUE; i++) {
            val++;
        }
        long end = System.currentTimeMillis();
        System.out.println("" + (end - start) + "ms");
    }
}
