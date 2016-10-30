package pgcon2;

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

public class Q5 {
	static boolean bElapsed = true;
	StringBuilder sb = new StringBuilder();
	List<Movie> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String,String> map = new HashMap<>();

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		int interval = Integer.parseInt(line);
		for (int i=0; i<n; i++) {
			line = br.readLine();
			Movie m = new Movie(line);
			list.add(m);
		}
	}

	class Movie {
		String title;
		List<String> start = new ArrayList<>();
		List<String> end = new ArrayList<>();

		public Movie(String line) {
			String[] flds = line.split(" ");
			title = flds[0];
			boolean bStart = true;
			for (int i=1; i<flds.length; i++) {
				if (flds[i].length() == 0) continue;
				String time = flds[i];
				if (time.length() == 4) time = "0" + time;
				if (bStart) start.add(time);
				else end.add(time);
				bStart = !bStart;
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
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q5().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
