package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
9606＋91377 という足し算を筆算で行いましょう。下のようになります。
 
この計算では繰り上がりがあります。
例えば、一の位を足すと 6＋7＝13 です。このとき、十の位に 1 を繰り上げます。
十の位は、繰り上げた 1 を足して、1＋0＋7＝8 と計算します。
同様に、千から一万の位、一万から十万の位でも繰り上がりがあります。
この計算では、計 3 回の繰り上がりがあります。
 
同様に、71＋19 の計算では 1 回、99999＋1 の計算では 5 回の繰り上がりがあります。
 
自然数 n と c に対し、0 以上 10n 未満の整数から 2 つ選び、
この 2 つを足し算したときの繰り上がりの回数がちょうど c 回となるものの個数を F(n, c) と定義します。
例えば F(1, 1)＝45 です。0 以上 10 未満の 2 つの整数の足し算で、繰り上がりがちょうど 1 回となるものは以下の 45 個です。
 
同様に、F(1, 0)＝55, F(2, 0)＝3025, F(2, 1)＝4500, F(2, 2)＝2475, F(3, 1)＝358875 となることが確かめられます。
 
標準入力から、自然数 n と c （1 ≦ n ≦ 8 かつ 0 ≦ c ≦ n）が空白区切りで与えられます。
標準出力に F(n, c) を出力するプログラムを書いてください。
 */
public class CarryOver {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	long[][] count = new long[9][9];

	void solve() {
		init();
		/*
		for (int n=1; n<=8; n++) {
			for (int c=0; c<=n; c++) {
				pln("n="+n+", c="+c+", count="+count[n][c]);
			}
		}
		*/
		int[] ia = readNums();
		int n = ia[0];
		int c = ia[1];
		pln(count[n][c]);
	}
	void init() {
		for (int n=1; n<=8; n++) {
			int max = 1 << n;
			for (int i=0; i<max; i++) {
				boolean bPreCF = false;
				long cnt = 1;
				for (int mask = 1; mask < max; mask <<= 1) {
					if ((i & mask) == 0) {
						cnt *= comb(bPreCF, false);
						bPreCF = false;
					} else {
						cnt *= comb(bPreCF, true);
						bPreCF = true;
					}
				}
				int bitcnt = Integer.bitCount(i);
				count[n][bitcnt] += cnt;
			}
		}
	}
	long comb(boolean bPreCF, boolean bCF) {
		if (!bPreCF) {
			if (!bCF) return 55; //sum(1, 10);
			else return 45; //sum(1, 9);
		} else {
			if (!bCF) return 45; //sum(1, 9);
			else return 55; //sum(1, 10);
		}
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
		new CarryOver().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
