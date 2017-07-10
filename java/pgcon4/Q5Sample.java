package pgcon4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q5Sample {
	// メインメモリ64バイト（下位6ビットを使用）
	static byte[] memory = new byte[64];

	// 入力の1行目だけを読み込みメインメモリを初期化して、メインメモリの状態を出力するプログラムです。
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		// 1行目メインメモリ
		String line = in.readLine();
		for (int i = 0; i < line.length(); i++) {
			byte val = base64Decode(line.charAt(i));
			memory[i] = val;
		}
		
		// TODO:2行目以降を読み込み、スクリプトを実行する
		
		// メインメモリの状態を出力する
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < memory.length; i++) {
			sb.append(base64Encode(memory[i]));
		}
		System.out.println(sb.toString());
	}

	// ******************************************************************************

	// BASE64テーブル
	static final String base64_TBL = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
	
	// BASE64エンコード：0-63の範囲外のチェックをしていません。
	static char base64Encode(int v) {
		return base64_TBL.charAt(v);
	}

	// BASE64デコード：不正な文字のチェックをしていませんが、入力データはエラーがないことが保証されます。
	static byte base64Decode(char c) {
		return (byte) base64_TBL.indexOf(c);
	}
	
}
