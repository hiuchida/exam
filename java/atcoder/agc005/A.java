package atcoder.agc005;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class A {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int cnt = 0;
		int scnt = 0;
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == 'S') {
				scnt++;
			} else if (ch == 'T') {
				if (scnt > 0) {
					scnt--;
				} else {
					cnt++;
				}
			}
		}
		cnt += scnt;
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
		new A().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
