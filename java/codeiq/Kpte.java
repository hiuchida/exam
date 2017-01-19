package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Kpte {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;

	void solve() {
		List<Info> list = new ArrayList<>();
		while (true) {
			String line = readLine();
			if (line == null) break;
			String[] cols = line.split(",");
			Info i = new Info(cols[0], cols.length-1);
			list.add(i);
		}
		Collections.sort(list);
		for (Info i : list) {
			pln(i.name + "," + i.cnt);
		}
	}

	class Info implements Comparable<Info> {
		String name;
		int cnt;
		public Info(String name, int cnt) {
			this.name = name;
			this.cnt = cnt;
		}
		public int compareTo(Info o) {
			if (cnt < o.cnt) return 1;
			else if (cnt > o.cnt) return -1;
			return 0;
		}
		public boolean equals(Object o) {
			if (o instanceof Info) {
				Info that = (Info)o;
				return 0 == compareTo(that);
			}
			return false;
		}
		public int hashCode() {
			return name.hashCode() + (cnt * 31);
		}
		public String toString() {
			return "(" + name + ", " + cnt + ")";
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
		new Kpte().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
