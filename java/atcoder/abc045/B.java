package atcoder.abc045;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

	static String[] cards = new String[3];
	static int[] idxes = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i=0; i<3; i++) {
			String line = br.readLine();
			cards[i] = line;
		}
		int cur = 0;
		while (true) {
			if (idxes[cur] >= cards[cur].length()) {
				break;
			}
			char next = cards[cur].charAt(idxes[cur]);
			idxes[cur]++;
			cur = next - 'a';
		}
		String player = "ABC";
		System.out.println(player.charAt(cur));
	}

}
