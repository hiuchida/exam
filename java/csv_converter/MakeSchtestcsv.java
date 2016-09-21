package csv_converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MakeSchtestcsv {

	public static void main(String[] args) throws IOException {
		//make3000net();
		make50000net();
	}

	static void make50000net() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("schtest.csv"));
		bw.write("SB,C,SCH,,HOL,H,A,0131,0,01,コメント");
		bw.newLine();
		bw.write("SD,C,SCH,26 9805");
		bw.newLine();
		bw.write("SI,C,BSPSTA,SCH,A");
		bw.newLine();
		for (int i=10001; i<=60000; i++) {
			bw.write("SI,C,NT" + i + ",SCH,A");
			bw.newLine();
		}
		bw.write("SI,C,BSPEND,SCH,A");
		bw.newLine();
		bw.close();
	}

	static void make3000net() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("schtest.csv"));
		bw.write("SB,C,SCH,,HOL,H,A,0131,0,01,コメント");
		bw.newLine();
		bw.write("SD,C,SCH,26 9805");
		bw.newLine();
		bw.write("SI,C,BSPSTA,SCH,A");
		bw.newLine();
		for (int i=1001; i<=4003; i++) {
			bw.write("SI,C,NT" + i + ",SCH,A");
			bw.newLine();
		}
		bw.write("SI,C,BSPEND,SCH,A");
		bw.newLine();
		bw.close();
	}

}
