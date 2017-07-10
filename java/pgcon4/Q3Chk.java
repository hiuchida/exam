package pgcon4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q3Chk {
	static void check(BufferedReader in, int lvl) throws IOException {
		int line = 1;
		StringBuilder sb = new StringBuilder();
		int n = 0;
		int m = 0;
		while (true) {
			int ch = in.read();
			if (ch == -1)
				break;
			if (ch != '\n' && ch != '\r') {
				sb.append((char)ch);
			}
			if (line == 1) {
				if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == ' ') {
					//ok
				} else if (ch == '\n') {
					//ok
					String s = sb.toString();
					check(lvl, s);
					String[] cols = s.split(" ");
					n = Integer.parseInt(cols[0]);
					m = Integer.parseInt(cols[1]);
					if (m > 225) throw new RuntimeException("illegal m m=" + m);
					sb = new StringBuilder();
					line++;
				} else {
					throw new RuntimeException("illegal character ch=" + ch);
				}
			} else {
				if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == ' ') {
					//ok
				} else if (ch == '\n') {
					//ok
					String s = sb.toString();
					String[] cols = s.split(" ");
					if (cols.length != n) throw new RuntimeException("illegal cols line=" + s);
					sb = new StringBuilder();
					line++;
				} else {
					throw new RuntimeException("illegal character ch=" + ch);
				}
			}
		}
		System.out.println("OK");
	}
	
	static void check(int lvl, String line) {
		if (line.charAt(1) == ' ') {
			if (lvl == 1) {
				if (line.charAt(0) == '3') {
					return;
				}
			} else {
				if (line.charAt(0) >= '2' && line.charAt(0) <= '5') {
					return;
				}
			}
		}
		throw new RuntimeException("illegal n n=" + line.charAt(0));
	}

	public static void main(String[] args) throws IOException {
		String fname = args[0];
		String name = fname;
		int idx = name.lastIndexOf('\\');
		if (idx >= 0) {
			name = name.substring(idx + 1);
		}
		int lvl = 2;
		if (name.charAt(0) == 'a') lvl = 1;
		System.out.println(fname + " : lvl=" + lvl);
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
		check(in, lvl);
		in.close();
	}
}
