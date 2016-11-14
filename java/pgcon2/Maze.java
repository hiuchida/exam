package pgcon2;

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

public class Maze {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = true;
	static boolean bPrintMap = false;
	static boolean bBFS = true;
	static boolean bStack = true;
	final int[] dx = { 1, 0, -1, 0 };
	final int[] dy = { 0, 1, 0, -1 };
	//final int[] dx = { 0, 1, -1, 0 };
	//final int[] dy = { 1, 0, 0, -1 };
	//final int[] dx = { 0, -1, 1, 0 };
	//final int[] dy = { -1, 0, 0, 1 };
	int n;
	boolean[][] map;
	int[][] history;
	boolean[][] walk;
	List<Point> route;
	Set<Point> answerSet;
	int answerCnt;
	long funcCnt;
	long nestCnt;
	long nestMaxCnt;

	void solve() {
		initMap();
		//fillMap();
		initHistory(true);
		if (bPrintMap) printMap(true);
		
		if (bBFS) searchBFSMin();
		else if (bStack) searchDFSMin();
		else searchDFSMinRecursive(1, 1, 0);
		if (bPrintMap) printMap(true);
		pln("nestCnt="+nestMaxCnt);
		if (answerCnt == _intMax) {
			answerCnt = -1;
			pln(answerCnt);
			pln(answerCnt);
			return;
		}
		pln(answerCnt);
		//pln("funcCnt="+funcCnt);
		
		initHistory(false);
		searchDFSMax(1, 1, 0);
		if (bPrintMap) printMap(false);
		pln(answerCnt);
		//pln("funcCnt="+funcCnt);
	}

	void initMap() {
		n = readNum();
		map = new boolean[n+2][n+2];
		for (int i=0; i<n+2; i++) {
			map[0][i] = true;
			map[n+1][i] = true;
			map[i][0] = true;
			map[i][n+1] = true;
		}
		for (int y=1; y<=n; y++) {
			String line = readLine();
			for (int x=1; x<=n; x++) {
				if (line.charAt(x-1) == '#') {
					map[y][x] = true;
				}
			}
		}
	}
	
	void fillMap() {
		boolean bRepeat = true;
		while (bRepeat) {
			bRepeat = false;
			for (int y=1; y<=n; y++) {
				for (int x=1; x<=n; x++) {
					if (x == 1 && y == 1) continue;
					if (x == n && y == n) continue;
					if (!map[y][x]) {
						boolean b1 = map[y][x-1];
						boolean b2 = map[y][x+1];
						boolean b3 = map[y-1][x];
						boolean b4 = map[y+1][x];
						boolean b123 = b1 & b2 & b3;
						boolean b124 = b1 & b2 & b4;
						boolean b134 = b1 & b3 & b4;
						boolean b234 = b2 & b3 & b4;
						if (b123 | b124 | b134 | b234) {
							map[y][x] = true;
							bRepeat = true;
						}
					}
				}
			}
		}
	}
	
	void initHistory(boolean bMin) {
		int def = bMin ? _intMax : -1;
		history = new int[n+2][n+2];
		for (int y=1; y<=n; y++) {
			for (int x=1; x<=n; x++) {
				history[y][x] = def;
			}
		}
		walk = new boolean[n+2][n+2];
		route = new ArrayList<>();
		answerSet = new HashSet<>();
		answerCnt = def;
		funcCnt = 0;
		nestCnt = 0;
		nestMaxCnt = 0;
	}
	
	void printMap(boolean bMin) {
		int def = bMin ? _intMax : -1;
		for (int y=0; y<=n+1; y++) {
			for (int x=0; x<=n+1; x++) {
				if (map[y][x]) p("#");
				else if (answerSet.contains(new Point(x, y))) p("o");
				else if (history[y][x] != def) p("x");
				else p(".");
			}
			pln("");
		}
		pln("");
		_out.flush();
	}
	
	void searchBFSMin() {
		Queue<History> queue = new ArrayDeque<>();
		Point pt = new Point(1, 1);
		queue.offer(new History(pt, route));
		history[1][1] = 0;
		while (queue.size() > 0) {
			funcCnt++;
			if (funcCnt % 1000000 == 0) pln(funcCnt/1000000);
			nestMaxCnt = Math.max(nestMaxCnt, queue.size());
			History h = queue.poll();
			pt = h.pt;
			route = h.route;
			//pln("poll("+pt.x+", "+pt.y+")");
			int cnt = history[pt.y][pt.x];
			if (checkMin(pt.x, pt.y, cnt)) {
				continue;
			}
			cnt++;
			for (int i=0; i<dx.length; i++) {
				int nx = pt.x+dx[i];
				int ny = pt.y+dy[i];
				//pln("check("+nx+", "+ny+")");
				if (isMoveMin(nx, ny, cnt)) {
					Point p = new Point(nx, ny);
					queue.offer(new History(p, h.route));
					history[ny][nx] = cnt;
				}
			}
		}
	}
	
	void searchDFSMin() {
		Deque<History> stack = new ArrayDeque<>();
		Point pt = new Point(1, 1);
		stack.push(new History(pt, route));
		history[1][1] = 0;
		while (stack.size() > 0) {
			funcCnt++;
			if (funcCnt % 1000000 == 0) pln(funcCnt/1000000);
			nestMaxCnt = Math.max(nestMaxCnt, stack.size());
			History h = stack.pop();
			pt = h.pt;
			route = h.route;
			//pln("pop("+pt.x+", "+pt.y+")");
			int cnt = history[pt.y][pt.x];
			if (checkMin(pt.x, pt.y, cnt)) {
				continue;
			}
			cnt++;
			for (int i=dx.length-1; i>=0; i--) {
				int nx = pt.x+dx[i];
				int ny = pt.y+dy[i];
				//pln("check("+nx+", "+ny+")");
				if (isMoveMin(nx, ny, cnt)) {
					Point p = new Point(nx, ny);
					stack.push(new History(p, h.route));
					history[ny][nx] = cnt;
				}
			}
		}
	}
	
	void searchDFSMinRecursive(int x, int y, int cnt) {
		funcCnt++;
		if (funcCnt % 1000000 == 0) pln(funcCnt/1000000);
		if (checkMin(x, y, cnt)) {
			return;
		}
		if (cnt >= history[y][x]) {
			return;
		}
		nestCnt++;
		nestMaxCnt = Math.max(nestCnt, nestMaxCnt);
		history[y][x] = cnt;
		cnt++;
		for (int i=dx.length-1; i>=0; i--) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if (isMoveMin(nx, ny, cnt)) {
				searchDFSMinRecursive(nx, ny, cnt);
			}
		}
		nestCnt--;
	}
	
	boolean isMoveMin(int x, int y, int cnt) {
		if (map[y][x]) {
			return false;
		}
		if (cnt >= answerCnt) {
			return false;
		}
		if (cnt >= history[y][x]) {
			return false;
		}
		return true;
	}

	boolean checkMin(int x, int y, int cnt) {
		if (map[y][x]) {
			return true;
		}
		if (cnt >= answerCnt) {
			return true;
		}
		if (x == n && y == n) {
			if (cnt < answerCnt) {
				answerCnt = cnt;
				answerSet = new HashSet<>(route);
			}
			return true;
		}
		return false;
	}
	
	void searchDFSMax(int x, int y, int cnt) {
		//pln("("+x+", "+y+")");
		funcCnt++;
		if (funcCnt % 100000000 == 0) System.err.println(funcCnt/100000000);
		if (checkMax(x, y, cnt)) {
			return;
		}
		if (walk[y][x]) {
			return;
		}
		//if (cnt < history[y][x]) {
		//	return;
		//}
		nestCnt++;
		nestMaxCnt = Math.max(nestCnt, nestMaxCnt);
		walk[y][x] = true;
		//history[y][x] = cnt;
		route.add(new Point(x, y));
		cnt++;
		for (int i=0; i<dx.length; i++) {
			//pln("check("+(x+dx[i])+", "+(y+dy[i])+")");
			if (isMoveMax(x+dx[i], y+dy[i], cnt)) {
				searchDFSMax(x+dx[i], y+dy[i], cnt);
			}
		}
		walk[y][x] = false;
		route.remove(route.size()-1);
		nestCnt--;
	}
	
	boolean isMoveMax(int x, int y, int cnt) {
		if (map[y][x]) {
			return false;
		}
		if (walk[y][x]) {
			return false;
		}
		//if (cnt < history[y][x]) {
		//	return false;
		//}
		return true;
	}

	boolean checkMax(int x, int y, int cnt) {
		if (map[y][x]) {
			return true;
		}
		if (x == n && y == n) {
			if (cnt > answerCnt) {
				route.add(new Point(x, y));
				//pln(route.toString());
				//for (int i=0; i<route.size(); i++) {
				//	Point pt = route.get(i);
				//	history[pt.y][pt.x] = Math.max(i, history[pt.y][pt.x]);
				//}
				answerCnt = cnt;
				answerSet = new HashSet<>(route);
				route.remove(route.size()-1);
			}
			return true;
		}
		return false;
	}
	
	class History {
		Point pt;
		List<Point> route;
		public History(Point p, List<Point> r) {
			pt = p;
			route = new ArrayList<>(r);
			route.add(pt);
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
		new Maze().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
