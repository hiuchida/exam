package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;

public class MazeDFS {
	static boolean bElapsed = true;
	int n;
	boolean[][] map;
	int[][] history;
	int answerCnt = Integer.MAX_VALUE;
	long funcCnt;

	void solve(BufferedReader br) throws Exception {
		initMap(br);
		for (int y=0; y<=n+1; y++) {
			for (int x=0; x<=n+1; x++) {
				p((map[y][x] ? "1":"0")+" ");
			}
			pln("");
		}
		search(1, 1, 0);
		if (answerCnt == Integer.MAX_VALUE) {
			answerCnt = -1;
		}
		pln(answerCnt);
		pln(funcCnt);
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
			}
		}
	}
	
	void search(int x, int y, int cnt) {
		funcCnt++;
		if (funcCnt % 1000000 == 0) pln(funcCnt/1000000);
		if (check(x, y, cnt)) {
			return;
		}
		if (history[y][x] > 0) {
			return;
		}
		history[y][x] = 1;
		cnt++;
		search(x+1, y, cnt);
		search(x, y+1, cnt);
		search(x-1, y, cnt);
		search(x, y-1, cnt);
		history[y][x] = 0;
	}

	boolean check(int x, int y, int cnt) {
		if (map[y][x]) {
			return true;
		}
		if (x == n && y == n) {
			if (cnt < answerCnt) {
				answerCnt = cnt;
			}
			return true;
		}
		return false;
	}
	
	class Person {
		int no;
		int a;
		public Person(int no, int a) {
			this.no = no;
			this.a = a;
		}
	}
	class PersonComp implements Comparator<Person> {
		public int compare(Person o1, Person o2) {
			return o2.a - o1.a;
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
		new MazeDFS().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
