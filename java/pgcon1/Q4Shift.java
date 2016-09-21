package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4Shift {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	String[] cols = line.split(" ");
    	boolean[][] bitmap = new boolean[24][24];
    	int o = 0;
    	for (int i=0; i<24; i++) {
    		for (int j=0; j<3; j++) {
				int v = Integer.parseInt(cols[o++], 16);
				for (int k=0; k<8; k++) {
					int bit = (v >> (7-k)) & 1;
					if (bit == 1) {
						bitmap[i][j*8+k] = true;
					}
				}
    		}
    	}
    	for (int i=0; i<24; i++) {
    		for (int j=0; j<24; j++) {
    			if (bitmap[i][j]) {
    				System.out.print("X");
    			} else {
    				System.out.print(".");
    			}
    		}
    		System.out.println("");
    	}
    	System.out.println("");
    	for (int i=0; i<24; i++) {
    		for (int j=23; j>=0; j--) {
    			if (bitmap[j][i]) {
    				System.out.print("X");
    			} else {
    				System.out.print(".");
    			}
    		}
    		System.out.println("");
    	}
    }

}
