/*
 * C - 問題３：「倉庫番２０１７」
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q3 {
	static boolean bElapsed = true;

	static int lvl = 2;
	
	static List<Pair> list = new ArrayList<>();

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		String[] cols = line.split(" ");
		int n = Integer.parseInt(cols[0]);
		if (lvl == 1 && n != 3) {
			System.out.println(0);
			return;
		}
		int m = Integer.parseInt(cols[1]);
		for (int i = 0; i < n; i++) {
			line = in.readLine();
			cols = line.split(" ");
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(cols[j]);
				int w = (i + 1) * (j + 1);
				list.add(new Pair(w, v));
			}
		}
		int maxVal = dfs(0, m, 0);
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

	static int dfs(int i, int m, int v) {
		if (m < 0)
			return 0;
		if (i >= list.size())
			return v;
		Pair p = list.get(i);
		int v1 = dfs(i + 1, m, v);
		int v2 = dfs(i + 1, m - p.w, v + p.v);
		return Math.max(v1, v2);
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
