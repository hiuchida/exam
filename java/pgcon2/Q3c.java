package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q3c {
	
	static LinkedList<Character> table;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	line = preprocess(line);
    	int len = line.length();
    	if (len == 0) {
    		System.out.println("0");
    		return;
    	}
    	long max = 1 << (len-1);
    	int min = Integer.MAX_VALUE;
    	for (long i=0; i<max; i++) {
    		table = new LinkedList<Character>();
    		for (int j=0; j<len; j++) {
    			long mask = 1 << j;
    			if ((i & mask) > 0) {
    				left(line.charAt(j));
    			} else {
    				right(line.charAt(j));
    			}
    		}
    		if (min > table.size()) {
    			min = table.size();
    		}
    	}
    	System.out.println(min);
	}
	
	static String preprocess(String line) {
		for (int i=0; i<line.length(); i++) {
			if (i+1<line.length()) {
				if (line.charAt(i) == line.charAt(i+1)) {
					line = exclude(line, i, i+1);
					i=-1;
					continue;
				}
			}
			if (i+2<line.length()) {
				if (line.charAt(i) == line.charAt(i+2)) {
					line = exclude(line, i, i+2);
					i=-1;
				}
			}
		}
		return line;
	}
	
	static String exclude(String line, int a, int b) {
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<line.length(); i++) {
			if (i != a && i != b) {
				sb.append(line.charAt(i));
			}
		}
		return sb.toString();
	}
	
	static void left(char ch) {
		if (table.size() > 0) {
			if (table.getFirst() == ch) {
				table.removeFirst();
			} else {
				table.addFirst(ch);
			}
		} else {
			table.add(ch);
		}
	}
	
	static void right(char ch) {
		if (table.size() > 0) {
			if (table.getLast() == ch) {
				table.removeLast();
			} else {
				table.addLast(ch);
			}
		} else {
			table.add(ch);
		}
	}
	
}
