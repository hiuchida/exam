package codeiq.rank_c;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

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
		boolean result = false;
		loop:
			for (int i=0; i<n-1; i++) {
				for (int j=i+1; j<n; j++) {
					if (nums[i] + nums[j] == 256) {
						result = true;
						break loop;
					}
				}
			}
		System.out.println(result ? "yes" : "no");
	}

}
