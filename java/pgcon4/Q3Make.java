package pgcon4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Q3Make {
	static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new FileWriter("q3.txt"));
		for (int i=0; i<5; i++) {
			write(5);
		}
		for (int i=0; i<5; i++) {
			write(4);
		}
		for (int i=0; i<5; i++) {
			write(3);
		}
		for (int i=0; i<5; i++) {
			write(2);
		}
		bw.close();
	}
	
	static void write(int cnt) throws IOException {
		//int max = cnt*cnt*cnt + RandUtil.rand(cnt*cnt*cnt);
		int max = calc(cnt);
		bw.write(cnt + " " + max);
		bw.newLine();
		for (int i=0; i<cnt; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j=0; j<cnt; j++) {
				int v = 1 + RandUtil.rand(100);
				if (j > 0)
					sb.append(" ");
				sb.append(v);
			}
			bw.write(sb.toString());
			bw.newLine();
		}
	}
	
	static int calc(int cnt) {
		int sum = 0;
		for (int i=1; i<=cnt; i++) {
			for (int j=1; j<=cnt; j++) {
				sum += i*j;
			}
		}
		return sum;
	}
	
}
