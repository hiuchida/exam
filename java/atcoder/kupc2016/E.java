package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E {

	static int h;
	static int w;
	static byte[][] map;
	static List<Point> list = new ArrayList<>();
	
	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		initMap();
		if (checkEdge()) {
			System.out.println("-1");
			return;
		}
		fill();
		fillEdge();
		checkInner();
		int cnt = count();
		System.out.println(cnt);
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}
	
	static void initMap() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		h = Integer.parseInt(flds[0]);
		w = Integer.parseInt(flds[1]);
		map = new byte[h][w];
		for (int y=0; y<h; y++) {
			line = br.readLine();
			for (int x=0; x<w; x++) {
				char ch = line.charAt(x);
				if (ch == 'X') {
					map[y][x] = 1;
				}
			}
		}
	}
	
	static boolean checkEdge() {
		for (int x=0; x<w; x++) {
			if (map[0][x] > 0) {
				return true;
			}
			if (map[h-1][x] > 0) {
				return true;
			}
		}		
		for (int y=0; y<h; y++) {
			if (map[y][0] > 0) {
				return true;
			}
			if (map[y][w-1] > 0) {
				return true;
			}
		}
		return false;
	}
	
	static void fill() {
		for (int y=1; y<h-1; y++) {
			for (int x=1; x<w-1; x++) {
				if (map[y][x] == 1) {
					fill(x-1, y);
					fill(x+1, y);
					fill(x, y-1);
					fill(x, y+1);
				}
			}
		}
	}
	
	static void fill(int x, int y) {
		if (map[y][x] == 0) {
			map[y][x] = 2;
		}
	}
	
	static void fillEdge() {
		for (int x=0; x<w; x++) {
			addList(x, 0);
			addList(x, h-1);
		}		
		for (int y=0; y<h; y++) {
			addList(0, y);
			addList(w-1, y);
		}
		while (list.size() > 0) {
			Point pt = list.remove(0);
			if (map[pt.y][pt.x] > 0) {
				continue;
			}
			map[pt.y][pt.x] = 9;
			addList(pt.x-1, pt.y);
			addList(pt.x+1, pt.y);
			addList(pt.x, pt.y-1);
			addList(pt.x, pt.y+1);
		}
	}
	
	static void addList(int x, int y) {
		if (x < 0 || x >= w || y < 0 || y >= h) {
			return;
		}
		if (map[y][x] == 0) {
			list.add(new Point(x, y));
		}		
	}
	
	static void checkInner() {
		for (int y=1; y<h-1; y++) {
			for (int x=1; x<w-1; x++) {
				if (map[y][x] != 2) {
					continue;
				}
				if (map[y][x-1] == 9) {
					continue;
				}
				if (map[y][x+1] == 9) {
					continue;
				}
				if (map[y-1][x] == 9) {
					continue;
				}
				if (map[y+1][x] == 9) {
					continue;
				}
				map[y][x] = 3;
			}
		}
	}
	
	static int count() {
		int cnt = 0;
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				if (map[y][x] == 2) {
					cnt++;
				}
			}
		}
		return cnt;
	}
	
}
