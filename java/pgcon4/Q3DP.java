package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3DP {
	static boolean bElapsed = true;

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		String[] cols = line.split(" ");
		int n = Integer.parseInt(cols[0]);
		int m = Integer.parseInt(cols[1]);
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			line = in.readLine();
			cols = line.split(" ");
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(cols[j]);
				int w = (i + 1) * (j + 1);
				list.add(new Pair(w, v));
			}
		}
		int[] dp = new int[m * n * n + 1];
		for (int i = 0; i < n; i++) {
			Pair p = list.get(i);
			for (int j = m * n * n; j >= p.w; j--) {
				dp[j] = Math.max(dp[j], dp[j - p.w] + p.v);
			}
		}
		int maxVal = 0;
		for (int i = m; i >= 0; i--) {
			if (dp[i] > maxVal)
				maxVal = dp[i];
		}
		System.out.println(maxVal);
	}

	static class Pair {
		int w;
		int v;

		Pair(int w, int v) {
			this.w = w;
			this.v = v;
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
