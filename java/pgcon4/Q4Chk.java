package pgcon4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4Chk {
	static void check(BufferedReader in, int lvl) throws IOException {
		int maxCnt = 30;
		if (lvl == 1) maxCnt = 16;
		int cnt = 0;
		while (true) {
			int ch = in.read();
			if (ch == -1)
				break;
			cnt++;
			if (cnt > maxCnt) throw new RuntimeException("over " + maxCnt + " columns");
			if ('0' <= ch && ch <= '9') {
				//ok
			} else {
				throw new RuntimeException("illegal character ch=" + ch);
			}
		}
		System.out.println("OK");
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
