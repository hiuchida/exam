package pgcon3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Q4 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	List<String> list1 = new ArrayList<>();
	//List<String> list2 = new ArrayList<>();

	void solve() {
		int n = readNum();
		for (int i=0; i<n; i++) {
			list1.add(readLine());
		}
		int m = readNum();
		//for (int i=0; i<m; i++) {
		//	list2.add(readLine());
		//}
		for (int i=0; i<m; i++) {
			boolean bFirst = true;
			boolean bFind = false;
			//String key = list2.get(i);
			String key = readLine();
			boolean bSrch1 = false;
			boolean bSrch2 = false;
			if (key == null || key.length() == 0) {
				pln("Not match");
				continue;
			}
			if (key.startsWith("%")) {
				bSrch1 = true;
				key = key.substring(1);
			}
			if (key.endsWith("%")) {
				bSrch2 = true;
				key = key.substring(0, key.length()-1);
			}
			for (int j=0; j<n; j++) {
				if (!bSrch1 && !bSrch2) {
					if (list1.get(j).equals(key)) {
						if (!bFirst) p(" ");
						p(j+1);
						bFirst = false;
						bFind = true;
					}
				} else if (bSrch1 && !bSrch2) {
					if (list1.get(j).endsWith(key)) {
						if (!bFirst) p(" ");
						p(j+1);
						bFirst = false;
						bFind = true;
					}
				} else if (!bSrch1 && bSrch2) {
					if (list1.get(j).startsWith(key)) {
						if (!bFirst) p(" ");
						p(j+1);
						bFirst = false;
						bFind = true;
					}
				} else {
					if (list1.get(j).indexOf(key) >= 0) {
						if (!bFirst) p(" ");
						p(j+1);
						bFirst = false;
						bFind = true;
					}
				}
			}
			if (!bFind) pln("Not match");
			else pln("");
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
		new Q4().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
