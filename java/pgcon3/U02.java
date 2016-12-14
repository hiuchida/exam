package pgcon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class U02 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = true;
	int[] cache;
	List<BigInteger> list;

	void solve() {
		int[] ia = readNums();
		int n = ia[0];
		int m = ia[1];
		int k = ia[2];
		cache = new int[m+1];
		list = new ArrayList<>(m+1);
		for (int i=0; i<=m; i++) {
			list.add(null);
		}
		BigInteger kk = BigInteger.valueOf(k);
		for (int i=0; i<n; i++) {
			int v = readNum();
			//int r = logic1(v, k);
			//int r = logic2(v, k);
			BigInteger rr = logic3(v);
			//pln(rr.toString());
			int r = rr.mod(kk).intValue();
			pln(r);
		}
	}
	int logic1(int n, int k) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		return (logic1(n-2, k) + logic1(n-1, k)) % k;
	}
	int logic2(int n, int k) {
		if (n == 0) return 0;
		else if (n == 1) return 1;
		if (cache[n] > 0) return cache[n];
		int r = (logic2(n-2, k) + logic2(n-1, k)) % k;
		cache[n] = r;
		return r;
	}
	BigInteger logic3(int n) {
		if (n == 0) return BigInteger.ZERO;
		else if (n == 1) return BigInteger.ONE;
		if (list.get(n) != null) return list.get(n);
		BigInteger r1 = logic3(n-2);
		BigInteger r2 = logic3(n-1);
		BigInteger r = r1.add(r2);
		list.set(n, r);
		return r;
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
		new U02().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
