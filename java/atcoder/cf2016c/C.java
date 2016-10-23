package atcoder.cf2016c;

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

public class C {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<Integer> t = new ArrayList<>();
	List<Integer> a = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		String[] flds = line.split(" ");
		int prev = 0;
		for (int i=0; i<n; i++) {
			int v = Integer.parseInt(flds[i]);
			if (v < prev) {
				pln("0");
				return;
			}
			prev = v;
			t.add(v);
		}
		line = br.readLine();
		flds = line.split(" ");
		for (int i=0; i<n; i++) {
			int v = Integer.parseInt(flds[i]);
			a.add(v);
		}
		prev = 0;
		for (int i=n-1; i>=0; i--) {
			int v = a.get(i);
			if (v < prev) {
				pln("0");
				return;
			}
			prev = v;
		}
		int vv = t.get(n-1);
		if (vv != a.get(0)) {
			pln("0");
			return;
		}
		int[] high = new int[n];
		int max = 0;
		for (int i=0; i<n; i++) {
			int v = t.get(i);
			if (max < v) {
				high[i] = v;
				max = v;
			}
		}
		max = 0;
		for (int i=n-1; i>=0; i--) {
			int v = a.get(i);
			if (max < v) {
				high[i] = v;
				max = v;
			}
		}
		long sum = 1;
		long mod = (long)Math.pow(10, 9)+7;
		for (int i=0; i<n; i++) {
			if (high[i] > 0) continue;
			int v1 = t.get(i);
			int v2 = a.get(i);
			int v = Math.min(v1, v2);
			sum *= v;
			sum %= mod;
		}
		pln(sum);
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
		new C().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
