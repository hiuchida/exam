package codeiq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NoSortedCard {
	static boolean bElapsed = false;
	int n;
	int cnt;

	void solve(BufferedReader br) throws Exception {
		n = pint(br.readLine());
		List<Integer> tmpList = new ArrayList<>();
		search(tmpList);
		pln(cnt);
	}
	void search(List<Integer> tmpList) {
		if (n == tmpList.size()) {
			if (check(tmpList)) {
				//pln(tmpList.toString());
				cnt++;
			}
			return;
		}
		for (int i=1; i<=n; i++) {
			if (tmpList.contains(i)) continue;
			tmpList.add(i);
			search(tmpList);
			tmpList.remove(tmpList.size()-1);
		}
	}
	boolean check(List<Integer> tmpList) {
		List<Integer> list = new ArrayList<>(tmpList);
		for (int i=0; i<n; i++) {
			int v = list.get(i);
			int x = list.get(v-1);
			list.set(i, x);
			list.set(v-1, v);
		}
		for (int i=0; i<n; i++) {
			int v = list.get(i);
			if (v != i+1) return true;
		}
		return false;
	}
	
	int pint(String s) {
		return Integer.parseInt(s);
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
		new NoSortedCard().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
