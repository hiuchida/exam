package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q4 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	String[] cols = line.split(" ");
    	int[][] bitmap = new int[24][24];
    	int o = 0;
    	for (int i=0; i<24; i++) {
    		for (int j=0; j<3; j++) {
				int v = Integer.parseInt(cols[o++], 16);
				bitmap[i][j*8] = v & 0x80;
				bitmap[i][j*8+1] = v & 0x40;
				bitmap[i][j*8+2] = v & 0x20;
				bitmap[i][j*8+3] = v & 0x10;
				bitmap[i][j*8+4] = v & 0x08;
				bitmap[i][j*8+5] = v & 0x04;
				bitmap[i][j*8+6] = v & 0x02;
				bitmap[i][j*8+7] = v & 0x01;
    		}
    	}
    	for (int i=0; i<24; i++) {
    		for (int j=0; j<24; j++) {
    			if (bitmap[i][j] > 0) {
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
    			if (bitmap[j][i] > 0) {
    				System.out.print("X");
    			} else {
    				System.out.print(".");
    			}
    		}
    		System.out.println("");
    	}
    }

}
