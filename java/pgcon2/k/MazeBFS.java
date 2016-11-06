package pgcon2.k;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MazeBFS {
	private static boolean debug = false;
	private static boolean elapsed = false;

	private int N;
	private boolean[][] b; // 通路かどうか
	private int[][] d; // スタート地点からの距離

	private static class Point {
		int x;
		int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point that = (Point)o;
				return (this.x == that.x) && (this.y == that.y);
			}
			return false;
		}
		@Override
		public int hashCode() {
			int result = 17;
			result = 31 * result + x;
			result = 31 * result + y;
			return result;
		}
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	private void solve(Scanner sc, PrintWriter out) {
		N = sc.nextInt();
		b = new boolean[N + 2][N + 2];
		d = new int[N + 2][N + 2];
		for (int i = 1; i <= N; ++i) {
			String line = sc.next();
			for (int j = 1; j <= N; ++j) {
				b[i][j] = (line.charAt(j - 1) == '.');
				d[i][j] = -1;
			}
		}

		Point first = new Point(1, 1);
		d[first.y][first.x] = 0;
		search(first);

		out.println(d[N][N]);
	}
	private void search(Point first) {
		Queue<Point> q = new LinkedList<>();

		q.offer(first);

		int[][] m = {
			{  1,  0 },
			{  0,  1 },
			{ -1,  0 },
			{  0, -1 }
		};

		while (q.peek() != null) {
			Point v = q.poll();
			for (int i = 0; i < m.length; ++i) {
				int x = v.x + m[i][1];
				int y = v.y + m[i][0];

				if (b[y][x]) {
					int curD = d[v.y][v.x];
					if (d[y][x] == -1 || curD + 1 < d[y][x]) {
						d[y][x] = curD + 1;
						Point p = new Point(x, y);
						q.offer(p);
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		long S = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new MazeBFS().solve(sc, out);
		out.flush();

		long G = System.currentTimeMillis();
		if (elapsed) {
			System.err.println((G - S) + "ms");
		}
	}
}
