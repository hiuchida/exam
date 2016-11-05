package atcoder.disco2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	static boolean bElapsed = false;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int a = Integer.parseInt(flds[0]);
		int b = Integer.parseInt(flds[1]);
		int c = Integer.parseInt(flds[2]);
		double ans = (double)c/(double)a*(double)b;
		System.out.println(ans);
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
		new A().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
