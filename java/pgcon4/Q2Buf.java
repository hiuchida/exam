package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q2Buf {
	static boolean bElapsed = true;
	//54/77-12-11
	static void solve(BufferedReader in) throws IOException {
		Map<Pair, Counter> map = new HashMap<>();
		for (char i = 'A'; i <= 'Z'; i++) {
			for (char j = 'A'; j <= 'Z'; j++) {
				String id = String.format("%c%c", i, j);
				Pair pair = new Pair(i, j);
				map.put(pair, new Counter(id));
			}
		}
		char[] buf = new char[8096];
		int preCh = 0;
		while (true) {
			int len = in.read(buf);
			if (len == -1)
				break;
			for (int i=0; i<len; i++) {
				int ch = buf[i];
				if ('A' <= preCh && preCh <= 'Z') {
					if ('A' <= ch && ch <= 'Z') {
						//String id = String.format("%c%c", preCh, ch);
						//StringBuilder sb = new StringBuilder();
						//sb.append((char)preCh);
						//sb.append((char)ch);
						//String id = sb.toString();
						Pair pair = new Pair(preCh, ch);
						map.get(pair).inc();
					}
				}
				preCh = ch;
			}
		}
		List<Counter> list = new ArrayList<>(map.values());
		Collections.sort(list);
		for (int i = 0; i < 10; i++) {
			Counter c = list.get(i);
			if (c.isZero())
				break;
			System.out.println(c);
		}
	}

	static class Pair {
		int ch1;
		int ch2;
		
		Pair(int ch1, int ch2) {
			this.ch1 = ch1;
			this.ch2 = ch2;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ch1;
			result = prime * result + ch2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (ch1 != other.ch1)
				return false;
			if (ch2 != other.ch2)
				return false;
			return true;
		}
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
