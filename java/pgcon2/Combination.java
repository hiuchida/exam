package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Combination {
	static boolean bElapsed = false;

	void solve(BufferedReader br) throws Exception {
		List<Integer> list = new ArrayList<>();
		for (int i=1; i<=6; i++) {
			list.add(i);
		}
		Collections.sort(list);
		List<Integer> tmpList = new ArrayList<>();
		search(3, 0, list, tmpList);
	}
	
	void search(int cnt, int idx, List<Integer> list, List<Integer> tmpList) {
		if (cnt == tmpList.size()) {
			pln(tmpList.toString());
			return;
		}
		for (int i=idx; i<list.size(); i++) {
			int v = list.get(i);
			tmpList.add(v);
			search(cnt, i+1, list, tmpList);
			tmpList.remove(tmpList.size()-1);
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
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Combination().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
