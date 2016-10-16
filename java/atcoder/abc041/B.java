package atcoder.abc041;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class B {
	static boolean bElapsed = false;
	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int a = Integer.parseInt(flds[0]);
		int b = Integer.parseInt(flds[1]);
		int c = Integer.parseInt(flds[2]);
		int m = (int)Math.pow(10, 9)+7;
		BigInteger ba = BigInteger.valueOf(a);
		BigInteger bb = BigInteger.valueOf(b);
		BigInteger bc = BigInteger.valueOf(c);
		BigInteger bm = BigInteger.valueOf(m);
		BigInteger sum = ba.multiply(bb);
		sum = sum.multiply(bc);
		sum = sum.mod(bm);
		pln(sum.intValue());
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
		new B().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
