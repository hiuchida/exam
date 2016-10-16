package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class B {
	static boolean bElapsed = false;
	List<Integer> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	int[] chars = new int[26];
	
	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int k = Integer.parseInt(flds[1]);
		for (int i=0; i<n; i++) {
			line = br.readLine();
			char ch = line.charAt(0);
			chars[ch - 'A']++;
		}
		for (int i=0; i<26; i++) {
			if (chars[i] > 0) {
				list.add(chars[i]);
			}
		}
		long cnt = 0;
		while (true) {
			if (list.size() < k) {
				break;
			}
			Collections.sort(list);
			int idx = list.size() - 1;
			for (int i=0; i<k; i++) {
				int v = list.get(idx);
				v--;
				if (v > 0) {
					list.set(idx, v);
				} else {
					list.remove(idx);
				}
				idx--;
			}
			cnt++;
		}
		pln(cnt);
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
		new B().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
