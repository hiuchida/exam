package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MazeBFSMax {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = true;
	final int[] dx = { 1, 0, -1, 0 };
	final int[] dy = { 0, 1, 0, -1 };
	int n;
	boolean[][] map;
	int[][] history;
	Queue<History> queue = new ArrayDeque<>();
	Set<Point> answerSet = new HashSet<>();
	int answerCnt = -1;
	long funcCnt;

	void solve(BufferedReader br) throws Exception {
		initMap(br);
		search();
		printMap();
		//if (answerCnt == _intMax) {
		//	answerCnt = -1;
		//}
		pln(answerCnt);
		pln("funcCnt="+funcCnt);
	}
	
	void initMap(BufferedReader br) throws Exception {
		String line = br.readLine();
		n = Integer.parseInt(line);
		map = new boolean[n+2][n+2];
		history = new int[n+2][n+2];
		for (int i=0; i<n+2; i++) {
			map[0][i] = true;
			map[n+1][i] = true;
			map[i][0] = true;
			map[i][n+1] = true;
		}
		for (int y=1; y<=n; y++) {
			line = br.readLine();
			for (int x=1; x<=n; x++) {
				if (line.charAt(x-1) == '#') {
					map[y][x] = true;
				}
				history[y][x] = _intMax;
			}
		}
	}
	
	void printMap() {
		for (int y=0; y<=n+1; y++) {
			for (int x=0; x<=n+1; x++) {
				if (map[y][x]) p("#");
				else if (answerSet.contains(new Point(x, y))) p("o");
				else if (history[y][x] < _intMax) p("x");
				else p(".");
			}
			pln("");
		}
	}
	
	void search() {
		Point pt = new Point(1, 1);
		List<Point> route = new ArrayList<>();
		route.add(pt);
		queue.offer(new History(pt, route));
		//history[1][1] = 0;
		while (queue.size() > 0) {
			funcCnt++;
			if (funcCnt % 1000000 == 0) pln(funcCnt/1000000);
			History h = queue.poll();
			pln("poll("+h.pt.x+", "+h.pt.y+")");
			int cnt = h.route.size()-1;
			if (check(h.pt.x, h.pt.y, cnt, h.route)) {
				continue;
			}
			cnt++;
			for (int i=0; i<dx.length; i++) {
				int nx = h.pt.x+dx[i];
				int ny = h.pt.y+dy[i];
				//pln("check("+nx+", "+ny+")");
				if (isMove(nx, ny, cnt)) {
					pt = new Point(nx, ny);
					if (h.set.contains(pt)) continue;
					route = new ArrayList<>(h.route);
					route.add(pt);
					queue.offer(new History(pt, route));
					//history[ny][nx] = cnt;
				}
			}
		}
	}
	
	boolean isMove(int x, int y, int cnt) {
		if (map[y][x]) {
			return false;
		}
		//if (cnt >= answerCnt) {
		//	return false;
		//}
		//if (cnt >= history[y][x]) {
		//	return false;
		//}
		return true;
	}

	boolean check(int x, int y, int cnt, List<Point> route) {
		if (map[y][x]) {
			return true;
		}
		//if (cnt >= answerCnt) {
		//	return true;
		//}
		if (x == n && y == n) {
			pln(route.toString());
			if (cnt > answerCnt) {
				answerCnt = cnt;
				answerSet = new HashSet<>(route);
			}
			return true;
		}
		return false;
	}
	
	class History {
		Point pt;
		List<Point> route = new ArrayList<>();
		Set<Point> set;
		public History(Point p, List<Point> r) {
			pt = p;
			route = r;
			set = new HashSet<>(route);
		}
	}
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public Point(Point p) {
			x = p.x;
			y = p.y;
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
	void p(char c) {
		System.out.print(c);
	}
	void pln(char c) {
		System.out.println(c);
	}
	void p(double d) {
		System.out.print(d);
	}
	void pln(double d) {
		System.out.println(d);
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
	String _line;
	String[] _flds;
	int[] _nums;
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new MazeBFSMax().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
