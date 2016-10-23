package atcoder.cf2016c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class B {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Cake> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int k = Integer.parseInt(flds[0]);
		int t = Integer.parseInt(flds[1]);
		line = br.readLine();
		flds = line.split(" ");
		for (int i=0; i<t; i++) {
			int a = Integer.parseInt(flds[i]);
			list.add(new Cake(i, a));
		}
		int sum = 0;
		int prev = -1;
		while (list.size() > 0) {
			Collections.sort(list, new CakeComp());
			if (list.size() > 1) {
				Cake a = list.get(0);
				Cake b = list.get(1);
				prev = b.no;
				b.a--;
				if (b.a == 0) list.remove(1);
				a.a--;
				if (a.a == 0) list.remove(0);
			}
			if (list.size() == 1) {
				Cake a = list.get(0);
				if (prev < 0 || prev != a.no) {
					a.a--;
					prev = a.no;
				}
				sum += a.a;
				list.remove(0);
			}
		}
		pln(sum);
	}

	class Cake {
		int no;
		int a;
		public Cake(int no, int a) {
			this.no = no;
			this.a = a;
		}
	}
	class CakeComp implements Comparator<Cake> {
		public int compare(Cake o1, Cake o2) {
			return o2.a - o1.a;
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
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new B().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
