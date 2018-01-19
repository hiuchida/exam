package revo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Revo {
	static boolean bElapsed = true;
	static int min = 30000;
	static int max = 30000;

	static List<Integer> mstList = new ArrayList<>();
	static List<Integer> tmpList = new ArrayList<>();
	static Map<Integer, String> map = new HashMap<>();

	static void solve(BufferedReader in) throws IOException {
		while (true) {
			String line = in.readLine();
			if (line == null)
				break;
			String[] cols = line.split("\t");
			String val = cols[1].replaceAll(",", "");
			int v = Integer.parseInt(val);
			mstList.add(v);
			map.put(v, cols[0]);
		}
		Collections.sort(mstList);
		dfs(0, 0);
	}

	static int dfs(int i, int v) {
		if (i >= mstList.size())
			return v;
		if (min <= v && v <= max) {
			print();
			System.exit(0);
		}
		int p = mstList.get(i);
		int v1 = dfs(i + 1, v);
		tmpList.add(p);
		int v2 = dfs(i + 1, v + p);
		tmpList.remove(tmpList.size() - 1);
		return Math.max(v1, v2);
	}
	
	static void print() {
		int sum = 0;
		for (int v : tmpList) {
			System.out.println(map.get(v) + " " + v);
			sum += v;
		}
		System.out.println("合計:" + sum);
	}

	public static void main(String[] args) throws IOException {
		long start = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		solve(in);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end - start) + "ms");
		}
	}
}
