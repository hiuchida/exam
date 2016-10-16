package atcoder.abc046;

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

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		long tt = 0;
		long aa = 0;
		for (int i=0; i<n; i++) {
			line = br.readLine();
			String[] flds = line.split(" ");
			int t = Integer.parseInt(flds[0]);
			int a = Integer.parseInt(flds[1]);
			if (i == 0) {
				tt = t;
				aa = a;
				continue;
			}
			long tn = tt/t;
			long an = aa/a;
			long nn = Math.max(tn, an);
			while (true) {
				long nt = t*nn;
				long na = a*nn;
				if (nt >= tt && na >= aa) {
					tt = nt;
					aa = na;
					break;
				}
				nn++;
			}
			//pln("tt="+tt+",aa="+aa);
		}
		pln(tt+aa);
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
