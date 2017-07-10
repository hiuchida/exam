package pgcon4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q1Make {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new FileWriter("q1.txt"));
		for (int i=0; i<5; i++) {
			write();
		}
		bw.close();
	}
	
	static void write() throws IOException {
		for (int i=0; i<100; i++) {
			String str = RandUtil.rand_base64();
			str = str.replaceAll("\\+", " ");
			str = str.replaceAll("/", " ");
			bw.write(str);
		}
		bw.newLine();
	}
	
}
