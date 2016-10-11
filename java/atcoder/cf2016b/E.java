package atcoder.cf2016b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E {
	
	static String[] strs;

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}
	
	static void sort(String line, int no) {
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
		System.out.println(small + 1);
	}

}
