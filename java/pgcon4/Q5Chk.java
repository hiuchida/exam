package pgcon4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5Chk {
	static void check(BufferedReader in, int lvl) throws IOException {
		int line = 1;
		StringBuilder sb = new StringBuilder();
		boolean bComment = false;
		int n = 4096;
		while (true) {
			int ch = in.read();
			if (ch == -1)
				break;
			if (line > n + 2) throw new RuntimeException("over " + (n + 2) + " lines");
			if (ch != '\n' && ch != '\r') {
				sb.append((char)ch);
			}
			if (sb.length() == 1) {
				char ch2 = sb.charAt(0);
				bComment = (ch2 == ';');
			}
			if (line == 1) {
				if (sb.length() > 64) throw new RuntimeException("over 64 columns");
				if ('A' <= ch && ch <= 'Z') {
					//ok
				} else if ('a' <= ch && ch <= 'z') {
					//ok
				} else if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == '+') {
					//ok
				} else if (ch == '/') {
					//ok
				} else if (ch == '\n') {
					//ok
					sb = new StringBuilder();
					line++;
				} else if (ch == '\r') {
					throw new RuntimeException("illegal CR");
				} else {
					throw new RuntimeException("illegal character ch=" + (char)ch + " (" + ch + ")");
				}
			} else if (line == 2) {
				if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == '\n') {
					//ok
					n = Integer.parseInt(sb.toString());
					if (n > 4096) {
						throw new RuntimeException("over 4096 n=" + n);
					}
					sb = new StringBuilder();
					line++;
				} else if (ch == '\r') {
					throw new RuntimeException("illegal CR");
				} else {
					throw new RuntimeException("illegal character ch=" + (char)ch + " (" + ch + ")");
				}
			} else if (bComment) {
				if (sb.length() > 80) throw new RuntimeException("over 80 columns");
				if ('A' <= ch && ch <= 'Z') {
					//ok
				} else if ('a' <= ch && ch <= 'z') {
					//ok
				} else if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == ' ') {
					//ok
				} else if (ch == ';') {
					//ok
				} else if (ch == '+') {
					//ok
				} else if (ch == '/') {
					//ok
				} else if (ch == '-') {
					//ok
				} else if (ch == '$') {
					//ok
				} else if (ch == ',') {
					//ok
				} else if (ch == '(') {
					//ok
				} else if (ch == ')') {
					//ok
				} else if (ch == '<') {
					//ok
				} else if (ch == '>') {
					//ok
				} else if (ch == '=') {
					//ok
				} else if (ch == ':') {
					//ok
				} else if (ch == '\"') {
					//ok
				} else if (ch == '\'') {
					//ok
				} else if (ch == '\n') {
					//ok
					sb = new StringBuilder();
					line++;
				} else if (ch == '\r') {
					throw new RuntimeException("illegal CR");
				} else {
					throw new RuntimeException("illegal character ch=" + (char)ch + " (" + ch + ")");
				}
			} else {
				if (sb.length() > 80) throw new RuntimeException("over 80 columns");
				if ('A' <= ch && ch <= 'Z') {
					//ok
				} else if ('0' <= ch && ch <= '9') {
					//ok
				} else if (ch == ' ') {
					//ok
				} else if (ch == '+') {
					//ok
				} else if (ch == '-') {
					//ok
				} else if (ch == '$') {
					//ok
				} else if (ch == ',') {
					//ok
				} else if (ch == '(') {
					//ok
				} else if (ch == ')') {
					//ok
				} else if (ch == '\n') {
					//ok
					check(lvl, sb.toString());
					sb = new StringBuilder();
					line++;
				} else if (ch == '\r') {
					throw new RuntimeException("illegal CR");
				} else {
					throw new RuntimeException("illegal character ch=" + (char)ch + " (" + ch + ")");
				}
			}
		}
		System.out.println("OK");
	}
	
	static void check(int lvl, String line) {
		if (line.length() < 3) throw new RuntimeException("too short line=" + line);
		if (lvl >= 1) {
			if (line.equals("NOP")) {
				return;
			} else if (line.equals("HLT")) {
				return;
			}
		}
		if (lvl >= 2) {
			if (line.startsWith("MOV ")) {
				return;
			}
		}
		if (lvl >= 3) {
			if (line.startsWith("INC ")) {
				return;
			} else if (line.startsWith("DEC ")) {
				return;
			} else if (line.startsWith("ADD ")) {
				return;
			} else if (line.startsWith("SUB ")) {
				return;
			} else if (line.startsWith("CMP ")) {
				return;
			} else if (line.startsWith("JMP ")) {
				return;
			} else if (line.startsWith("JPZ ")) {
				return;
			} else if (line.startsWith("JNZ ")) {
				return;
			}
		}
		if (lvl >= 4) {
			if (line.startsWith("JPC ")) {
				return;
			} else if (line.startsWith("JNC ")) {
				return;
			}
		}
		throw new RuntimeException("illegal command line=" + line);
	}

	public static void main(String[] args) throws IOException {
		String fname = args[0];
		String name = fname;
		int idx = fname.lastIndexOf('\\');
		if (idx >= 0) {
			name = fname.substring(idx + 1);
		}
		int lvl = 4;
		if (name.charAt(0) == 'a') lvl = 1;
		if (name.charAt(0) == 'b') lvl = 2;
		if (name.charAt(0) == 'c') lvl = 3;
		//if (name.charAt(0) == 'd') lvl = 4;
		System.out.println(fname + " : lvl=" + lvl);
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(fname)));
		check(in, lvl);
		in.close();
	}
}
