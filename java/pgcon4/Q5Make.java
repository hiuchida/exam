package pgcon4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q5Make {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new FileWriter("q5.txt"));
		for (int i=0; i<5; i++) {
			write();
		}
		bw.close();
	}
	
	static void write() throws IOException {
		for (int i=0; i<64; i++) {
			bw.write(RandUtil.rand_base64());
		}
		bw.newLine();
	}
	
}
