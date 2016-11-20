package atcoder.sq3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class B {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();
	Queue<String> queue = new ArrayDeque<>();
	Deque<String> stack = new ArrayDeque<>();
	int h;
	int w;
	int k;

	void solve() {
		int[] ia = readNums();
		h = ia[0];
		w = ia[1];
		k = ia[2];
		for (int y=0; y<h; y++) {
			String line = readLine();
			list.add(line);
		}
		int max = 0;
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				int v = sim(x, y);
				max = Math.max(max, v);
			}
		}
		pln(max);
	}
	
	int sim(int x0, int y0) {
		int v = 0;
		int[][] map = new int[h][w];
		for (int y=0; y<h; y++) {
			String s = list.get(y);
			for (int x=0; x<w; x++) {
				map[y][x] = s.charAt(x) - '0';
			}
		}
		List<Point> ptList = new ArrayList<>();
		for (int y=y0; y>=1; y--) {
			map[y][x0] = map[y-1][x0];
			ptList.add(new Point(x0, y));
		}
		map[0][x0] = 0;
		int score = 1;
		for (int i=0; true; i++) {
			for (Point pt : ptList) {
				int lt = srchlt(map, pt.x, pt.y);
				int rt = srchlt(map, pt.x, pt.y);
				if (rt-lt+1 >= k) {
					
				}
			}
		}
	}
	
	int srchlt(int[][] map, int x0, int y0) {
		int x;
		for (x=x0; x>=0; x--) {
			if (map[y0][x] != map[y0][x0]) break;
		}
		x++;
		return x;
	}

	int srchrt(int[][] map, int x0, int y0) {
		int x;
		for (x=x0; x<w; x++) {
			if (map[y0][x] != map[y0][x0]) break;
		}
		x--;
		return x;
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
		new B().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
