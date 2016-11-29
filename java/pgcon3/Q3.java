package pgcon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q3 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	List<Character> list;
	List<BigInteger> tbl = new ArrayList<>();
	
	void solve() {
		String line = readLine();
		int a = readNum();
		long b = plong(readLine());
		int c = readNum();
		list = new ArrayList<>();
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			list.add(ch);
		}
		Collections.sort(list);
		//long[] tbl = new long[a];
		BigInteger p = BigInteger.valueOf(1);
		BigInteger sz = BigInteger.valueOf(list.size());
		BigInteger bb = BigInteger.valueOf(b);
		//long p = 1;
		boolean bComp = false;
		int f = 0;
		//b--;
		bb = bb.subtract(BigInteger.ONE);
		for (int i=0; i<=a; i++) {
			//pln(p);
			if (!bComp) {
				if (p.compareTo(bb) <= 0) f = i;
				//if (p <= b) f = i;
				else bComp = true;
			}
			tbl.add(p);
			//tbl[i] = p;
			//p *= list.size();
			p = p.multiply(sz);
			//if (p < 0) break;
		}
		for (int i=0; i<c; i++) {
			//pln(f);
			for (int j=0; j<a-f-1; j++) {
				p(list.get(0));
			}
			for (int j=Math.min(f, a-1); j>=0; j--) {
				//int idx = (int)(b / tbl[j] % tbl[1]);
				int idx = bb.divide(tbl.get(j)).mod(sz).intValue();
				p(list.get(idx));
			}
			pln("");
			bb = bb.add(BigInteger.ONE);
			//b++;
			//if (b >= tbl[f]) f++;
			if (bb.compareTo(tbl.get(f)) >= 0) f++;
		}
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
		new Q3().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
