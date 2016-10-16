package atcoder.abc042;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Integer> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int a = Integer.parseInt(flds[0]);
		int b = Integer.parseInt(flds[1]);
		int c = Integer.parseInt(flds[2]);
		list.add(a);
		list.add(b);
		list.add(c);
		Collections.sort(list);
		if (list.get(0) == 5 && list.get(1) == 5 && list.get(2) == 7) {
			pln("YES");
		} else {
			pln("NO");
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
		new A().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
