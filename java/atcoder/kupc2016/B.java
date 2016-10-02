package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class B {

	static int[] chars = new int[26];
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int k = Integer.parseInt(flds[1]);
		for (int i=0; i<n; i++) {
			line = br.readLine();
			char ch = line.charAt(0);
			chars[ch - 'A']++;
		}
		List<Integer> list = new ArrayList<>();
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
		System.out.println(cnt);
		long end = System.currentTimeMillis();
//		System.out.println((end-start) + "ms");
	}

}
