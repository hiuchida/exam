package pgcon2.k;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MazeDFS {
	private static boolean debug = true;
	private static boolean elapsed = false;

	private int N;
	private boolean[][] b; // 通路かどうか
	private int[][] d; // スタート地点からの距離
	private List<Point> answerRoute;

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
			result = 31 * x;
			result = 31 * y;
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
		for (int i = 0; i < N + 2; ++i) {
			String line = (i > 0 && i <= N) ? sc.next() : "";
			for (int j = 0; j < N + 2; ++j) {
				if (i == 0 || i == N + 1 || j == 0 || j == N + 1) {
					b[i][j] = false;
				} else {
					b[i][j] = (line.charAt(j - 1) == '.');
				}
			}
		}

		List<Point> route = new ArrayList<>();
		Point first = new Point(1, 1);
		route.add(first);
		search(route);

		if (debug) {
			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (b[i][j]) {
						Point p = new Point(j, i);
						if (answerRoute != null && answerRoute.contains(p)) {
							System.err.print("o");
						} else {
							System.err.print(".");
						}
					} else {
						System.err.print("#");
					}
				}
				System.err.println();
			}
		}
		out.println(d[N][N] == 0 ? -1 : d[N][N]);
	}
	private void search(List<Point> route) {
		check(route);

		Point prev = route.get(route.size() - 1);

		int[][] m = {
			{  1,  0 },
			{  0,  1 },
			{ -1,  0 },
			{  0, -1 }
		};

		for (int i = 0; i < m.length; ++i) {
			int x = prev.x + m[i][1];
			int y = prev.y + m[i][0];

			if (b[y][x]) {
				int curD = d[prev.y][prev.x];
				if (d[y][x] == 0 || curD + 1 < d[y][x]) {
					d[y][x] = curD + 1;
					Point p = new Point(x, y);
					route.add(p);
					search(route);
					route.remove(route.size() - 1);
				}
			}
		}
	}
	private void check(List<Point> route) {
		Point last = route.get(route.size() - 1);
		if (last.x != N || last.y != N) {
			return;
		}

		if (answerRoute == null) {
			answerRoute = new ArrayList<>(route);
		} else if (route.size() < answerRoute.size()) {
			answerRoute = new ArrayList<>(route);
		}
	}
	public static void main(String[] args) {
		long S = System.currentTimeMillis();

		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		new MazeDFS().solve(sc, out);
		out.flush();

		long G = System.currentTimeMillis();
		if (elapsed) {
			System.err.println((G - S) + "ms");
		}
	}
}
