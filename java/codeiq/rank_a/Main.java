package codeiq.rank_a;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static final int[] money = { 500, 100, 50, 10, 5, 1 };

	public static class Money {
		int[] cnt = new int[6];
		int remain;

		public Money(int n) {
			this.remain = n;
		}

		public Money(Money m) {
			for (int i = 0; i < cnt.length; i++) {
				this.cnt[i] = m.cnt[i];
			}
			this.remain = m.remain;
		}
	}

	private static List<Money> pattern = new ArrayList<Money>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);
		Money m = new Money(n);
		pattern.add(m);
		for (int i = 0; i < money.length; i++) {
			expand(i);
		}
		System.out.println(pattern.size());
	}

	private static void expand(int idx) {
		List<Money> newPattern = new ArrayList<Money>();
		for (Money m : pattern) {
			if (money[idx] == 1) {
				m.cnt[idx] = m.remain;
				m.remain = 0;
				newPattern.add(m);
			} else {
				int max = m.remain / money[idx];
				for (int i = 0; i <= max; i++) {
					Money newMoney = new Money(m);
					newMoney.cnt[idx] = i;
					newMoney.remain -= money[idx] * i;
					newPattern.add(newMoney);
				}
			}
		}
		pattern = newPattern;
	}

}
