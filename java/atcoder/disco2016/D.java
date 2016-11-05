package atcoder.disco2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {
	static boolean bElapsed = false;
	int n;
	int[][] map;
	int minCnt;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		n = Integer.parseInt(flds[0]);
		int x = Integer.parseInt(flds[1]);
		map = new int[n][n];
		for (int i=0; i<n-1; i++) {
			line = br.readLine();
			flds = line.split(" ");
			int a = Integer.parseInt(flds[0]);
			int b = Integer.parseInt(flds[1]);
			int c = Integer.parseInt(flds[2]);
			map[a-1][b-1] = c;
			map[b-1][a-1] = c;
		}
		long cnt = 0;
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				if (map[i][j] == 0) {
					map[i][j]= x;
					map[j][i]= x;
				}
			}
		}
		for (int i=0; i<n-1; i++) {
			for (int j=i+1; j<n; j++) {
				boolean[] walk = new boolean[n];
				minCnt = map[i][j];
				search(i, j, 0, walk);
				cnt += minCnt;
			}
		}
		pln(cnt);
	}

	void search(int i, int j, int cnt, boolean[] walk) {
		if (walk[i]) return;
		if (cnt >= minCnt) return;
		walk[i] = true;
		for (int k=0; k<n; k++) {
			if (k == j) {
				minCnt = Math.min(cnt + map[i][k], minCnt);
			} else {
				search(k, j, cnt + map[i][k], walk);
			}
		}
		walk[i] = false;
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
		new D().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
