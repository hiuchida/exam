package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/*
電車には進行方向の左右にドアがあり、駅のホームの配置によってどちらかのドアが開きます。
降りる駅で、乗った側のドアと同じドアが開くのであれば、乗った側のドアのそばに立っておくと便利です。
しかし、乗った側のドアが開いたのに降りないと、他の乗客の邪魔になります。

そこで、乗ったときはそのドアのそばに立ち、以下の行動を取ることにします。
・乗った側のドアが開いた場合は、その駅で降りる
・反対側のドアが開き続けた場合は、乗った側のドアが開くまで乗り続ける

電車が片道を走行する間に、二人の乗客がそれぞれ、別々の駅から乗って別々の駅で降ります。
このとき、この二人がそれぞれ反対側のドアで上記の行動を取ることにします。

全部で n 個の駅があったとき、このような行動ができる「ホームの配置」と、
「乗客の動き」の組み合わせが何通りあるかを求めてください。
（ただし、1人目は進行方向の左側のドアから、2人目は右側のドアから乗降するものとします。）

例えば、n = 4 でA駅からD駅に電車が動くとき、以下の6通りがあります。
ホームの配置（開くドア）	乗客の動き
A駅	B駅	C駅	D駅	1人目	2人目
左	左	右	右	A→B	C→D
左	右	左	右	A→C	B→D
左	右	右	左	A→D	B→C
右	左	左	右	B→C	A→D
右	左	右	左	B→D	A→C
右	右	左	左	C→D	A→B

しかし、以下のようなホームの配置の場合は、上記の行動ができません。
ホームの配置（開くドア）	乗客の動き
A駅	B駅	C駅	D駅	1人目	2人目
左	左	右	左	A→B	C→？
左	左	右	左	B→D	C→？

なお、路線は環状にはなっておらず、乗客も折り返すことなく一方向で乗降するものとします。
そのほかの条件は以下になります。
※降りた駅でそのまま再度乗ることはありません
※一度降りてから別の駅で再度乗ることはありません
※乗った駅でそのまま降りることはありません
※必ず二人とも電車に乗る（一方でも電車に乗らないことはない）こととします
※駅では両側のドアが同時に開くことはありません

標準入力から n が与えられたとき、「ホームの配置」と「乗客の動き」の組み合わせを求め、
その数を標準出力に出力してください。
なお、与えられる n は14以下の整数とします。
*/
public class Densya {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	/*
	 * 4:6
	 * 7:588
	 * 10:13842
	 * 12:90134
	 * 14:532506
	 */
	void solve() {
		int n = readNum();
		//int n = 14;
		//int ans = pow(2, n) - 2 * n - 2;
		int ans = dfs(n, 0, 0);
		pln(ans);
	}
	int dfs(int n, int a, int b) {
		if (a+b==n) {
			if (a<2 || b<2) return 0;
			//return combination(a, 2) * combination(b, 2);
			return (a-1) * (b-1);
		}
		int cnt = 0;
		cnt += dfs(n, a+1, b);
		cnt += dfs(n, a, b+1);
		return cnt;
	}
	int combination(int n, int m) {
		return factorial(n) / factorial(n-m) / factorial(m);
	}
	int factorial(int n) {
		if (n == 0) return 1;
		return n * factorial(n-1);
	}
	/*
	int dfs(int n, int a, int b) {
		if (a+b>n) return 0;
		if (a>=2 && b>=2) return 1;
		int cnt = 0;
		cnt += dfs(n, a+1, b);
		cnt += dfs(n, a, b+1);
		return cnt;
	}
	*/
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
		new Densya().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
