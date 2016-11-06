package pgcon2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Combination2 {
	final int _intMax = Integer.MAX_VALUE; // =2147483647>10^9
	final long _longMax = Long.MAX_VALUE; // =9223372036854775807L>10^18
	static boolean bElapsed = true;
	StringBuilder sb = new StringBuilder();
	List<String> list = new ArrayList<>();
	Set<String> set = new HashSet<>();
	Map<String, String> map = new HashMap<>();
	Queue<String> queue = new ArrayDeque<>();
	Deque<String> stack = new ArrayDeque<>();

	void solve() {
		String str = "ABCDEF";
		Node[] nodes = new Node[str.length()+1];
		for (int i=0; i<nodes.length; i++) {
			if (i==0) nodes[i] = new Node("");
			else nodes[i] = new Node(String.valueOf(str.charAt(i-1)));
		}
		for (int i=0; i<nodes.length; i++) {
			for (int j=i+1; j<nodes.length; j++) {
				nodes[i].next.add(nodes[j]);
			}
		}
		search(nodes[0], "");
	}

	void search(Node node, String str) {
		if (node == null)
			return;
		str += node.ch;
		if (str.length() == 3) {
			System.out.println(str);
			return;
		}
		for (Node n : node.next) {
			search(n, str);
		}
	}

	class Node {
		List<Node> next = new ArrayList<>();
		String ch;
		public Node(String ch) {
			this.ch = ch;
		}
	}

	class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public boolean equals(Object o) {
			if (o instanceof Point) {
				Point that = (Point) o;
				return (x == that.x) && (y == that.y);
			}
			return false;
		}

		public int hashCode() {
			return x + (y << 16);
		}

		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}

	class Info implements Comparable<Info> {
		int idx;
		int val;

		public Info(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}

		public int compareTo(Info o) {
			return idx - o.idx;
		}

		public boolean equals(Object o) {
			if (o instanceof Info) {
				Info that = (Info) o;
				return 0 == compareTo(that);
			}
			return false;
		}

		public int hashCode() {
			return idx + (val << 16);
		}

		public String toString() {
			return "(" + idx + ", " + val + ")";
		}
	}

	class InfoComp implements Comparator<Info> {
		public int compare(Info o1, Info o2) {
			return o1.val - o2.val;
		}
	}

	int pint(String s) {
		return Integer.parseInt(s);
	}

	String readLine() {
		try {
			_line = _in.readLine();
			return _line;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	int readNum() {
		readLine();
		return pint(_line);
	}

	String[] readFields() {
		readLine();
		_flds = _line.split(" ");
		return _flds;
	}

	int[] readNums() {
		readFields();
		_nums = new int[_flds.length];
		for (int i = 0; i < _flds.length; i++) {
			_nums[i] = pint(_flds[i]);
		}
		return _nums;
	}

	void p(char c) {
		_out.print(c);
	}

	void pln(char c) {
		_out.println(c);
	}

	void p(double d) {
		_out.print(d);
	}

	void pln(double d) {
		_out.println(d);
	}

	void p(long l) {
		_out.print(l);
	}

	void pln(long l) {
		_out.println(l);
	}

	void p(String s) {
		_out.print(s);
	}

	void pln(String s) {
		_out.println(s);
	}

	String _line;
	String[] _flds;
	int[] _nums;
	static BufferedReader _in;
	static PrintWriter _out;

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new Combination2().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end - start) + "ms");
		}
	}
}
