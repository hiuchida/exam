package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	for (int i=line.length()-1; i>=0; i--) {
    		System.out.print(line.charAt(i));
    	}
    	System.out.println("");
	}

}
