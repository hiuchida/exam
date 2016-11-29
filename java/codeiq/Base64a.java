package codeiq;

//118, 160, 120 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Base64a {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = true;
	byte[] chars = new byte[26+26];
	java.util.Base64.Encoder enc = java.util.Base64.getEncoder();
	java.util.Base64.Decoder dec = java.util.Base64.getDecoder();
	int n;
	int idx;
	int[] threes = new int[3*5+1];
	String[] threeStrs = { "00", "01", "10" };
	byte[] buf;
	
	byte decode(char ch) {
		if ('A' <= ch && ch <= 'Z') {
			return (byte)(ch - 'A');
		} else if ('a' <= ch && ch <= 'z') {
			return (byte)(ch - 'a' + 26);
		} else if ('0' <= ch && ch <= '9') {
			return (byte)(ch - '0' + 52);
		} else if (ch == '+') {
			return 62;
		} else if (ch == '/') {
			return 63;
		}
		throw new RuntimeException();
	}
	
	void decode(String str, int i) {
		byte ch1 = decode(str.charAt(i*4));
		byte ch2 = decode(str.charAt(i*4+1));
		byte ch3 = decode(str.charAt(i*4+2));
		byte ch4 = decode(str.charAt(i*4+3));
		buf[i*3] = (byte)((ch1 << 2) | (ch2 >> 4));
		buf[i*3+1] = (byte)((ch2 << 4) | (ch3 >> 2));
		buf[i*3+2] = (byte)((ch3 << 6) | ch4);
	}
	
	void decode(String str) {
		for (int i=0; i<n; i++) {
			decode(str, i);
		}
	}
	
	void check(String str, byte[] b1, byte[] b2) {
		for (int i=0; i<b1.length; i++) {
			if (b1[i] != b2[i]) {
				pln(str+" "+i+" "+b1[i]+" "+b2[i]);
			}
		}
	}
	
	void test(String str) {
		String table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
		if (str.length() == 4) {
			decode(str);
			//byte[] org = dec.decode(str);
			//check(str, buf, org);
			return;
		}
		for (int i=0; i<table.length(); i++) {
			test(str + table.charAt(i));
		}
	}
	
	void init() {
		threes[0] = 1;
		for (int i=1; i<threes.length; i++) {
			threes[i] = 3 * threes[i-1];
		}
	}
	
	char getChar() {
		char ch = (char)('a' + idx);
		idx++;
		return ch;
	}
	
	String getPattern1() {
		char ch;
		StringBuilder sb = new StringBuilder();
		sb.append("01");
		ch = getChar();
		sb.append(ch).append(ch);
		ch = getChar();
		sb.append(ch).append(ch);
		return sb.toString();
	}

	String getPattern2() {
		char ch;
		StringBuilder sb = new StringBuilder();
		ch = getChar();
		sb.append(ch).append(ch);
		sb.append("0101");
		return sb.toString();
	}
	
	void solve() {
		n = 1;
		buf = new byte[n*3];
		test("");
		/*
		init();
		n = readNum();
		//6ビットごとのビット列を作る
		List<String> list = new ArrayList<>();
		for (int i=1; i<=n; i++) {
			if (i % 2 == 1) {
				list.add(getPattern1());
				list.add(getPattern2());
			} else {
				list.add(getPattern2());
				list.add(getPattern1());
			}
		}
		for (int i=list.size()-1; i>=0; i--) {
			list.add(list.get(i));
		}
		//8ビットごとのビット列を作る
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<list.size(); i++) {
			sb.append(list.get(i));
		}
		String master = sb.toString();
		//3^(3*n)通りの文字列をチェック
		int max = threes[n*3];
		int cnt = 0;
		for (int i=0; i<max; i++) {
			String str = master;
			for (int j=0; j<n*3; j++) {
				char ch = (char)('a' + j);
				String from = String.valueOf(ch) + String.valueOf(ch);
				int idx = i / threes[j] % 3;
				str = str.replaceAll(from, threeStrs[idx]);
			}
			String s0 = str.replaceAll("0", "").replaceAll("1", "");
			if (s0.length() > 0) pln(str);
			Set<String> set = new HashSet<>();
			boolean bErr = false;
			sb = new StringBuilder();
			for (int j=0; j<str.length(); j+=8) {
				String s = str.substring(j, j+8);
				if ("01000001".compareTo(s) <= 0 && s.compareTo("01011010") <= 0) {
				} else if ("01100001".compareTo(s) <= 0 && s.compareTo("01111010") <= 0) {
				} else {
					//set.add(s);
					bErr = true;
					break;
				}
				set.add(s);
				if (set.size() > n) break;
				char ch = (char)Integer.parseInt(s, 2);
				sb.append(ch);
			}
			if (!bErr && set.size() == n) {
				cnt++;
				pln(set.toString() + " " + sb.toString());
			}
		}
		pln(cnt);
		*/
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
		new Base64a().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
