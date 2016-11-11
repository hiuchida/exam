package pgcon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Q14 {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	static boolean bElapsed = false;

	enum Status {
		PLUS,
		MINUS
	}
	
	void solve() {
		String line = readLine();
		line = line.replaceAll(" ", "");
		int sum = 0;
		Status sts = Status.PLUS;
		int num = 0;
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			switch (sts) {
			case PLUS:
				if ('0' <= ch && ch <= '9') {
					num *= 10;
					num += (ch - '0');
				} else if (ch == '+') {
					sum += num;
					num = 0;
				} else if (ch == '-') {
					sum += num;
					num = 0;
					sts = Status.MINUS;
				}
				break;
			case MINUS:
				if ('0' <= ch && ch <= '9') {
					num *= 10;
					num += (ch - '0');
				} else if (ch == '+') {
					sum -= num;
					num = 0;
					sts = Status.PLUS;
				} else if (ch == '-') {
					sum -= num;
					num = 0;
				}
				break;
			}
		}
		switch (sts) {
		case PLUS:
			sum += num;
			break;
		case MINUS:
			sum -= num;
			break;
		}
		pln(sum);
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
		new Q14().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
