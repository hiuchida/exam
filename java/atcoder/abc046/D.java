package atcoder.abc046;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int gcnt = 0;
		int pcnt = 0;
		int point = 0;
		for (char you : line.toCharArray()) {
			char me;
			if (gcnt == pcnt) {
				me = 'g';
				gcnt++;
			} else {
				me = 'p';
				pcnt++;
			}
			if (you == 'g') {
				if (me == 'p') {
					point++;
				}
			} else {
				if (me == 'g') {
					point--;
				}
			}
		}
		System.out.println(point);
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
