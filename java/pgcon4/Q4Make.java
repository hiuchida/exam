package pgcon4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q4Make {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new FileWriter("q4.txt"));
		for (int i=0; i<5; i++) {
			write(30);
		}
		for (int i=0; i<5; i++) {
			write(18);
		}
		for (int i=0; i<5; i++) {
			write(8);
		}
		bw.close();
	}
	
	static void write(int cnt) throws IOException {
		bw.write(RandUtil.rand1_9());
		cnt--;
		for (int i=0; i<cnt; i++) {
			bw.write(RandUtil.rand0_9());
		}
		bw.newLine();
	}
	
}
