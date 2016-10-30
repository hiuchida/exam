package atcoder.agc006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class F {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Point> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<Integer,Set<Integer>> map = new HashMap<>();
	long cnt = 0;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int m = Integer.parseInt(flds[1]);
		for (int i=0; i<m; i++) {
			line = br.readLine();
			flds = line.split(" ");
			int a = Integer.parseInt(flds[0]);
			int b = Integer.parseInt(flds[1]);
			Point p = new Point(a, b);
			list.add(p);
			add(a, b);
		}
		while (list.size() > 0) {
			Point p = list.remove(list.size()-1);
			Set<Integer> set = map.get(p.b);
			if (set != null) {
				for (int i : set) {
					if (add(i, p.a)) {
						list.add(new Point(i, p.a));
					}
				}
			}
		}
		pln(cnt);
	}
	boolean add(int a, int b) {
		Set<Integer> set = map.get(a);
		if (set == null) {
			set = new HashSet<>();
			map.put(a, set);
		}
		if (!set.contains(b)) {
			set.add(b);
			cnt++;
			return true;
		}
		return false;
	}

	class Point {
		int a;
		int b;
		public Point(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	void p(char c) {
		System.out.print(c);
	}
	void pln(char c) {
		System.out.println(c);
	}
	void p(long l) {
		System.out.print(l);
	}
	void pln(long l) {
		System.out.println(l);
	}
	void p(String s) {
		System.out.print(s);
	}
	void pln(String s) {
		System.out.println(s);
	}
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new F().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
