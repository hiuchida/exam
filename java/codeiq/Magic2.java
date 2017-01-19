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
public class Magic2 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int[][] map;
	Set<Integer> set = new TreeSet<>();
	int cnt;
	long start;
	Set<Integer> sumset = new TreeSet<>();

	void solve() {
		map = new int[4][4];
		for (int i=1; i<=16; i++) set.add(i);
		start = System.currentTimeMillis();
		dfs(0, 0);
	}
	void dfs(int x, int y) {
		if (x >= 4) {
			x = 0;
			y++;
		}
		if (y >= 4) {
			if (check()) {
				cnt++;
				print();
			}
			return;
		}
		if (x == 0 && y >= 1) {
			if (!checkrow(y)) return; 
		}
		Set<Integer> nset = new TreeSet<>(set);
		for (int v : nset) {
			map[y][x] = v;
			set.remove(v);
			dfs(x+1, y);
			map[y][x] = 0;
			set.add(v);
		}
	}
	boolean checkrow(int y) {
		int sum1 = 0;
		for (int x=0; x<4; x++) {
			sum1 += map[y-1][x];
		}
		if (sum1 != 34) return false;
		return true;
	}
	boolean check() {
		int sum1 = 0;
		int sum2 = 0;
		for (int i=0; i<4; i++) {
			sum1 += map[i][i];
			sum2 += map[i][3-i];
		}
		if (sum1 != sum2) return false;
		for (int y=0; y<4; y++) {
			int sum3 = 0;
			int sum4 = 0;
			for (int x=0; x<4; x++) {
				sum3 += map[y][x];
				sum4 += map[x][y];
			}
			if (sum1 != sum3) return false;
			if (sum1 != sum4) return false;
		}
		sumset.add(sum1);
		return true;
	}
	void print() {
		long end = System.currentTimeMillis();
		pln("#"+cnt+" "+(end-start)/1000+"s "+sumset);
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
		new Magic2().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
