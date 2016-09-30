package codeiq.rank_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int m = Integer.parseInt(flds[1]);
		int cnt = 0;
		for (int i = 0; i <= n; i++) {
			int bitCnt = 0;
			for (int j = 0; j < 17; j++) {
				int val = i;
				val >>= j;
				if ((val & 1) == 1) {
					bitCnt++;
				}
			}
			if (bitCnt == m) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
