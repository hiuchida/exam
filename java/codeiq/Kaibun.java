package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*

 */
public class Kaibun {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int n;
	int[] num;

	/*
	 * 1:1
	 * 2:1
	 * 3:3
	 * 4:4
	 * 5:7
	 * 6:14 396->143
	 * 7:23 2157->402->407->229
	 * 8:39 18826->4750->3299->1446->655
	 * 9:71 n/a->102352->70003->28623->9623->6617->5668->639
	 */
	void solve() {
		n = readNum();
		//n = 9;
		//for (n=1; n<=9; n++)
		{
			num = new int[n];
			int cnt = 0;
			cnt = dfs(0, 0);
			/*
			int a = pow(10, n-1);
			int b = pow(10, n);
			for (int i=a; i<b; i++) {
				if (check(i)) cnt++;
			}
			*/
			pln(cnt);
		}
	}
	int dfs(int i, int v) {
		if (i == n) {
			if (check(v)) return 1;
			else return 0;
		}
		int nn = n;
		if (i > 0) {
			if (n > 3 && num[0] == n) {
				return 1;
			} else if (n > 3 && num[0] == n-1) {
				return 2;
			} else if (n > 4 && num[0] == n-2) {
				return 3;
			}
			if (n > 3) nn-=2;
			if (n > 4) nn-=1;
			if (n == 9) {
				if (i > 4 && num[0] == 6) nn=3;
				if (i > 5 && num[0] == 5) nn=4;
				if (i > 6 && num[0] == 4) nn=5;
				if (i > 7 && num[0] == 3) nn=6;
			}
		}
		int cnt = 0;
		v *= 10;
		for (int j=1; j<=nn; j++) {
			num[i] = j;
			cnt += dfs(i+1, v+j);
		}
		return cnt;
	}
	boolean check(int v) {
		String s = String.valueOf(v);
		StringBuilder sb = new StringBuilder();
		char prev = s.charAt(0);
		int len = 1;
		for (int i=1; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (prev != ch) {
				sb.append(prev).append((char)(len+'0'));
				prev = ch;
				len = 1;
			} else {
				len++;
			}
		}
		sb.append(prev).append((char)(len+'0'));
		for (int i=0; i<sb.length()/2; i++) {
			char ch1 = sb.charAt(i);
			char ch2 = sb.charAt(sb.length()-1-i);
			if (ch1 != ch2) return false;
		}
		//pln(v);
		return true;
	}

	int pow(int n, int p) {
		return (int)Math.pow(n, p);
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
		new Kaibun().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
