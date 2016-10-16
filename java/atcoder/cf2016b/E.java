package atcoder.cf2016b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class E {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	String[] strs;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		strs = new String[n];
		for (int i=0; i<n; i++) {
			line = br.readLine();
			strs[i] = line;
		}
		line = br.readLine();
		int q = Integer.parseInt(line);
		for (int i=0; i<q; i++) {
			line = br.readLine();
			String[] flds = line.split(" ");
			int k = Integer.parseInt(flds[0]);
			sort(flds[1], k-1);
		}
	}

	void sort(String line, int no) {
		int[] order = new int[26];
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			order[ch - 'a'] = i;
		}
		String cur = strs[no];
		int small = 0;
		int large = 0;
		List<String> same = new ArrayList<String>();
		for (int i=0; i<strs.length; i++) {
			if (i != no) {
				same.add(strs[i]);
			}
		}
		for (int i=0; i<cur.length(); i++) {
			List<String> same2 = new ArrayList<String>();
			int ch = order[cur.charAt(i) - 'a'];
			for (String s : same) {
				if (s.length() <= i) {
					small++;
					continue;
				}
				int ch2 = order[s.charAt(i) - 'a'];
				if (ch2 < ch) {
					small++;
					continue;
				}
				if (ch2 > ch) {
					large++;
					continue;
				}
				same2.add(s);
			}
			same = same2;
			if (same.size() == 0) {
				break;
			}
		}
		pln(small + 1);
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
		new E().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
