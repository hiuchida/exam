package csv_converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class MakeAutoCsv {

	public static void main(String[] args) throws IOException {
		makenet(10, 100);
	}

	static void makenet(int rep, int max) throws IOException {
		DecimalFormat df = new DecimalFormat("0000");
		BufferedWriter bw = new BufferedWriter(new FileWriter("auto.csv"));
		for (int j=0; j<rep; j++) {
			String prev = null;
			for (int i=1; i<=max; i++) {
				bw.write("NN,C,ANET" + df.format(j*max+i) + ",20160705,E,,,A,,06,0000,,,,,0,OFF,0000,OFF,0000,0000,0,0000");
				if (prev != null) bw.write(","+prev+", "); 
				bw.newLine();
				prev = "ANET" + df.format(j*max+i);
			}
		}
		for (int i=1; i<=rep*max; i++) {
			bw.write("NJ,C,ANET" + df.format(i) + ",20160705,010,BSPSTA02,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			bw.newLine();
		}
		for (int i=1; i<=rep*max; i++) {
			bw.write("SI,C,ANET" + df.format(i) + ",SCH,A,0");
			bw.newLine();
		}
		bw.close();
	}

}
