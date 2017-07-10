/*
 * D - 問題４：「+-組み合わせ計算」
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4 {
	static boolean bElapsed = true;

	static final int NUM10_6 = 1000 * 1000;
	static int[] cnt;

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		init(line.length());
		int sum = 0;
		for (int i = 0; i < line.length(); i++) {
			String str = line.substring(0, line.length() - i);
			if (str.length() > 6)
				str = str.substring(str.length() - 6);
			int val = Integer.parseInt(str);
			long mul = (long)cnt[i] * val;
			sum = (int)((sum + mul) % NUM10_6);
		}
		System.out.println(sum);
	}

	static void init(int len) {
		cnt = new int[len];
		for (int i = 0; i < cnt.length; i++) {
			if (i < 2)
				cnt[i] = i + 1;
			else
				cnt[i] = (cnt[i - 1] * 3) % NUM10_6;
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
