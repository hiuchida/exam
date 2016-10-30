package atcoder.agc006;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class D {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Integer> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		String[] flds = line.split(" ");
		for (int i=0; i<flds.length; i++) {
			int v = Integer.parseInt(flds[i]);
			list.add(v);
		}
		for (int c=n-1; c>0; c--) {
			List<Integer> list2 = new ArrayList<>();
			for (int i=0; i<list.size()-2; i++) {
				int v1 = list.get(i);
				int v2 = list.get(i+1);
				int v3 = list.get(i+2);
				if (v1 > v2) {
					int tmp = v1;
					v1 = v2;
					v2 = tmp;
				}
				if (v1 > v3) {
					int tmp = v1;
					v1 = v3;
					v3 = tmp;
				}
				if (v2 > v3) {
					int tmp = v2;
					v2 = v3;
					v3 = tmp;
				}
				list2.add(v2);
			}
			list = list2;
		}
		pln(list.get(0));
	}

	class Person {
		int no;
		int a;
		public Person(int no, int a) {
			this.no = no;
			this.a = a;
		}
	}
	class PersonComp implements Comparator<Person> {
		public int compare(Person o1, Person o2) {
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
		new D().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
