package pgcon1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q5 {
	static boolean bElapsed = true;
	Map<String,Node> map = new HashMap<>();
	String answerPath = null;
	int answerCost = 0;

	void solve(BufferedReader br) throws Exception {
		for (char ch='A'; ch<='Z'; ch++) {
			map.put(String.valueOf(ch), new Node());
		}
		String line = br.readLine();
		int job = Integer.parseInt(line);
    	for (int i=0; i<job; i++) {
    		line = br.readLine();
    		String[] flds = line.split(" ");
    		String cur = flds[0];
    		int v = Integer.parseInt(flds[1]);
    		int n = Integer.parseInt(flds[2]);
			Node node = map.get(cur);
			node.cost = v;
    		if (cur.equals("A")) {
    			continue;
    		}
    		for (int j=0; j<n; j++) {
    			String prev = flds[3+j];
    			Node prevNode = map.get(prev);
    			prevNode.next.add(cur);
    		}
    	}
    	search("", 0, "A");
    	pln(answerPath);
	}
	
	void search(String path, int cost, String id) {
		if (path.indexOf(id) >= 0) return;
		Node node = map.get(id);
		path += id;
		cost += node.cost;
		check(path, cost);
		for (String s : node.next) {
			search(path, cost, s);
		}
	}
	
	void check(String path, int cost) {
		if (cost > answerCost) {
			answerCost = cost;
			answerPath = path;
		} else if (cost == answerCost) {
			if (path.compareTo(answerPath) < 0) {
				answerPath = path;
			}
		}
	}

	class Node {
		List<String> next = new ArrayList<>();
		int cost;
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
