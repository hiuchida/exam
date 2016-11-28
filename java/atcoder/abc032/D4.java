package atcoder.abc032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D4 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;
	List<Point> list = new ArrayList<>();
	Map<Point,Long> map = new HashMap<>();
	long[][] dp;
	int n;
	int w;

	long dfs(int i, int w) {
		Point key = new Point(i, w);
		Long v = map.get(key);
		if (v != null) return v;
		if (i >= n) return 0;
		Point pt = list.get(i);
		if (w < pt.y) {
			long r = dfs(i+1, w);
			map.put(key, r);
			return r;
		}
		long r1 = dfs(i+1, w);
		long r2 = dfs(i+1, w-pt.y)+pt.x;
		long r = Math.max(r1, r2);
		map.put(key, r);
		return r;
	}
	long solve2() {
		int v = 1000;
		dp = new long[n+1][n*v+1];
		for (int i=n-1; i>=0; i--) {
			Point pt = list.get(i);
			for (int j=0; j<=n*v; j++) {
				if (j < pt.y) dp[i][j] = dp[i+1][j];
				else dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j-pt.y]+pt.x);
			}
		}
		return dp[0][w];
	}
	long solve3() {
		int v = 1000;
		dp = new long[n+1][n*v+1];
		dp[0][0] = 0;
		for (int i=1; i<=n*v; i++) dp[0][i] = _intMax;
		for (int i=1; i<=n; i++) {
			Point pt = list.get(i-1);
			for (int j=0; j<=n*v; j++) {
				if (j < pt.x) dp[i][j] = dp[i-1][j];
				else dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-pt.x]+pt.y);
			}
		}
		for (int i=n*v; i>=0; i--) {
			if (dp[n][i] <= w) return i;
		}
		return 0;
	}
	void solve() {
		int[] ia = readNums();
		n = ia[0];
		w = ia[1];
		boolean bOverW = false;
		for (int i=0; i<n; i++) {
			ia = readNums();
			Point pt = new Point(ia[0], ia[1]);
			list.add(pt);
			if (pt.y > 1000) bOverW = true;
		}
		long ans;
		if (n <= 30) ans = dfs(0, w);
		else if (!bOverW) ans = solve2();
		else ans = solve3();
		pln(ans);
	}

	class UnionFind {
		int[] uf;
		public UnionFind(int n) {
			uf = new int[n];
			for (int i=0; i<n; i++) {
				uf[i] = i;
			}
		}
		public int root(int v) {
			if (uf[v] == v) return v;
			uf[v] = root(uf[v]);
			return uf[v];
		}
		public void merge(int u, int v) {
			u = root(u);
			v = root(v);
			if (u == v) return;
			uf[v] = u;
		}
		public boolean same(int u, int v) {
			return root(u) == root(v);
		}
		public void print() {
			for (int i=0; i<uf.length; i++) {
				p(uf[i]+" ");
			}
			pln("");
		}
	}
	class Pair {
		String a;
		String b;
		public Pair(String a, String b) {
			this.a = a;
			this.b = b;
		}
		public Pair(Pair pr) {
			this.a = pr.a;
			this.b = pr.b;
		}
		public boolean equals(Object o) {
			if (o instanceof Pair) {
				Pair that = (Pair)o;
				return (a.equals(that.a)) && (b.equals(that.b));
			}
			return false;
		}
		public int hashCode() {
			return a.hashCode() + (b.hashCode() << 16);
		}
		public String toString() {
			return "(" + a + ", " + b + ")";
		}
	}
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(Point pt) {
			this.x = pt.x;
			this.y = pt.y;
		}
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point that = (Point)o;
				return (x == that.x) && (y == that.y);
			}
			return false;
		}
		public int hashCode() {
			return x + (y << 16);
		}
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	class Info implements Comparable<Info> {
		int idx;
		int val;
		public Info(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		public int compareTo(Info o) {
			return idx - o.idx;
		}
		public boolean equals(Object o) {
			if (o instanceof Info) {
				Info that = (Info)o;
				return 0 == compareTo(that);
			}
			return false;
		}
		public int hashCode() {
			return idx + (val << 16);
		}
		public String toString() {
			return "(" + idx + ", " + val + ")";
		}
	}
	class InfoComp implements Comparator<Info> {
		public int compare(Info o1, Info o2) {
			return o1.val - o2.val;
		}
	}
	long ceil2pow(long n) {
		if (n == 0) return 1;
		n--;
		n |= (n >>> 1);
		n |= (n >>> 2);
		n |= (n >>> 4);
		n |= (n >>> 8);
		n |= (n >>> 16);
		n++;
		return n;
		/*
		long pow = 1;
		while (pow < n) pow <<= 1;
		return pow;
		*/
	}
	int gcd(int a, int b) {
		if (a < b) return gcd(b, a);
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	long sqrt(long n) {
		return (long)Math.sqrt(n);
	}
	long pow(long n, long p) {
		return (long)Math.pow(n, p);
	}
	long pow_mod(long n, long p, long m) {
		if (p == 0) return 1;
		else if (p % 2 == 1) return pow_mod(n, p-1, m) * n % m;
		long sum = pow_mod(n, p/2, m);
		return sum * sum % m;
	}
	int pint(String s) {
		return Integer.parseInt(s);
	}
	long plong(String s) {
		return Long.parseLong(s);
	}
	String readLine() {
		try {
			return _in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	int readNum() {
		String line = readLine();
		return pint(line);
	}
	String[] readFlds() {
		String line = readLine();
		return line.split(" ");
	}
	int[] readNums() {
		String[] flds = readFlds();
		int[] nums = new int[flds.length];
		for (int i=0; i<flds.length; i++) {
			nums[i] = pint(flds[i]);
		}
		return nums;
	}
	void p(char c) {
		_out.print(c);
	}
	void pln(char c) {
		_out.println(c);
	}
	void p(double d) {
		_out.print(d);
	}
	void pln(double d) {
		_out.println(d);
	}
	void p(long l) {
		_out.print(l);
	}
	void pln(long l) {
		_out.println(l);
	}
	void p(String s) {
		_out.print(s);
	}
	void pln(String s) {
		_out.println(s);
	}
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new D4().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
