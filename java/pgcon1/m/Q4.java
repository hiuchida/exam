package pgcon1.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q4 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayList<Integer> dot = new ArrayList<Integer>();
		ArrayList<String> write = new ArrayList<String>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		StringTokenizer token = new StringTokenizer(line, " ");

		while ((line = br.readLine()) != null) {
			token = new StringTokenizer(line, " ");
			while (token.hasMoreTokens()) {
				int d = Integer.parseInt(token.nextToken(), 16);
				dot.add(d);
			}
			break;
		}

		for (int i = 0; i < dot.size(); i++) {
			int x = dot.get(i);
			int y = 128;
			while (y >= 1) {
				if (x >= y) {
					write.add("X");
					x = x - y;
					y = y / 2;
				} else {
					write.add(".");
					y = y / 2;
				}
			}
		}

		for (int i = 0; i < write.size(); i++) {
			if (i % 24 == 23) {
				System.out.println(write.get(i));
			} else {
				System.out.print(write.get(i));
			}
		}

		System.out.println("");

		String[] write0 = new String[write.size()];
		for (int i = 0; i < write.size(); i++) {
			int j = i / 24;
			int a = 24 * (i - (24 * j) + 1) - j - 1;
			write0[a] = write.get(i);
		}

		for (int i = 0; i < write.size(); i++) {
			if (i % 24 == 23) {
				System.out.println(write0[i]);
			} else {
				System.out.print(write0[i]);
			}
		}
	}
}
