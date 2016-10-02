package atcoder.agc005;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		String[] flds = line.split(" ");
		int[] nums = new int[n];
		for (int i=0; i<n; i++) {
			nums[i] = Integer.parseInt(flds[i]);
		}
		long sum = 0;
		for (int l=0; l<n; l++) {
			int min = nums[l];
			for (int r=l; r<n; r++) {
				if (nums[r] < min) {
					min = nums[r];
				}
				sum += min;
			}
		}
		System.out.println(sum);
	}

}
