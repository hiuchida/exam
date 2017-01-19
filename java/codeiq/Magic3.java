package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;
import java.util.TreeSet;

/*
４×４の魔方陣は1～16までの数字を１度ずつ使ったもので、以下の左図のようなものがあります。
魔方陣は縦、横、斜めのすべての列について、その和が等しいという特徴があります。

魔方陣において、左上のマスからスタートして、右か下の隣り合うマスへの移動を繰り返して最短距離で右下のマスまで移動します。
このとき、経由したマスの数の和が最大になるような移動経路を考えます。
上図の魔方陣の場合、上図右のように移動すると和は 67 になります。

標準入力から整数 n が与えられたとき、４×４のすべての魔方陣に対してこのような移動経路を求め、
その和が n になる魔方陣の個数を求め、標準出力に出力してください。

４×４の魔方陣は全部で7,040個存在することが知られています。
その中で、n=54のときは以下の2パターンに回転や鏡像を含めたものが全部で8通りありますので、
以下のような入出力になります。
*/
public class Magic3 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int[][] map;
	TreeSet<Integer> set = new TreeSet<>();
	int cnt;
	long start;

	void solve() {
		map = new int[4][4];
		for (int i=1; i<=16; i++) {
			set.add(i);
		}
		start = System.currentTimeMillis();
		int[] sumcol = new int[6];
		dfs(0, 0, 0, sumcol);
	}
	void dfs(int x, int y, int sumrow, int[] sumcol) {
		if (sumrow > 34) return;
		if (x >= 4) {
			if (sumrow != 34) return;
			sumrow = 0;
			x = 0;
			y++;
		}
		if (y >= 4) {
			if (check(sumcol)) {
				cnt++;
				print();
			}
			return;
		}
		int h = set.last();
		int l = set.first();
		if (x == 3) {
			if (!set.contains(34-sumrow)) return;
		}
		if (x == 2) {
			if (sumrow+h+set.lower(h) < 34) return;
			if (sumrow+l+set.higher(l) > 34) return;
		}
		if (y == 3) {
			if (!set.contains(34-sumcol[x])) return;
			if (x == 0) {
				if (!set.contains(34-sumcol[5])) return;
			}
			else if (x == 3) {
				if (!set.contains(34-sumcol[4])) return;
			}
		}
		if (y == 2) {
			if (sumcol[x]+h+set.lower(h) < 34) return;
			if (sumcol[x]+l+set.higher(l) > 34) return;
		}
		Set<Integer> nset = new TreeSet<>(set);
		for (int v : nset) {
			map[y][x] = v;
			set.remove(v);
			sumcol[x] += v;
			if (x == y) sumcol[4] += v;
			if (x == 3-y) sumcol[5] += v;
			dfs(x+1, y, sumrow+v, sumcol);
			map[y][x] = 0;
			set.add(v);
			sumcol[x] -= v;
			if (x == y) sumcol[4] -= v;
			if (x == 3-y) sumcol[5] -= v;
		}
	}
	boolean check(int[] sumcol) {
		for (int i=0; i<6; i++) {
			if (sumcol[i] != 34) return false;
		}
		return true;
	}
	void print() {
		long end = System.currentTimeMillis();
		pln("#"+cnt+" "+(end-start)/1000+"s");
		for (int y=0; y<4; y++) {
			for (int x=0; x<4; x++) {
				p(String.format("%2d ", map[y][x]));
			}
			pln("");
		}
		_out.flush();
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
		new Magic3().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
