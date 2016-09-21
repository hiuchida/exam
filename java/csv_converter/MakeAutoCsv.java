package csv_converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class MakeAutoCsv {

	public static void main(String[] args) throws IOException {
		make10000net();
	}

	static void make10000net() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("auto.csv"));
		for (int i=1001; i<=2000; i++) {
			bw.write("NN,C,ANET" + i + ",20160705,E,,,A,,06,0001,,,,,0,OFF,0000,OFF,0000,2359,1,0000");
			bw.newLine();
		}
		for (int i=1001; i<=2000; i++) {
			bw.write("NJ,C,ANET" + i + ",20160705,010,BSPSTA01,,D,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			bw.newLine();
		}
		for (int i=1001; i<=2000; i++) {
			bw.write("SI,C,ANET" + i + ",SCHDLY,A,0");
			bw.newLine();
		}
		bw.close();
	}

}
