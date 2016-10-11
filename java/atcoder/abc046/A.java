package atcoder.abc046;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class A {

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] flds = line.split(" ");
		int a = Integer.parseInt(flds[0]);
		int b = Integer.parseInt(flds[1]);
		int c = Integer.parseInt(flds[2]);
		Set<Integer> set = new HashSet<Integer>();
		set.add(a);
		set.add(b);
		set.add(c);
		System.out.println(set.size());
		long end = System.currentTimeMillis();
		//System.out.println((end-start) + "ms");
	}

}
