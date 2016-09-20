package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int[][] table = new int[3][3];
    	for (int i=0; i<3; i++) {
        	String line = br.readLine();
    		for (int j=0; j<3; j++) {
    			if (line.charAt(j) == 'o') {
    				table[i][j] = 1;
    			} else if (line.charAt(j) == 'x') {
    				table[i][j] = -1;
    			} else if (line.charAt(j) == '-') {
    				table[i][j] = 0;
    			} else {
    				throw new RuntimeException("Illegal Input Data");
    			}
    		}
    	}
    	int blank = 0;
    	for (int i=0; i<3; i++) {
    		for (int j=0; j<3; j++) {
    			if (table[i][j] == 0) {
    				blank++;
    			}
    		}
    	}
    	int s1 = table[0][0] + table[0][1] + table[0][2];
    	int s2 = table[1][0] + table[1][1] + table[1][2];
    	int s3 = table[2][0] + table[2][1] + table[2][2];
    	int s4 = table[0][0] + table[1][0] + table[2][0];
    	int s5 = table[0][1] + table[1][1] + table[2][1];
    	int s6 = table[0][2] + table[1][2] + table[2][2];
    	int s7 = table[0][0] + table[1][1] + table[2][2];
    	int s8 = table[2][0] + table[1][1] + table[0][2];
    	if (s1 == 3 || s2 == 3 || s3 == 3 || s4 == 3 || s5 == 3 || s6 == 3 || s7 == 3 || s8 == 3) {
    		System.out.println("WIN");
    	} else if (s1 == -3 || s2 == -3 || s3 == -3 || s4 == -3 || s5 == -3 || s6 == -3 || s7 == -3 || s8 == -3) {
    		System.out.println("LOSE");
    	} else if (blank == 0) {
    		System.out.println("FIN");
    	} else if (blank % 2 == 0) {
    		System.out.println("NG");
    	} else if (s1 == 2 || s2 == 2 || s3 == 2 || s4 == 2 || s5 == 2 || s6 == 2 || s7 == 2 || s8 == 2) {
    		System.out.println("OK");
    	} else {
    		System.out.println("NO");
    	}
    	
    }

}
