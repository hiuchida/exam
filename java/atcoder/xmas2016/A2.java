package atcoder.xmas2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
 * 100
 * 14043 11011011011011 10 7 10
 */
public class A2 {
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
	void solve() {
		int n = readNum();
		long sum = 0;
		int l = 0;
		int r = n;
		int a = highestOneBit(r-l);
		sum += query(l, l+a);
		l += a;
		n -= a;
		if (n > 0) {
			a >>>= 1;
			while (true) {
				while (a > 0 && (n & a) == 0) a >>>= 1;
				if (a == 0) break;
				int max = a;
				a >>>= 1;
				if ((n & a) == 0) {
					sum += query(l, l+max);
					l += max;
					n -= max;
				} else {
					max <<= 1;
					while (a > 0 && (n & a) > 0) a >>>= 1;
					int min = a;
					if (min == 0) min = 1;
					else min <<= 1;
					sum -= query(l-min, l);
					sum += query(l-min, l-min+max);
					l += max-min;
					n -= max-min;
				}
			}
		}
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
		new A2().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
