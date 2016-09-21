package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4 {
	
	static char[][] vram = new char[25][80];
	static int curRow = 1;
	static int curCol = 1;

	public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	int n = Integer.parseInt(line);
    	for (int i=0; i<n; i++) {
    		line = br.readLine();
    		for (int j=0; j<line.length(); j++) {
    			if (line.charAt(j) == 0x1b && line.charAt(j+1) == '[') {
    				j = escape(line, j+2);
    			} else {
    				type(line.charAt(j));
    			}
    		}
    	}
    	print();
	}
	
	static int escape(String line, int j) {
		StringBuffer sb1 = new StringBuffer();
		StringBuffer sb2 = new StringBuffer();
		boolean bOne = true;
		int k;
		for (k=j; k<line.length(); k++) {
			if ('0' <= line.charAt(k) && line.charAt(k) <= '9') {
				if (bOne) {
					sb1.append(line.charAt(k));
				} else {
					sb2.append(line.charAt(k));
				}
			} else if (';' == line.charAt(k)) {
				bOne = false;
			} else if ('J' == line.charAt(k)) {
				clear();
				break;
			} else if ('H' == line.charAt(k)) {
				int row = Integer.parseInt(sb1.toString());
				int col = Integer.parseInt(sb2.toString());
				move(row, col);
				break;
			} else if ('B' == line.charAt(k)) {
				int num = Integer.parseInt(sb1.toString());
				moveDown(num);
				break;
			} else if ('D' == line.charAt(k)) {
				int num = Integer.parseInt(sb1.toString());
				moveLeft(num);
				break;
			} else if ('C' == line.charAt(k)) {
				int num = Integer.parseInt(sb1.toString());
				moveRight(num);
				break;
			} else if ('A' == line.charAt(k)) {
				int num = Integer.parseInt(sb1.toString());
				moveUp(num);
				break;
			}
		}
		return k;
	}
	
	static void print() {
		for (int y=0; y<25; y++) {
			for (int x=0; x<80; x++) {
				System.out.print(vram[y][x]);
			}
			System.out.println("");
		}
	}
	
	static void clear() {
		for (int y=0; y<25; y++) {
			for (int x=0; x<80; x++) {
				vram[y][x] = ' ';
			}
		}
		curRow = 1;
		curCol = 1;
	}
	
	static void move(int row, int col) {
		curRow = row;
		curCol = col;
	}
	
	static void moveDown(int num) {
		curRow += num;
	}
	
	static void moveLeft(int num) {
		curCol -= num;
	}
	
	static void moveRight(int num) {
		curCol += num;
	}
	
	static void moveUp(int num) {
		curRow -= num;
	}
	
	static void type(char ch) {
		vram[curRow-1][curCol-1] = ch;
		curCol++;
		if (curCol >= 81) {
			curCol = 1;
			if (curRow >= 25) {
				scroll();
			} else {
				curRow++;
			}
		}
	}
	
	static void scroll() {
		for (int y=1; y<25; y++) {
			for (int x=0; x<80; x++) {
				vram[y-1][x] = vram[y][x];
			}
		}
		for (int x=0; x<80; x++) {
			vram[24][x] = ' ';
		}
	}

}
