package atcoder.cf2016b;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {
	
	static String collectStr = "CODEFESTIVAL2016";

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int cnt = 0;
		for (int i=0; i<line.length(); i++) {
			if (collectStr.charAt(i) != line.charAt(i)) {
				cnt++;
			}
		}
		System.out.println(cnt);
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
