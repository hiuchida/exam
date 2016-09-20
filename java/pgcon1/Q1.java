package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line1 = br.readLine();
    	String line2 = br.readLine();
    	String line3 = br.readLine();
    	int n = Integer.parseInt(line1);
    	String[] cols2 = line2.split(" ");
    	String[] cols3 = line3.split(" ");
    	List<Integer> list2 = new ArrayList<Integer>();
    	List<Integer> list3 = new ArrayList<Integer>();
    	for (int i=0; i<cols2.length; i++) {
    		int v = Integer.parseInt(cols2[i]);
    		if (i == 0 && v == 0) break;
    		if (v > n) continue;
    		list2.add(v);
    	}
    	for (int i=0; i<cols3.length; i++) {
    		int v = Integer.parseInt(cols3[i]);
    		if (i == 0 && v == 0) break;
    		if (v > n) continue;
    		list3.add(v);
    	}
    	List<Integer> result = new ArrayList<Integer>();
    	for (int i=0; i<list3.size(); i++) {
    		int v = list3.get(i);
    		if (!list2.contains(v)) {
    			result.add(v);
    		}
    	}
    	Collections.sort(result);
    	if (result.size() == 0) {
    		System.out.println("None");
    	} else {
	    	for (int i=0; i<result.size(); i++) {
	    		if (i != 0) {
	    			System.out.print(" ");
	    		}
	    		System.out.print(result.get(i));
	    	}
	    	System.out.println("");
    	}
    }

}
