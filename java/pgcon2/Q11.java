package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			char ch2 = 0;
			if (i+1<line.length()) {
				ch2 = line.charAt(i+1);
			}
			if (ch == 't' && ch2 == 'a') {
				i++;
			} else {
				sb.append(ch);
			}
		}
		pln(sb.toString());
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
		new Q11().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
