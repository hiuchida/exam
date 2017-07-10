package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Q4BI {
	static boolean bElapsed = true;

	static final int NUM10_6 = 1000 * 1000;
	static long[] cnt;

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		init(line.length());
		BigInteger sum = BigInteger.ZERO;
		for (int i = 0; i < line.length(); i++) {
			String str = line.substring(0, line.length() - i);
			BigInteger val = new BigInteger(str);
			val = val.multiply(BigInteger.valueOf(cnt[i]));
			sum = sum.add(val);
		}
		System.out.println(sum);
	}

	static void init(int len) {
		cnt = new long[len];
		for (int i = 0; i < cnt.length; i++) {
			if (i < 2)
				cnt[i] = i + 1;
			else
				cnt[i] = cnt[i - 1] * 3;
		}
	}

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solve(in);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end - start) + "ms");
		}
	}
}
