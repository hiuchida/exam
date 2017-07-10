package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3Detail {
	static boolean bElapsed = true;

	static List<Pair> mstList = new ArrayList<>();
	static List<Pair> tmpList = new ArrayList<>();
	static List<Selection> selList = new ArrayList<>();

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		String[] cols = line.split(" ");
		int n = Integer.parseInt(cols[0]);
		int m = Integer.parseInt(cols[1]);
		for (int i = 0; i < n; i++) {
			line = in.readLine();
			cols = line.split(" ");
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(cols[j]);
				int w = (i + 1) * (j + 1);
				mstList.add(new Pair(w, v));
			}
		}
		int maxVal = dfs(0, m, 0);
		System.out.println(maxVal);
		print();
	}

	static class Pair {
		int w;
		int v;

		Pair(int w, int v) {
			this.w = w;
			this.v = v;
		}
		
		public String toString() {
			return String.format("(%2d,%3d)", w, v);
		}
	}
	
	static class Selection implements Comparable<Selection> {
		List<Pair> list;
		int w;
		int v;
		
		Selection(List<Pair> l) {
			list = new ArrayList<>(l);
			for (Pair p : list) {
				w += p.w;
				v += p.v;
			}
		}
		
		@Override
		public int compareTo(Selection o) {
			int cmp = Integer.compare(w, o.w);
			if (cmp != 0) return cmp;
			return Integer.compare(v, o.v);
		}

		public String toString() {
			return String.format("%3d,%4d %s", w, v, list.toString());
		}
	}

	static int dfs(int i, int m, int v) {
		//if (m < 0)
		//	return 0;
		if (i >= mstList.size()) {
			Selection sel = new Selection(tmpList);
			selList.add(sel);
			return (m < 0) ? 0 : v;
		}
		Pair p = mstList.get(i);
		int v1 = dfs(i + 1, m, v);
		tmpList.add(p);
		int v2 = dfs(i + 1, m - p.w, v + p.v);
		tmpList.remove(tmpList.size() - 1);
		return Math.max(v1, v2);
	}
	
	static void print() {
		Collections.sort(selList);
		for (Selection s : selList) {
			System.out.println(s);
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
