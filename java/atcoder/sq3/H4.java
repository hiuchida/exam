package atcoder.sq3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class H4 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Queue<String> queue = new ArrayDeque<>();
	Deque<String> stack = new ArrayDeque<>();
	int h;
	int w;
	int n;
	int k;
	boolean[][] map;

	int request(int lt, int tp, int rt, int bm) {
		pln("? "+ tp + " " + lt + " " + bm + " " + rt);
		_out.flush();
		return readNum();
	}
	
	int calc(int n) {
		int pow = 1;
		while (pow < n) pow *= 2;
		return pow / 2;
	}
	
	void solve2(int x1, int y1, int x2, int y2, int cnt) {
		if (cnt == 0) return;
		int dx = x2-x1+1;
		int dy = y2-y1+1;
		if (dx == 1 && dy == 1) {
			map[y1][x1] = true;
			return;
		}
		if (dx >= dy) {
			int x3 = x1+calc(dx)-1;
			int v = request(x1, y1, x3, y2);
			solve2(x1, y1, x3, y2, v);
			solve2(x3+1, y1, x2, y2, cnt-v);
		} else {
			int y3 = y1+calc(dy)-1;
			int v = request(x1, y1, x2, y3);
			solve2(x1, y1, x2, y3, v);
			solve2(x1, y3+1, x2, y2, cnt-v);
		}
	}
	
	void solve() {
		int[] ia = readNums();
		h = ia[0];
		w = ia[1];
		n = ia[2];
		k = ia[3];
		map = new boolean[h][w];
		solve2(0, 0, w-1, h-1, n);
		long sum = 0;
		int pow = 1;
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				if (map[y][x]) sum += pow;
				pow *= 2;
				sum %= k;
				pow %= k;
			}
		}
		pln("! " + sum);
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
	String[] readFields() {
		readLine();
		_flds = _line.split(" ");
		return _flds;
	}
	int[] readNums() {
		readFields();
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
		new H4().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
