package atcoder.abc045;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int len = line.length();
		long sum = 0;
		int max = 1 << (len-1);
		for (int i=0; i<max; i++) {
			int mask = max;
			StringBuilder sb = new StringBuilder();
			sb.append(line.charAt(0));
			for (int j=1; j<len; j++) {
				mask >>= 1;
				if ((i & mask) == mask) {
					sum += Long.parseLong(sb.toString());
					sb = new StringBuilder();
				}
				sb.append(line.charAt(j));
			}
			sum += Long.parseLong(sb.toString());
		}
		pln(sum);
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
		new C().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
