package atcoder.kupc2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C {
	static boolean bElapsed = false;
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	int max = 0;
	
	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int t = Integer.parseInt(line);
		for (int i=0; i<t; i++) {
			line = br.readLine();
			String[] flds = line.split(" ");
			int n = Integer.parseInt(flds[0]);
			int d = Integer.parseInt(flds[1]);
			calc(n, d);
		}
	}

	void calc(int n, int d) {
		max = 0;
		List<Integer> list = new ArrayList<>();
		list.add(d);
		calc(list, n);
		pln(max);
	}
	
	void calc(List<Integer> list, int n) {
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
	
	void p(char c) {
		System.out.print(c);
	}
	void pln(char c) {
		System.out.println(c);
	}
	void p(long l) {
		System.out.print(l);
	}
	void pln(long l) {
		System.out.println(l);
	}
	void p(String s) {
		System.out.print(s);
	}
	void pln(String s) {
		System.out.println(s);
	}
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new C().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
