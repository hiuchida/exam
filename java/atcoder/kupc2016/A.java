package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int a = Integer.parseInt(flds[1]);
		int b = Integer.parseInt(flds[2]);
		int cnt = 0;
		for (int i=0; i<n; i++) {
			line = br.readLine();
			int t = Integer.parseInt(line);
			if (a <= t && t < b) {
				;
			} else {
				cnt++;
			}
		}
		System.out.println(cnt);
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
