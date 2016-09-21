package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Q3b {
	
	static LinkedList<Character> table;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	int len = line.length();
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
