package atcoder.disco2016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class C {
	static boolean bElapsed = false;
	List<Integer> list = new ArrayList<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		String[] flds = line.split(" ");
		int n = Integer.parseInt(flds[0]);
		int k = Integer.parseInt(flds[1]);
		line = br.readLine();
		flds = line.split(" ");
		long cnt = 0;
		int nn = n;
		for (int i=0; i<n; i++) {
			int v = Integer.parseInt(flds[i]);
			if (v % k == 0) {
				cnt += nn-1;
				nn--;
			}
			else list.add(v);
		}
		//Collections.sort(list);
		for (int i=0; i<list.size()-1; i++) {
			for (int j=i+1; j<list.size(); j++) {
				long v = (long)list.get(i) * list.get(j);
				if (v % k == 0) cnt++;
			}
		}
		pln(cnt);
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
