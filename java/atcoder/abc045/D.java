package atcoder.abc045;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class D {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,Integer> map = new HashMap<>();

	int h;
	int w;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		h = Integer.parseInt(flds[0]);
		w = Integer.parseInt(flds[1]);
		int n = Integer.parseInt(flds[2]);
		for (int i=0; i<n; i++) {
			line = br.readLine();
			flds = line.split(" ");
			int a = Integer.parseInt(flds[0]);
			int b = Integer.parseInt(flds[1]);
			add(a-2, b-2);
			add(a-1, b-2);
			add(a+0, b-2);
			add(a-2, b-1);
			add(a-1, b-1);
			add(a+0, b-1);
			add(a-2, b+0);
			add(a-1, b+0);
			add(a+0, b+0);
		}
		int[] cnt = new int[10];
		for (String key : map.keySet()) {
			int idx = map.get(key);
			cnt[idx]++;
		}
		long total = (long)(h-2) * (w-2);
		pln(total-map.size());
		for (int i=1; i<=9; i++) {
			pln(cnt[i]);
		}
	}

	void add(int y, int x) {
		if (x < 1 || y < 1 || x+2 > w || y+2 > h) {
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
		new D().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
