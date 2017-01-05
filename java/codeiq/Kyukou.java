package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
電車で移動するとき、距離が長くなると各駅停車よりも急行や特急といった電車を利用したくなります。
今回は急行と特急の停車駅を考えます。

全部で n 個の駅があり、そのうち急行の停車駅が a 個、特急の停車駅を b 個とします。
なお、特急の停車駅には必ず急行が停車するものとします。
駅が環状につながっていることはなく、開始駅と終了駅は急行、特急のいずれも停車します。

与えられる n, a, b には n > a > b > 1 の関係があるものとします。
このような停車駅の配置が何通りあるかを求めてください。

例えば、n = 4, a = 3, b = 2 のとき、以下の2通りがあります。
駅	急行停車駅	特急停車駅
A	〇	〇
B	〇	×
C	×	×
D	〇	〇
駅	急行停車駅	特急停車駅
A	〇	〇
B	×	×
C	〇	×
D	〇	〇
なお、出力内容が32bitの整数で収まるような入力が与えられるものとします。
 */
public class Kyukou {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	/*
	 * 4 3 2:2
	 * 5 4 3:6
	 * 10 7 4:560
	 * 20 16 10:9189180
	 * 26 14 7:2141691552
	 */
	void solve() {
		int[] ia = readNums();
		int n = ia[0];
		int a = ia[1];
		int b = ia[2];
		long ans = combination(n-2, a-2) * combination(a-2, b-2);
		pln(ans);
	}
	long combination(long n, long m) {
		if (m == 0 || n == m) return 1;
		if (n - m < m) m = n - m;
		long ans = 1;
		long nn = n;
		for (int i=0; i<m; i++) {
			ans *= nn;
			nn--;
		}
		return ans / factorial(m);
	}
	long factorial(long n) {
		if (n == 0) return 1;
		return n * factorial(n-1);
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
		new Kyukou().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
