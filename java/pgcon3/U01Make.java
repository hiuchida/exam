package pgcon3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class U01Make {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("u01"));
		int n = 2000 * 1000;
		bw.write(""+n);
		bw.newLine();
		for (int i=0; i<n; i++) {
			int v = (int)(Math.random() * 0x40000000) + 1;
			bw.write(""+v);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
