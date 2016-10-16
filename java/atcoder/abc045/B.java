package atcoder.abc045;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class B {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	String[] card = new String[3];
	int[] idx = new int[3];
	
	void solve(BufferedReader br) throws Exception {
		for (int i=0; i<3; i++) {
			String line = br.readLine();
			card[i] = line;
		}
		int cur = 0;
		while (true) {
			if (idx[cur] >= card[cur].length()) {
				break;
			}
			char next = card[cur].charAt(idx[cur]);
			idx[cur]++;
			cur = next - 'a';
		}
		String player = "ABC";
		pln(player.charAt(cur));
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
