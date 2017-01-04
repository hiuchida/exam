package atcoder.xmas2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class A0 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int cnt10a;
	int cnt10b;
	int cnt11a;
	int cnt11b;

	/*
	 * 47 101111 4 3
	 * 47=32+15=32+16-1=32+32+17
	 * 11011011011011
	 * 10101010101010111
	 * 11010101010101011
	 * 10101010101011011
	 */
	void solve() {
		
		boolean bStop0 = false;
		boolean bStop1 = false;
		boolean bStop2 = false;
		boolean bStop3 = false;
		int max0 = 0;
		int max1 = 0;
		int max2 = 0;
		int max3 = 0;
		for (int i=1; true; i++) {
			int ans0 = bitCount(i);
			int ans1 = dfs(i);
			int ans2 = queryCount(i);
			int ans3 = dfs2(i);
			if (ans0 == 10) bStop0 = true;
			if (ans1 == 10) bStop1 = true;
			if (ans2 == 10) bStop2 = true;
			if (ans3 == 10) bStop3 = true;
			max0 = Math.max(max0, ans0);
			max1 = Math.max(max1, ans1);
			max2 = Math.max(max2, ans2);
			max3 = Math.max(max3, ans3);
			if (ans1 > ans2) System.out.println(i+" "+Integer.toBinaryString(i)+" "+ans0+" "+ans1+" "+ans2+" "+ans3);
			if (bStop3) break;
		}
		System.out.println("max0="+max0+" max1="+max1+" max2="+max2+" max3="+max3);
		System.out.println("cnt10a="+cnt10a+" cnt10b="+cnt10b);
		System.out.println("cnt11a="+cnt11a+" cnt11b="+cnt11b);
		/*
		int i = Integer.parseInt("1110111", 2);
		int ans1 = dfs(i);
		int ans2 = queryCount(i);
		System.out.println(i+" "+Integer.toBinaryString(i)+" "+ans1+" "+ans2);
		*/
	}
	int queryCount(int n) {
		int cnt = 0;
		int a = highestOneBit(n);
		n ^= a;
		cnt++;
		a >>>= 1;
		while (true) {
			while (a > 0 && (n & a) == 0) a >>>= 1;
			if (a == 0) break;
			a >>>= 1;
			if ((n & a) == 0) {
				cnt++;
			} else {
				while ((n & a) > 0) {
					a >>>= 1;
				}
				cnt += 2;
			}
		}
		return cnt;
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
		if (b > 1 && (b & (c >> 2)) == 0) {
			if (ans1 < ans2) cnt10a++;
			else if (ans1 > ans2) {
				//System.out.println(b+" "+Integer.toBinaryString(b));
				cnt10b++;
			}
		} else if (b > 1) {
			if (ans1 < ans2 ) cnt11a++;
			else if (ans1 > ans2) cnt11b++;
		}
		if (false)
			System.out.println("n="+n+" a="+a+" b="+b+" c="+c+" d="+d+" ans1="+ans1+" ans2="+ans2);
		return Math.min(ans1, ans2);
	}
	int dfs2(int n) {
		int a = highestOneBit(n);
		if (a == n) {
			return 1;
		}
		int b = n - a;
		int c = highestOneBit(b * 2);
		int d = c - b;
		if ((b & (c >> 2)) == 0) {
			return 1 + dfs2(b);
		} else {
			return 2 + dfs2(d);
		}
	}
	int bitCount(int n) {
		return Integer.bitCount(n);
	}
	int highestOneBit(int n) {
		return Integer.highestOneBit(n);
		/*
		int pow = 1;
		while (pow <= n) pow *= 2;
		return pow / 2;
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
		new A0().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
