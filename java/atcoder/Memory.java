package atcoder;

public class Memory {
	public static void main(String[] args) throws Exception {
		long m1 = Runtime.getRuntime().maxMemory() / 1024 / 1024;
		long m2 = Runtime.getRuntime().totalMemory() / 1024 / 1024;
		long m3 = Runtime.getRuntime().freeMemory() / 1024 / 1024;
		System.out.println("maxMemory: " + m1 + "MB");
		System.out.println("totalMemory: " + m2 + "MB");
		System.out.println("freeMemory: " + m3 + "MB");
		System.out.println("usedMemory: " + (m2-m3) + "MB");
	}
}
