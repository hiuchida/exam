package pgcon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Q5 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int n;
	int[] price;
	int[] num = { 20, 9, 6, 4 };
	long answerP = _longMax;
	List<Integer> list = new ArrayList<>();
	List<Integer> answerList = new ArrayList<>();

	void solve() {
		int[] ia = readNums();
		n = ia[0];
		price = new int[4];
		for (int i=0; i<4; i++) {
			price[i] = ia[i+1];
		}
		dfs(0, n, 0);
		//pln(answerP);
		//pln(answerList.toString());
		for (int i=0; i<answerList.size(); i++) {
			if (i != 0) p(" ");
			p(answerList.get(i));
		}
		pln("");
	}
	void dfs(int i, int n, long p) {
		//pln(i+" "+n+" "+p);
		if (i == 4) {
			if (n == 0) {
				if (answerP > p) {
					answerP = p;
					answerList = new ArrayList<>(list);
				} else if (answerP == p && check()) {
					answerList = new ArrayList<>(list);
				}
			}
			return;
		}
		int v = num[i];
		for (int j=0; j<=n/v; j++) {
			list.add(j);
			long np = p + price[i] * j;
			dfs(i+1, n-v*j, np);
			list.remove(list.size()-1);
		}
		return;
	}
	boolean check() {
		int cnt = 0;
		for (int i : list) {
			cnt += i;
		}
		int ansCnt = 0;
		for (int i : answerList) {
			ansCnt += i;
		}
		return cnt < ansCnt;
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
		new Q5().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
