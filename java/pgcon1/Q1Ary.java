package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1Ary {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line1 = br.readLine();
    	String line2 = br.readLine();
    	String line3 = br.readLine();
    	int n = Integer.parseInt(line1);
    	String[] cols2 = line2.split(" ");
    	boolean[] ary2 = new boolean[n+1];
    	for (int i=0; i<cols2.length; i++) {
    		int v = Integer.parseInt(cols2[i]);
    		if (i == 0 && v == 0) break;
    		if (v > n) continue;
    		ary2[v] = true;
    	}
    	String[] cols3 = line3.split(" ");
    	boolean[] ary3 = new boolean[n+1];
    	for (int i=0; i<cols3.length; i++) {
    		int v = Integer.parseInt(cols3[i]);
    		if (i == 0 && v == 0) break;
    		if (v > n) continue;
    		ary3[v] = true;
    	}
    	boolean[] result = new boolean[n+1];
    	int cnt = 0;
    	for (int i=0; i<=n; i++) {
    		if (ary3[i]) {
	    		if (!ary2[i]) {
	    			result[i] = true;
	    			cnt++;
	    		}
    		}
    	}
    	if (cnt == 0) {
    		System.out.println("None");
    	} else {
    		boolean bFirst = true;
	    	for (int i=0; i<=n; i++) {
	    		if (result[i]) {
		    		if (!bFirst) {
		    			System.out.print(" ");
		    		}
		    		System.out.print(i);
		    		bFirst = false;
	    		}
	    	}
	    	System.out.println("");
    	}
	}

}
