/*
 * E - 問題５：「アセンブリ言語インタプリター」
 */
package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q5 {
	static boolean bElapsed = true;

	static int lvl = 4;
	static boolean bLv1 = lvl >= 1;
	static boolean bLv2 = lvl >= 2;
	static boolean bLv3 = lvl >= 3;
	static boolean bLv4 = lvl >= 4;

	static final int maxMemory = 64; // メインメモリ最大サイズ
	static final int maxRegister = 6; // レジスター数
	static final char minRegChar = 'A'; // 最初のレジスターの文字
	static final char maxRegChar = 'F'; // 最後のレジスターの文字
	static final int maxLine = 64 * 64; // スクリプト最大サイズ
	static final int maxExecute = 25000; // 最大実行行数

	static void solve(BufferedReader in) throws IOException {
		VM vm = new VM();
		vm.initMemory(in.readLine());
		int n = Integer.parseInt(in.readLine());
		if (n > maxLine)
			throw new RuntimeException("Too many script");
		for (int i = 0; i < n; i++) {
			vm.addScript(in.readLine());
		}
		vm.runScript();
		vm.printMemory();
	}

	// 仮想マシンクラス
	static class VM {
		byte[] mem = new byte[maxMemory]; // メインメモリ
		byte[] reg = new byte[maxRegister]; // レジスター
		boolean zflg = false; // ゼロフラグ
		boolean cflg = false; // キャリーフラグ
		int pc = 0; // プログラムカウンター
		List<String> scriptList = new ArrayList<>(); // スクリプトリスト

		// メインメモリを初期化する
		void initMemory(String memstr) {
			if (memstr.length() != maxMemory)
				throw new RuntimeException("Illegal memory data");
			for (int i = 0; i < memstr.length(); i++) {
				byte val = base64Decode(memstr.charAt(i));
				mem[i] = val;
			}
		}

		// スクリプトを登録する
		void addScript(String line) {
			if (line.charAt(0) == ';')
				line = "NOP";
			scriptList.add(line);
		}

		// スクリプトを実行する
		void runScript() {
			boolean bHalt = false;
			for (int i = 0; !bHalt; i++) {
				// printRegister();
				if (i >= maxExecute)
					throw new RuntimeException("Too many execute");
				if (pc < 0 || pc >= scriptList.size())
					throw new RuntimeException("pc is out of range. pc=" + pc);
				String line = scriptList.get(pc);
				bHalt = exec(line);
			}
			// printRegister();
		}

		// スクリプトを1行実行する
		boolean exec(String line) {
			String[] ope = line.split(" ");
			if (bLv1) {
				if ("NOP".equals(ope[0]))
					return execNop();
				else if ("HLT".equals(ope[0]))
					return execHlt();
			}
			if (bLv2) {
				if ("MOV".equals(ope[0]))
					return execMov(ope[1]);
			}
			if (bLv3) {
				if ("INC".equals(ope[0]))
					return execInc(ope[1], (byte) 1);
				else if ("DEC".equals(ope[0]))
					return execInc(ope[1], (byte) -1);
				else if ("ADD".equals(ope[0]))
					return execAdd(ope[1], (byte) 1);
				else if ("SUB".equals(ope[0]))
					return execAdd(ope[1], (byte) -1);
				else if ("CMP".equals(ope[0]))
					return execCmp(ope[1]);
				else if ("JMP".equals(ope[0]))
					return execJmp(ope[1], true);
				else if ("JPZ".equals(ope[0]))
					return execJmp(ope[1], zflg);
				else if ("JNZ".equals(ope[0]))
					return execJmp(ope[1], !zflg);
			}
			if (bLv4) {
				if ("JPC".equals(ope[0]))
					return execJmp(ope[1], cflg);
				else if ("JNC".equals(ope[0]))
					return execJmp(ope[1], !cflg);
			}
			throw new RuntimeException("Illegal Opecode line=" + line);
		}

		// NOP命令を実行する
		boolean execNop() {
			pc++;
			return false;
		}

		// HLT命令を実行する
		boolean execHlt() {
			return true;
		}

		// MOV命令を実行する
		boolean execMov(String ope) {
			String[] param = ope.split(",");
			byte val = getMultiValue(param[1]);
			setMultiValue(param[0], val);
			pc++;
			return false;
		}

		// INC命令を実行する。DEC命令も共通。
		boolean execInc(String ope, byte delta) {
			byte val = getRegisterValue(ope);
			val += delta;
			val = round(val);
			setRegisterValue(ope, val);
			pc++;
			return false;
		}

		// ADD命令を実行する。SUB, ADC, SBC命令も共通。
		boolean execAdd(String ope, byte delta) {
			String[] param = ope.split(",");
			byte val1 = getRegisterValue(param[0]);
			byte val2 = getRegisterValue(param[1]);
			val1 += val2 * delta;
			val1 = round(val1);
			setRegisterValue(param[0], val1);
			pc++;
			return false;
		}

		// CMP命令を実行する
		boolean execCmp(String ope) {
			String[] param = ope.split(",");
			byte val1 = getRegisterValue(param[0]);
			byte val2 = getRegisterValue(param[1]);
			zflg = (val1 == val2);
			cflg = (val1 < val2);
			pc++;
			return false;
		}

		// JMP命令を実行する。JPZ, JNZ, JPC, JNC命令も共通。
		boolean execJmp(String ope, boolean bJmp) {
			if (bJmp) {
				int n = Integer.parseInt(ope.substring(1));
				pc += n;
			} else {
				pc++;
			}
			return false;
		}

		// フラグを更新し、1バイトに丸める。
		byte round(byte val) {
			cflg = (val < 0 || val > 63);
			val = (byte) (val & 0x3F);
			zflg = (val == 0);
			return val;
		}

		// レジスタを取得する。
		byte getRegisterValue(String operand) {
			char ch1 = operand.charAt(0);
			if (minRegChar <= ch1 && ch1 <= maxRegChar) {
				return reg[ch1 - minRegChar];
			} else {
				throw new RuntimeException("Unknown operand. operand=" + operand);
			}
		}

		// レジスタに値を設定する。
		void setRegisterValue(String operand, byte val) {
			char ch1 = operand.charAt(0);
			if (minRegChar <= ch1 && ch1 <= maxRegChar) {
				reg[ch1 - minRegChar] = val;
			} else {
				throw new RuntimeException("Unknown operand. operand=" + operand);
			}
		}

		// レジスタ、メインメモリ、定数を取得する。
		byte getMultiValue(String operand) {
			int len = operand.length();
			char ch1 = operand.charAt(0);
			if (minRegChar <= ch1 && ch1 <= maxRegChar) {
				return reg[ch1 - minRegChar];
			} else if (len == 3 && ch1 == '(' && operand.charAt(2) == ')') {
				char ch2 = operand.charAt(1);
				return mem[reg[ch2 - minRegChar]];
			} else if ('0' <= ch1 && ch1 <= '9') {
				return Byte.parseByte(operand);
			} else {
				throw new RuntimeException("Unknown operand. operand=" + operand);
			}
		}

		// レジスタ、メインメモリに値を設定する。
		void setMultiValue(String operand, byte val) {
			int len = operand.length();
			char ch1 = operand.charAt(0);
			if (minRegChar <= ch1 && ch1 <= maxRegChar) {
				reg[ch1 - minRegChar] = val;
			} else if (len == 3 && ch1 == '(' && operand.charAt(2) == ')') {
				char ch2 = operand.charAt(1);
				mem[reg[ch2 - minRegChar]] = val;
			} else {
				throw new RuntimeException("Unknown operand. operand=" + operand);
			}
		}

		// レジスタを表示する。
		void printRegister() {
			StringBuilder sb = new StringBuilder();
			sb.append("pc=" + pc + ", zflg=" + zflg + ", cflg=" + cflg);
			for (int i = 0; i < reg.length; i++) {
				sb.append(", ");
				sb.append((char) (i + minRegChar));
				sb.append("=");
				sb.append(reg[i]);
			}
			System.out.println(sb.toString());
		}

		// メインメモリを表示する。
		void printMemory() {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mem.length; i++) {
				sb.append(base64Encode(mem[i]));
			}
			System.out.println(sb.toString());
		}

		// base64エンコードする。
		char base64Encode(int v) {
			if (0 <= v && v <= 25) {
				return (char) ('A' + v);
			} else if (26 <= v && v <= 51) {
				return (char) ('a' + v - 26);
			} else if (52 <= v && v <= 61) {
				return (char) ('0' + v - 52);
			} else if (v == 62) {
				return '+';
			} else if (v == 63) {
				return '/';
			}
			throw new RuntimeException("base64Encode v=" + v);
		}

		// base64デコードする。
		byte base64Decode(char c) {
			if ('A' <= c && c <= 'Z') {
				return (byte) (c - 'A');
			} else if ('a' <= c && c <= 'z') {
				return (byte) (c - 'a' + 26);
			} else if ('0' <= c && c <= '9') {
				return (byte) (c - '0' + 52);
			} else if (c == '+') {
				return 62;
			} else if (c == '/') {
				return 63;
			}
			throw new RuntimeException("base64Decode c=" + c);
		}
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
