package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	static StringBuffer table;
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	int len = line.length();
    	long max = 1 << (len-1);
    	int min = Integer.MAX_VALUE;
    	for (long i=0; i<max; i++) {
    		table = new StringBuffer();
    		for (int j=0; j<len; j++) {
    			long mask = 1 << j;
    			if ((i & mask) > 0) {
    				left(line.charAt(j));
    			} else {
    				right(line.charAt(j));
    			}
    		}
    		if (min > table.length()) {
    			min = table.length();
    		}
    	}
    	System.out.println(min);
	}
	
	static void left(char ch) {
		if (table.length() > 0) {
			if (table.charAt(0) == ch) {
				String s = table.substring(1);
				table = new StringBuffer();
				table.append(s);
			} else {
				table.insert(0, ch);
			}
		} else {
			table.append(ch);
		}
	}
	
	static void right(char ch) {
		if (table.length() > 0) {
			if (table.charAt(table.length()-1) == ch) {
				String s = table.substring(0, table.length()-1);
				table = new StringBuffer();
				table.append(s);
			} else {
				table.append(ch);
			}
		} else {
			table.append(ch);
		}
	}
	
}
