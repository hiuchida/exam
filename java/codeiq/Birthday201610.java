package codeiq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Birthday201610 {
	static boolean bElapsed = false;
	Map<String,Integer> map = new HashMap<>();

	int h=9;
	int w=9;

	void solve(BufferedReader br) throws Exception {
		for (int y=0; y<=h; y++) {
			String line = br.readLine();
			for (int x=0; x<=w; x++) {
				char ch = line.charAt(x);
				if (ch == 'G') {
					addAll(x, y);
				}
			}
		}
		String maxKey = null;
		int maxCnt = 0;
		for (String key : map.keySet()) {
			int cnt = map.get(key);
			if (maxCnt < cnt) {
				maxKey = key;
				maxCnt = cnt;
			}
		}
		int idx = maxKey.indexOf(',');
		pln("{\"x\":"+maxKey.substring(0, idx)+",\"y\":"+maxKey.substring(idx+1)+",\"g\":"+maxCnt+"}");
	}

	void addAll(int xx, int yy) {
		for (int y=0; y<5; y++) {
			for (int x=0; x<5; x++) {
				add(xx-x, yy-y);
			}
		}
	}

	void add(int x, int y) {
		if (x < 0 || y < 0 || x+4 > w || y+4 > h) {
			return;
		}
		String key = x + "," + y;
		//pln(key);
		Integer i = map.get(key);
		if (i == null) {
			map.put(key, 1);
		} else {
			map.put(key, i+1);
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
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Birthday201610().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
