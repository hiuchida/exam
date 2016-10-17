package atcoder;

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

public class Main {
	static boolean bElapsed = true;
	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int a = Integer.parseInt(line);
		BigInteger ba = BigInteger.valueOf(a);
		line = br.readLine();
		String[] flds = line.split(" ");
		int b = Integer.parseInt(flds[0]);
		int c = Integer.parseInt(flds[1]);
		line = br.readLine();
		for (int i=0; i<line.length(); i++) {
			char ch = line.charAt(i);
		}
		pln("" + (a+b+c) + " " + line);
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
		new Main().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
