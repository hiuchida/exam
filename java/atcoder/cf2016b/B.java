package atcoder.cf2016b;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int a = Integer.parseInt(flds[1]);
		int b = Integer.parseInt(flds[2]);
		line = br.readLine();
		int aa = 0;
		int bb = 0;
		for (int i=0; i<n; i++) {
			char ch = line.charAt(i);
			switch (ch) {
			case 'a':
				if (aa + bb < a + b) {
					System.out.println("Yes");
					aa++;
				} else {
					System.out.println("No");
				}
				break;
			case 'b':
				if (aa + bb < a + b && bb < b) {
					System.out.println("Yes");
					bb++;
				} else {
					System.out.println("No");
				}
				break;
			case 'c':
				System.out.println("No");
				break;
			}
		}
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
