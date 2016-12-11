package atcoder.arc065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class E {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	void solve() {
		int[] ia = readNums();
		int n = ia[0];
		int a = ia[1];
		int b = ia[2];
		a--;
		b--;
		List<Point> list = new ArrayList<>(n);
		for (int i=0; i<n; i++) {
			ia = readNums();
			Point pt = new Point(ia[0], ia[1]);
			list.add(pt);
		}
		long d = dist(list.get(a), list.get(b));
		Set<Point> set = new HashSet<>();
		boolean[] flg = new boolean[n];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(a);
		queue.offer(b);
		while (queue.size() > 0) {
			int i = queue.poll();
			flg[i] = true;
			for (int j=0; j<n; j++) {
				if (i == j) continue;
				if (flg[j]) continue;
				long dd = dist(list.get(i), list.get(j));
				if (d == dd) {
					int ii = Math.min(i, j);
					int jj = Math.max(i, j);
					set.add(new Point(ii, jj));
					if (!flg[j]) {
						queue.offer(j);
					}
				}
			}
		}
		pln(set.size());
	}
	long dist(Point p1, Point p2) {
		long dx = p1.x - p2.x;
		long dy = p1.y - p2.y;
		if (dx < 0) dx = -dx;
		if (dy < 0) dy = -dy;
		return dx + dy;
	}

	class RMQ {
		int n;
		int[] element;
		public RMQ(int n) {
			n = (int)ceil2pow(n);
			this.n = n;
			element = new int[2*n-1];
			Arrays.fill(element, _intMax);
		}
		public void update(int k, int a) {
			k += n-1;
			element[k] = a;
			while (k > 0) {
				k = (k-1)/2;
				element[k] = Math.min(element[2*k+1], element[2*k+2]);
			}
		}
		public int query(int a, int b) {
			if (a == b) return element[a+n-1];
			return query(a, b+1, 0, 0, n);
		}
		private int query(int a, int b, int k, int l, int r) {
			if (r <= a || b <= l) return _intMax;
			if (a <= l && r <= b) return element[k];
			int vl = query(a, b, 2*k+1, l, (l+r)/2);
			int vr = query(a, b, 2*k+2, (l+r)/2, r);
			return Math.min(vl, vr);
		}
		public void print() {
			for (int i=0; i<element.length; i++) {
				String v = element[i] != _intMax ? ""+element[i] : "-";
				p(v+" ");
			}
			pln("");
		}
	}
	class RMQIndex {
		int n;
		int[] element;
		int[] index;
		public RMQIndex(int n) {
			n = (int)ceil2pow(n);
			this.n = n;
			element = new int[2*n-1];
			index = new int[2*n-1];
			Arrays.fill(element, _intMax);
			for (int i=0; i<n; i++) {
				index[n-1+i] = i;
			}
			for (int i=n-1-1; i>=0; i--) {
				index[i] = index[2*i+1];
			}
		}
		public void update(int k, int a) {
			k += n-1;
			element[k] = a;
			while (k > 0) {
				k = (k-1)/2;
				if (element[2*k+1] <= element[2*k+2]) {
					element[k] = element[2*k+1];
					index[k] = index[2*k+1];
				} else {
					element[k] = element[2*k+2];
					index[k] = index[2*k+2];
				}
			}
		}
		public int[] query(int a, int b) {
			if (a == b) return new int[] { element[a+n-1], index[a+n-1] };
			return query(a, b+1, 0, 0, n);
		}
		private int[] query(int a, int b, int k, int l, int r) {
			if (r <= a || b <= l) return new int[] { _intMax, 0 };
			if (a <= l && r <= b) return new int[] { element[k], index[k] };
			int[] vl = query(a, b, 2*k+1, l, (l+r)/2);
			int[] vr = query(a, b, 2*k+2, (l+r)/2, r);
			if (vl[0] <= vr[0]) {
				return new int[] { vl[0], vl[1] };
			} else {
				return new int[] { vr[0], vr[1] };
			}
		}
		public void print() {
			p("dat:");
			for (int i=0; i<element.length; i++) {
				String v = element[i] != _intMax ? ""+element[i] : "-";
				p(v+" ");
			}
			pln("");
			p("idx:");
			for (int i=0; i<index.length; i++) {
				p(index[i]+" ");
			}
			pln("");
		}
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
			return a.hashCode() + (b.hashCode() * 31);
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
			return x + (y * 31);
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
			if (idx < o.idx) return -1;
			else if (idx > o.idx) return 1;
			return 0;
		}
		public boolean equals(Object o) {
			if (o instanceof Info) {
				Info that = (Info)o;
				return 0 == compareTo(that);
			}
			return false;
		}
		public int hashCode() {
			return idx + (val * 31);
		}
		public String toString() {
			return "(" + idx + ", " + val + ")";
		}
	}
	class InfoComp implements Comparator<Info> {
		public int compare(Info o1, Info o2) {
			if (o1.val < o2.val) return -1;
			else if (o1.val > o2.val) return 1;
			return 0;
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
		new E().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
