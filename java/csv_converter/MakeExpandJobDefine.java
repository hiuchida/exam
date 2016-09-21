package csv_converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MakeExpandJobDefine {

	public static void main(String[] args) throws IOException {
		make10000net();
	}

	static void make10000net() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("auto.csv"));
		for (int i=10001; i<=20000; i++) {
			bw.write("JF,C,JOB" + i + ",STD,0");
			bw.newLine();
		}
		bw.close();
	}

}
