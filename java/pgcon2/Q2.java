package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {

	static boolean card[][] = new boolean[4][13];
	static boolean check[] = new boolean[4];
	
	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	String[] cols = line.split(" ");
    	for (String s : cols) {
    		int type = getType(s.charAt(0));
    		int num = getNumber(s.charAt(1));
    		card[type][num] = true;
    		check[type] = true;
    	}
    	if (check[0]) {
    		System.out.print("S:");
    		printNum(0);
    	}
    	if (check[1]) {
    		System.out.print("D:");
    		printNum(1);
    	}
    	if (check[2]) {
    		System.out.print("C:");
    		printNum(2);
    	}
    	if (check[3]) {
    		System.out.print("H:");
    		printNum(3);
    	}
	}

	static void printNum(int i) {
		int j;
		boolean bFirst = true;
		String table = "A234567890JQK";
		for (j=0; j<13; j++) {
			if (card[i][j]) {
				if (!bFirst) {
					System.out.print(",");
				}
				System.out.print(table.charAt(j));
				bFirst = false;
			}
		}
		System.out.println("");
	}

	static int getType(char ch) {
		switch (ch)
		{
		case 'S':
			return 0;
		case 'D':
			return 1;
		case 'C':
			return 2;
		case 'H':
			return 3;
		}
		return 0;
	}

	static int getNumber(char ch) {
		switch (ch)
		{
		case 'A':
			return 0;
		case '2':
			return 1;
		case '3':
			return 2;
		case '4':
			return 3;
		case '5':
			return 4;
		case '6':
			return 5;
		case '7':
			return 6;
		case '8':
			return 7;
		case '9':
			return 8;
		case '0':
			return 9;
		case 'J':
			return 10;
		case 'Q':
			return 11;
		case 'K':
			return 12;
		}
		return 0;
	}

}
