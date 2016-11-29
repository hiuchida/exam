package pgcon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Q1 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	void solve() {
		String[] flds = readFlds();
		String s1 = String.format("%-19s", flds[0]);
		String s2 = String.format("%19s", flds[1]);
		String s3 = String.format("%09d", pint(flds[2]));
		String s4 = String.format("%9d", pint(flds[3]));
		String s5 = String.format("%9.3f", Double.parseDouble(flds[4]));
		pln(s1+" "+s2+" "+s3+" "+s4+" "+s5);
	}

	long ceil2pow(long n) {
		if (n == 0) return 1;
		n--;
		n |= (n >>> 1);
		n |= (n >>> 2);
		n |= (n >>> 4);
		n |= (n >>> 8);
		n |= (n >>> 16);
		n++;
		return n;
		/*
		long pow = 1;
		while (pow < n) pow <<= 1;
		return pow;
		*/
	}
	int gcd(int a, int b) {
		if (a < b) return gcd(b, a);
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	long sqrt(long n) {
		return (long)Math.sqrt(n);
	}
	long pow(long n, long p) {
		return (long)Math.pow(n, p);
	}
	long pow_mod(long n, long p, long m) {
		if (p == 0) return 1;
		else if (p % 2 == 1) return pow_mod(n, p-1, m) * n % m;
		long sum = pow_mod(n, p/2, m);
		return sum * sum % m;
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
		new Q1().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
