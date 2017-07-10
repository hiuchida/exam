/*
 * B - 問題２：「２文字のランキング」
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2 {
	static boolean bElapsed = true;

	static void solve(BufferedReader in) throws IOException {
		Counter[] tbl = new Counter[26*26];
		for (int i = 'A'; i <= 'Z'; i++) {
			for (int j = 'A'; j <= 'Z'; j++) {
				String id = String.format("%c%c", i, j);
				int idx = (i - 'A') * 26 + (j - 'A');
				tbl[idx] = new Counter(id);
			}
		}
		int preCh = 0;
		while (true) {
			int ch = in.read();
			if (ch == -1)
				break;
			if ('A' <= preCh && preCh <= 'Z') {
				if ('A' <= ch && ch <= 'Z') {
					int idx = (preCh - 'A') * 26 + (ch - 'A');
					tbl[idx].inc();
				}
			}
			preCh = ch;
		}
		Arrays.sort(tbl);
		int i;
		for (i = 0; i < 10; i++) {
			Counter c = tbl[i];
			if (c.isZero())
				break;
			System.out.println(c);
		}
		if (i == 0)
			System.out.println("");
	}

	static class Counter implements Comparable<Counter> {
		String id;
		int cnt;

		Counter(String id) {
			this.id = id;
		}

		void inc() {
			cnt++;
		}

		boolean isZero() {
			return cnt == 0;
		}

		public String toString() {
			return id + " " + cnt;
		}

		public int compareTo(Counter o) {
			int cmp = Integer.compare(cnt, o.cnt);
			if (cmp != 0)
				return -cmp;
			return id.compareTo(o.id);
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
