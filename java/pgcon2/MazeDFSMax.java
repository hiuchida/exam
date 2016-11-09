package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MazeDFSMax {
	static boolean bElapsed = true;
	final int[] dx = { 1, 0, -1, 0 };
	final int[] dy = { 0, 1, 0, -1 };
	int n;
	boolean[][] map;
	boolean[][] walk;
	int[][] history;
	List<Point> route = new ArrayList<>();
	Set<Point> answerSet = new HashSet<>();
	int answerCnt = -1;
	long funcCnt;
	long nestCnt;
	long nestMaxCnt;

	void solve(BufferedReader br) throws Exception {
		initMap(br);
		search(1, 1, 0);
		printMap();
		pln(answerCnt);
		pln("funcCnt="+funcCnt);
		pln("nestCnt="+nestMaxCnt);
	}
	
	void initMap(BufferedReader br) throws Exception {
		String line = br.readLine();
		n = Integer.parseInt(line);
		map = new boolean[n+2][n+2];
		walk = new boolean[n+2][n+2];
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
				history[y][x] = -1;
			}
		}
	}
	
	void printMap() {
		for (int y=0; y<=n+1; y++) {
			for (int x=0; x<=n+1; x++) {
				if (map[y][x]) p("#");
				else if (answerSet.contains(new Point(x, y))) p("o");
				else if (history[y][x] >= 0) p("x");
				else p(".");
			}
			pln("");
		}
	}
	
	void search(int x, int y, int cnt) {
		//pln("("+x+", "+y+")");
		funcCnt++;
		if (funcCnt % 100000000 == 0) pln(funcCnt/100000000);
		if (check(x, y, cnt)) {
			return;
		}
		if (walk[y][x]) {
			return;
		}
		//if (cnt <= history[y][x]) {
		//	return;
		//}
		nestCnt++;
		nestMaxCnt = Math.max(nestCnt, nestMaxCnt);
		walk[y][x] = true;
		history[y][x] = cnt;
		route.add(new Point(x, y));
		cnt++;
		for (int i=0; i<dx.length; i++) {
			//pln("check("+(x+dx[i])+", "+(y+dy[i])+")");
			if (isMove(x+dx[i], y+dy[i], cnt)) {
				search(x+dx[i], y+dy[i], cnt);
			}
		}
		walk[y][x] = false;
		route.remove(route.size()-1);
		nestCnt--;
	}
	
	boolean isMove(int x, int y, int cnt) {
		if (map[y][x]) {
			return false;
		}
		if (walk[y][x]) {
			return false;
		}
		//if (cnt <= history[y][x]) {
		//	return false;
		//}
		return true;
	}

	boolean check(int x, int y, int cnt) {
		if (map[y][x]) {
			return true;
		}
		if (x == n && y == n) {
			if (cnt > answerCnt) {
				route.add(new Point(x, y));
				answerCnt = cnt;
				answerSet = new HashSet<>(route);
				route.remove(route.size()-1);
			}
			return true;
		}
		return false;
	}
	
	class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
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
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new MazeDFSMax().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
