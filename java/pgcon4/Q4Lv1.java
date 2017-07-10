/*
 * D - 問題４：「+-組み合わせ計算」　総あたり部分点
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4Lv1 {
	static boolean bElapsed = true;

	static final int NUM10_6 = 1000 * 1000;
	
	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		long sum = dfs(line, 0, "") % NUM10_6;
		System.out.println(sum);
	}
	
	static long dfs(String line, int idx, String exp) {
		if (idx == line.length()) {
			return calc(exp);
		}
		long sum = 0;
		sum += dfs(line, idx + 1, exp + line.substring(idx, idx + 1));
		if (idx > 0) {
			sum += dfs(line, idx + 1, exp + "+" + line.substring(idx, idx + 1));
			sum += dfs(line, idx + 1, exp + "-" + line.substring(idx, idx + 1));
		}
		return sum;
	}
	
	static long calc(String exp) {
		long sum = 0;
		long val = 0;
		long sign = 1;
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
			if ('0' <= ch && ch <= '9') {
				val = val * 10 + (ch - '0');
			} else if (ch == '+') {
				sum += val * sign;
				val = 0;
				sign = 1;
			} else if (ch == '-') {
				sum += val * sign;
				val = 0;
				sign = -1;
			}
		}
		sum += val * sign;
		//System.out.println(exp + "=" + sum);
		return sum;
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
