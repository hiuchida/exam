package codeiq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
問題文「第120回 今週のお題：ソートされないカード」
1～n までの整数が1つずつ書かれている n 枚のカードを横一列に並べます。
カードを左から順に一枚ずつ見て、書かれている数字が i なら、左から i 番目のカードと交換する、という作業を右端のカードまで繰り返します。
例えば、3, 2, 5, 4, 1の順に並んでいると、最初のカードは 3 なので3番目のカードである 5 と交換し、5, 2, 3, 4, 1となります。
次のカードは 2 なので2番目のカードと交換（交換は発生しない）、その次のカードは 3 なので3番目のカードと交換（交換は発生しない）、その次のカードは 4 なので4番目のカードと交換（交換は発生しない）、その次のカードは 1 なので1番目のカードである 5 と交換し、1, 2, 3, 4, 5となり、昇順に並べ替えられます。
※カードは常に左から順番に見ていきます
右端まで処理した結果、書かれている数字が昇順に並ばない初期配置が何通りあるかを求めます。
標準入力から n が与えられるとき、書かれている数字が昇順に並ばない初期配置が何通りあるかを求め、標準出力に出力してください。
例えば、n = 4 のとき、24通り中、以下の3通りがありますので、サンプルのように出力します。
2, 3, 4, 1
3, 4, 2, 1
4, 3, 1, 2
（n は最大で8とします。余裕がある人は、もう少し大きな n についても考えてみてください）
 */
public class NoSortedCard {
	static boolean bElapsed = false;
	int n;
	int cnt;

	void solve(BufferedReader br) throws Exception {
		n = pint(br.readLine());
		List<Integer> tmpList = new ArrayList<>();
		search(tmpList);
		pln(cnt);
	}
	void search(List<Integer> tmpList) {
		if (n == tmpList.size()) {
			if (check(tmpList)) {
				//pln(tmpList.toString());
				cnt++;
			}
			return;
		}
		for (int i=1; i<=n; i++) {
			if (tmpList.contains(i)) continue;
			tmpList.add(i);
			search(tmpList);
			tmpList.remove(tmpList.size()-1);
		}
	}
	boolean check(List<Integer> tmpList) {
		List<Integer> list = new ArrayList<>(tmpList);
		for (int i=0; i<n; i++) {
			int v = list.get(i);
			int x = list.get(v-1);
			list.set(i, x);
			list.set(v-1, v);
		}
		for (int i=0; i<n; i++) {
			int v = list.get(i);
			if (v != i+1) return true;
		}
		return false;
	}
	
	int pint(String s) {
		return Integer.parseInt(s);
	}
	void p(char c) {
		System.out.print(c);
	}
	void pln(char c) {
		System.out.println(c);
	}
	void p(long l) {
		System.out.print(l);
	}
	void pln(long l) {
		System.out.println(l);
	}
	void p(String s) {
		System.out.print(s);
	}
	void pln(String s) {
		System.out.println(s);
	}
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new NoSortedCard().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
