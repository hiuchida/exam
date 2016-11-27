package atcoder.atc002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;

public class A {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;
	Queue<Point> queue = new ArrayDeque<>();
	int h;
	int w;
	boolean[][] map;
	int[][] walk;
	Point start;
	Point gole;

	void solve() {
		int[] ia = readNums();
		h = ia[0];
		w = ia[1];
		ia = readNums();
		start = new Point(ia[1], ia[0]);
		ia = readNums();
		gole = new Point(ia[1], ia[0]);
		map = new boolean[h+2][w+2];
		walk = new int[h+2][w+2];
		for (int y=1; y<=h; y++) {
			String line = readLine();
			for (int x=1; x<=w; x++) {
				char ch = line.charAt(x-1);
				if (ch == '.') map[y][x] = true;
				walk[y][x] = _intMax;
			}
		}
		bfs(start.x, start.y);
		pln(walk[gole.y][gole.x]);
	}
	void bfs(int x, int y) {
		walk[y][x] = 0;
		queue.offer(new Point(x, y));
		while (queue.size() > 0) {
			Point pt = queue.poll();
			x = pt.x;
			y = pt.y;
			//pln(x+" "+y);
			if (x == gole.x && y == gole.y) {
				break;
			}
			int cnt = walk[y][x];
			cnt++;
			move(x-1, y, cnt);
			move(x+1, y, cnt);
			move(x, y-1, cnt);
			move(x, y+1, cnt);
		}
	}
	void move(int x, int y, int cnt) {
		if (!map[y][x]) return;
		if (walk[y][x] <= cnt) return;
		walk[y][x] = cnt;
		queue.add(new Point(x, y));
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
	int pint(String s) {
		return Integer.parseInt(s);
	}
	String readLine() {
		try {
			_line = _in.readLine();
			return _line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	int readNum() {
		readLine();
		return pint(_line);
	}
	String[] readFlds() {
		readLine();
		_flds = _line.split(" ");
		return _flds;
	}
	int[] readNums() {
		readFlds();
		_nums = new int[_flds.length];
		for (int i=0; i<_flds.length; i++) {
			_nums[i] = pint(_flds[i]);
		}
		return _nums;
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
	String _line;
	String[] _flds;
	int[] _nums;
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new A().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
