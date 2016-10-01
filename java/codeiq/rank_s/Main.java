package codeiq.rank_s;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	private static int m;
	private static int n;
	private static byte[][] map;
	private static int[][][] turn;
	private static int minTurnCnt = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		initMap();
		initTurn();
		map[0][0] = 1;
		move((char) 0, 0, 0, 0, 'D');
		System.out.println(minTurnCnt);
	}

	private static void initMap() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		m = Integer.parseInt(flds[0]);
		n = Integer.parseInt(flds[1]);
		map = new byte[m][n];
		for (int i = 0; i < m; i++) {
			line = br.readLine();
			for (int j = 0; j < n; j++) {
				char ch = line.charAt(j);
				if (ch == '#') {
					map[i][j] = -1;
				}
			}
		}
	}

	private static void initTurn() {
		turn = new int[4][m][n];
		for (int d = 0; d < 4; d++) {
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					turn[d][y][x] = Integer.MAX_VALUE;
				}
			}
		}
	}

	private static void move(char prev, int turnCnt, int x, int y, char direction) {
		if (x == n - 1 && y == m - 1) {
			if (turnCnt < minTurnCnt) {
				minTurnCnt = turnCnt;
			}
			return;
		}
		int idx = getIndex(direction);
		if (turn[idx][y][x] <= turnCnt) {
			return;
		}
		turn[idx][y][x] = turnCnt;
		moveTo(prev, turnCnt, x, y + 1, 'D');
		moveTo(prev, turnCnt, x - 1, y, 'L');
		moveTo(prev, turnCnt, x + 1, y, 'R');
		moveTo(prev, turnCnt, x, y - 1, 'U');
	}

	private static void moveTo(char prev, int turnCnt, int x, int y, char direction) {
		if (checkStatus(x, y)) {
			if (checkTurn(prev, direction)) {
				turnCnt++;
			}
			if (minTurnCnt <= turnCnt) {
				return;
			}
			prev = direction;
			map[y][x] = 1;
			move(prev, turnCnt, x, y, direction);
			map[y][x] = 0;
		}
	}

	private static boolean checkStatus(int x, int y) {
		if (x < 0 || n <= x || y < 0 || m <= y) {
			return false;
		}
		if (map[y][x] != 0) {
			return false;
		}
		return true;
	}

	private static boolean checkTurn(char prev, char direction) {
		if (prev == 0) {
			return false;
		}
		if (prev == direction) {
			return false;
		}
		return true;
	}

	private static int getIndex(char direction) {
		switch (direction) {
		case 'L':
			return 0;
		case 'R':
			return 1;
		case 'U':
			return 2;
		case 'D':
			return 3;
		}
		return 0;
	}

}
