package pgcon3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class U02Make {
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("u02"));
		//int n = 30;
		//int n = 100;
		//int m = 1;
		int n = 1000;
		int m = 901;
		int k = (int)(Math.random() * 100000000) + 100000000;
		bw.write(""+(n-m+1)+" "+n+" "+k);
		bw.newLine();
		for (int i=n; i>=m; i--) {
			bw.write(""+i);
			bw.newLine();
		}
		bw.flush();
		bw.close();
	}
}
