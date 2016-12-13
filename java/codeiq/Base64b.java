package codeiq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/*
問題文「第118回 今週のお題：Base64で反転」

A-Zとa-zの52文字から構成される、長さが 3n の文字列があります。
これをASCIIコードからBase64にエンコードし、左右反転します。
さらにBase64からデコードしたときに、元の文字列と同じになるもののうち、元の文字列に含まれる文字が n 種類のものがいくつあるかを出力してください。
例えば、n = 1 のとき、「TQU」という文字列はエンコードすると「VFFV」となり、左右反転してデコードすると「TQU」に戻ります。
ただ、この場合は「T」「Q」「U」という3種類の文字を使用しています。
同様に、「DQQ」「fYY」は2種類の文字を使用しています。
n = 1 のときは「UUU」の1つだけですので、1を出力します。
なお、n は5以下の整数とします。
 */
public class Base64b {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;
	java.util.Base64.Encoder enc = java.util.Base64.getEncoder();
	java.util.Base64.Decoder dec = java.util.Base64.getDecoder();
	int n;
	int cnt;
	long chkCnt;
	long fltCnt;
	String pattern1 = "QRSTUVWYZa";
	String pattern2 = "FVl";
	
	boolean check(byte[] src) {
		Set<Byte> set = new HashSet<>();
		for (int i=0; i<src.length; i++) {
			if ('A' <= src[i] && src[i] <= 'Z') {
			} else if ('a' <= src[i] && src[i] <= 'z') {
			} else {
				return false;
			}
			set.add(src[i]);
			if (set.size() > n) return false;
		}
		if (set.size() != n) return false;
		return true;
	}
	
	boolean checkN(byte[] src) {
		Set<Byte> set = new HashSet<>();
		for (int i=0; i<src.length; i++) {
			if ('A' <= src[i] && src[i] <= 'Z') {
			} else if ('a' <= src[i] && src[i] <= 'z') {
			} else {
				return true;
			}
			set.add(src[i]);
			if (set.size() > n) return true;
		}
		return false;
	}
	
	void make(String str, boolean bInc) {
		int len = str.length();
		if (len == n*2) {
			chkCnt++;
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			str += sb.toString();
			byte[] src = dec.decode(str);
			if (check(src)) {
				cnt++;
				//pln(str + " " + new String(src));
			}
			return;
		}
		if (len > 0 && len < n*2 && len % 4 == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append(str);
			sb.reverse();
			String s = str + sb.toString();
			byte[] src = dec.decode(s);
			if (checkN(src)) {
				fltCnt++;
				return;
			}
		}
		if (bInc) {
			for (int i=0; i<pattern1.length(); i++) {
				for (int j=0; j<pattern2.length(); j++) {
					if (pattern1.charAt(i) == 'Q' && pattern2.charAt(j) == 'F') continue;
					if (pattern1.charAt(i) == 'Y' && pattern2.charAt(j) == 'F') continue;
					make(str + pattern1.charAt(i) + pattern2.charAt(j), !bInc);
				}
			}
		} else {
			for (int i=0; i<pattern2.length(); i++) {
				for (int j=0; j<pattern1.length(); j++) {
					make(str + pattern2.charAt(i) + pattern1.charAt(j), !bInc);
				}
			}
		}
	}
	
	void solve() {
		n = readNum();
		make("", true);
		pln(cnt);
		//pln(chkCnt);
		//pln(fltCnt);
	}

	int pint(String s) {
		return Integer.parseInt(s);
	}
	String readLine() {
		try {
			_line = _in.readLine();
			return _line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	int readNum() {
		readLine();
		return pint(_line);
	}
	String[] readFields() {
		readLine();
		_flds = _line.split(" ");
		return _flds;
	}
	int[] readNums() {
		readFields();
		_nums = new int[_flds.length];
		for (int i=0; i<_flds.length; i++) {
			_nums[i] = pint(_flds[i]);
		}
		return _nums;
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
	String _line;
	String[] _flds;
	int[] _nums;
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new Base64b().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
