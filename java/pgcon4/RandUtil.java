package pgcon4;

import java.util.Random;

public class RandUtil {
	static Random r = new Random();

	static int rand(int max) {
		return r.nextInt(max);
	}
	
	static String rand1_9() {
		int v = r.nextInt(9) + 1;
		return Integer.toString(v);
	}
	
	static String rand0_9() {
		int v = r.nextInt(10);
		return Integer.toString(v);
	}
	
	static String rand_AZ() {
		int v = r.nextInt(26);
		return String.valueOf((char)(v + 'A'));
	}
	
	static String rand_base64() {
		int v = r.nextInt(64);
		return String.valueOf(base64Encode(v));
	}
	
	static char base64Encode(int v) {
		if (0 <= v && v <= 25) {
			return (char) ('A' + v);
		} else if (26 <= v && v <= 51) {
			return (char) ('a' + v - 26);
		} else if (52 <= v && v <= 61) {
			return (char) ('0' + v - 52);
		} else if (v == 62) {
			return '+';
		} else if (v == 63) {
			return '/';
		}
		throw new RuntimeException("base64Encode v=" + v);
	}
	
}
