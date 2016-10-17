package atcoder.abc041;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class C {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Person> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

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

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		String[] flds = line.split(" ");
		for (int i=0; i<n; i++) {
			int a = Integer.parseInt(flds[i]);
			Person p = new Person(i+1, a);
			list.add(p);
		}
		Collections.sort(list, new PersonComp());
		for (Person p : list) {
			pln(p.no);
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
		new C().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
