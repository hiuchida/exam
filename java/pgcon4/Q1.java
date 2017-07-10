/*
 * A - 問題１：「大文字と小文字の交換」
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1 {
	static boolean bElapsed = true;

	static void solve(BufferedReader in) throws IOException {
		String line = in.readLine();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if ('A' <= ch && ch <= 'Z') {
				ch = Character.toLowerCase(ch);
			} else if ('a' <= ch && ch <= 'z') {
				ch = Character.toUpperCase(ch);
			}
			System.out.print(ch);
		}
		System.out.println("");
	}

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		solve(in);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end - start) + "ms");
		}
	}
}
