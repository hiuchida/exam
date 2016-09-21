package pgcon1.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q3 {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> tax2 = new ArrayList<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line, " ");
		int x = Integer.parseInt(token.nextToken());
		int y = Integer.parseInt(token.nextToken());
		int s = Integer.parseInt(token.nextToken());

		for (int a = 1; a < s; a++) {

			int at = (a * (100 + x)) / 100;
			int bt = s - at;
			if (bt <= 1) {
				break;
			}

			if ((bt * 100) % (100 + x) == 0) {
				int b = (bt * 100) / (100 + x);
				int aty = (a * (100 + y)) / 100;
				int bty = ((int) b * (100 + y)) / 100;
				int sum = aty + bty;
				tax2.add(sum);

			} else {
				int b = (bt * 100) / (100 + x) + 1;

				int bb = b * (100 + x) / 100;
				int sumx = at + bb;
				if (sumx > s) {
					int sum = 0;
					tax2.add(sum);

				} else {
					int aty = (a * (100 + y)) / 100;
					int bty = ((int) b * (100 + y)) / 100;
					int sum = aty + bty;
					tax2.add(sum);

				}
			}
		}

		Collections.sort(tax2);
		Collections.reverse(tax2);
		System.out.println(tax2.get(0));

	}

}
