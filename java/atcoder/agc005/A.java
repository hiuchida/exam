package atcoder.agc005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int cnt = 0;
		int scnt = 0;
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == 'S') {
				scnt++;
			} else if (ch == 'T') {
				if (scnt > 0) {
					scnt--;
				} else {
					cnt++;
				}
			}
		}
		cnt += scnt;
		System.out.println(cnt);
	}

}
