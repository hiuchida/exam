package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {

	static int max = 0;
	
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int t = Integer.parseInt(line);
		for (int i=0; i<t; i++) {
			line = br.readLine();
			String[] flds = line.split(" ");
			int n = Integer.parseInt(flds[0]);
			int d = Integer.parseInt(flds[1]);
			calc(n, d);
		}
		long end = System.currentTimeMillis();
		System.out.println((end-start) + "ms");
	}

	static void calc(int n, int d) {
		max = 0;
		List<Integer> list = new ArrayList<>();
		list.add(d);
		calc(list, n);
		System.out.println(max);
	}
	
	static void calc(List<Integer> list, int n) {
		if (list.size() == n) {
			int sum = 0;
			for (Integer i : list) {
				sum += i;
			}
			if (max < sum) {
				max = sum;
			}
			return;
		}
		for (int i=0; i<list.size(); i++) {
			List<Integer> list2 = new ArrayList<>(list);
			int x = list2.remove(i);
			for (int y=0; y<=127; y++) {
				List<Integer> newList = new ArrayList<>(list2);
				newList.add(y);
				newList.add(x ^ y);
				calc(newList, n);
			}
		}
	}
	
}
