package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
public class Magic4 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int[][] map;
	TreeSet<Integer> set = new TreeSet<>();
	int cnt;
	long start;
	Map<String, Integer> score = new HashMap<>();
	Counter counter = new Counter();
	int[][] answer = {
			{54,8},
			{55,24},
			{56,32},
			{57,60},
			{58,104},
			{59,96},
			{60,52},
			{61,72},
			{62,124},
			{63,188},
			{64,136},
			{65,272},
			{66,336},
			{67,408},
			{68,336},
			{69,416},
			{70,416},
			{71,468},
			{72,460},
			{73,372},
			{74,340},
			{75,352},
			{76,408},
			{77,400},
			{78,396},
			{79,228},
			{80,320},
			{81,160},
			{82,56},
	};

	void solve() {
		int n = readNum();
		for (int i=0; i<answer.length; i++) {
			if (n == answer[i][0]) {
				pln(answer[i][1]);
				break;
			}
		}
	}
	/*
	void solve() {
		map = new int[4][4];
		for (int i=1; i<=16; i++) {
			set.add(i);
		}
		start = System.currentTimeMillis();
		int[] sumcol = new int[6];
		dfs(0, 0, 0, sumcol);
		for (Object o : counter.map.keySet()) {
			pln(""+o+","+counter.get(o));
		}
	}
	*/
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
				String k1 = keyrow(true);
				String k2 = keycol(true);
				String k3 = keyrow(false);
				String k4 = keycol(false);
				String key1 = k1+k2+k3+k4;
				String key2 = k2+k1+k4+k3;
				String key3 = k3+k4+k1+k2;
				String key4 = k4+k3+k2+k1;
				int s = score();
				Integer sc1 = score.get(key1);
				Integer sc2 = score.get(key2);
				Integer sc3 = score.get(key3);
				Integer sc4 = score.get(key4);
				if (sc1 == null && sc2 == null && sc3 == null && sc4 == null) {
					cnt++;
					score.put(key1, s);
					score.put(key2, s);
					score.put(key3, s);
					score.put(key4, s);
					print(s, key1, key2);
					counter.add(s);
				} else if (sc1 != null) {
					if (s != sc1) System.err.println("!!!"+cnt);
					counter.add(s);
				} else if (sc2 != null) {
					if (s != sc2) System.err.println("!!!"+cnt);
					counter.add(s);
				} else if (sc3 != null) {
					if (s != sc3) System.err.println("!!!"+cnt);
					counter.add(s);
				} else if (sc4 != null) {
					if (s != sc4) System.err.println("!!!"+cnt);
					counter.add(s);
				}
			}
			return;
		}
		int reserve = 0;
		int h = set.last();
		int l = set.first();
		if (x == 3) {
			if (!set.contains(34-sumrow)) return;
			reserve = 34-sumrow;
		}
		if (x == 2) {
			if (sumrow+h+set.lower(h) < 34) return;
			if (sumrow+l+set.higher(l) > 34) return;
		}
		if (y == 3) {
			if (!set.contains(34-sumcol[x])) return;
			reserve = 34-sumcol[x];
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
			if (reserve > 0 && reserve != v) continue;
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
	String keyrow(boolean bInc) {
		StringBuilder sb = new StringBuilder();
		if (bInc) {
			for (int i=0; i<4; i++) {
				sb.append(Integer.toHexString(map[0][i]-1));
			}
		} else {
			for (int i=0; i<4; i++) {
				sb.append(Integer.toHexString(map[3][3-i]-1));
			}
		}
		return sb.toString();
	}
	String keycol(boolean bInc) {
		StringBuilder sb = new StringBuilder();
		if (bInc) {
			for (int i=0; i<4; i++) {
				sb.append(Integer.toHexString(map[i][0]-1));
			}
		} else {
			for (int i=0; i<4; i++) {
				sb.append(Integer.toHexString(map[3-i][3]-1));
			}
		}
		return sb.toString();
	}
	int score() {
		int[][] sc = new int[4][4];
		sc[0][0] = map[0][0];
		int[] dx = { 0, 1, 0, 2, 1, 0, 3, 2, 1, 0, 3, 2, 1, 3, 2 };
		int[] dy = { 0, 0, 1, 0, 1, 2, 0, 1, 2, 3, 1, 2, 3, 2, 3 };
		for (int i=0; i<dx.length; i++) {
			int x = dx[i];
			int y = dy[i];
			if (x+1 < 4) sc[y][x+1] = Math.max(sc[y][x+1], sc[y][x]+map[y][x+1]);
			if (y+1 < 4) sc[y+1][x] = Math.max(sc[y+1][x], sc[y][x]+map[y+1][x]);
		}
		return sc[3][3];
	}
	void print(int s, String key1, String key2) {
		long end = System.currentTimeMillis();
		pln("#"+cnt+" "+(end-start)/1000+"s "+s+" "+key1+" "+key2);
		for (int y=0; y<4; y++) {
			for (int x=0; x<4; x++) {
				p(String.format("%2d ", map[y][x]));
			}
			pln("");
		}
		_out.flush();
	}

	class Counter {
		Map<Object,Integer> map = new HashMap<>();
		void add(Object o) {
			Integer v = map.get(o);
			if (v == null) {
				map.put(o, 1);
			} else {
				map.put(o, v+1);
			}
		}
		int get(Object o) {
			Integer v = map.get(o);
			if (v == null) {
				return 0;
			} else {
				return v;
			}
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
		new Magic4().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
