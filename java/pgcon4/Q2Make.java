package pgcon4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q2Make {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new FileWriter("q2.txt"));
		for (int i=0; i<20; i++) {
			write();
		}
		bw.close();
	}
	
	static void write() throws IOException {
		for (int i=0; i<100; i++) {
			bw.write(RandUtil.rand_AZ());
		}
		bw.newLine();
	}
	
}
