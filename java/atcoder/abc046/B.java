package atcoder.abc046;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int k = Integer.parseInt(flds[1]);
		long sum = k;
		for (int i=1; i<n; i++) {
			sum *= (k - 1);
		}
		System.out.println(sum);
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
