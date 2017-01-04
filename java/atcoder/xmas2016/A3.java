package atcoder.xmas2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * 100
 * 109227 11010101010101011 10 10 10
 */
public class A3 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	long query(int l, int r) {
		pln("? "+ l + " "+ r);
		_out.flush();
		return plong(readLine());
	}
	int dfs(int n) {
		int a = highestOneBit(n);
		if (a == n) {
			return 1;
		}
		int b = n - a;
		int c = highestOneBit(b * 2);
		int d = c - b;
		int ans1 = 1 + dfs(b);
		int ans2 = 2 + dfs(d);
		return Math.min(ans1, ans2);
	}
	long solve(int l, int r) {
		int a = highestOneBit(r-l);
		long sum = query(l, l+a);
		if (a == r-l) return sum;
		int b = r-l - a;
		int c = highestOneBit(b * 2);
		int d = c - b;
		int ans1 = 1 + dfs(b);
		int ans2 = 2 + dfs(d);
		if (ans1 <= ans2) {
			sum += solve(l+a, r);
		} else {
			sum += solve(r-c, r);
			sum -= solve(r-c, l+a);
		}
		return sum;
	}
	void solve() {
		int n = readNum();
		long sum = solve(0, n);
		pln("! " + sum);
	}
	int highestOneBit(int n) {
		return Integer.highestOneBit(n);
		/*
		int pow = 1;
		while (pow <= n) pow <<= 1;
		return pow >> 1;
		*/
	}
	
	int pint(String s) {
		return Integer.parseInt(s);
	}
	long plong(String s) {
		return Long.parseLong(s);
	}
	String readLine() {
		try {
			return _in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	int readNum() {
		String line = readLine();
		return pint(line);
	}
	String[] readFlds() {
		String line = readLine();
		return line.split(" ");
	}
	int[] readNums() {
		String[] flds = readFlds();
		int[] nums = new int[flds.length];
		for (int i=0; i<flds.length; i++) {
			nums[i] = pint(flds[i]);
		}
		return nums;
	}
	void p(char c) {
		_out.print(c);
	}
	void pln(char c) {
		_out.println(c);
	}
	void p(double d) {
		_out.print(d);
	}
	void pln(double d) {
		_out.println(d);
	}
	void p(long l) {
		_out.print(l);
	}
	void pln(long l) {
		_out.println(l);
	}
	void p(String s) {
		_out.print(s);
	}
	void pln(String s) {
		_out.println(s);
	}
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new A3().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
