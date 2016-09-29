package csv_converter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MakeNetworktestcsv {

	public static void main(String[] args) throws IOException {
		//make3000net();
		make50000net();
	}
	
	static void make50000net() throws IOException {
		DecimalFormat df = new DecimalFormat("00000");
		BufferedWriter bw = new BufferedWriter(new FileWriter("networktest.csv"));
		bw.write("NN,C,BSPSTA,20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		bw.newLine();
		int off = 0;
		List<String> list = new ArrayList<String>();
		for (int j=0; j<1; j++) {
			String prev = "BSPSTA";
			for (int i=0; i<5000; i++) {
				off++;
				bw.write("NN,C,NT" + df.format(off) + ",20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3," + prev + ", ");
				bw.newLine();
				prev = "NT" + df.format(off);
			}
			list.add(prev);
		}
		//bw.write("NN,C,BSPEND,20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		bw.newLine();
		
		bw.write("NJ,C,BSPSTA,20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		bw.newLine();
		for (int i=1; i<=off; i++) {
			bw.write("NJ,C,NT" + df.format(i) + ",20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			bw.newLine();
		}
		//bw.write("NJ,C,BSPEND,20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		bw.newLine();
		bw.close();
	}
	
	static void make3000net() throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("networktest.csv"));
		bw.write("NN,C,BSPSTA,20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		bw.newLine();
		int off = 1000;
		List<String> list = new ArrayList<String>();
		for (int j=0; j<30; j++) {
			String prev = "BSPSTA";
			for (int i=0; i<100; i++) {
				off++;
				bw.write("NN,C,NT" + off + ",20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3," + prev + ", ");
				bw.newLine();
				prev = "NT" + off;
			}
			list.add(prev);
		}
		List<String> list2 = new ArrayList<String>();
		off++;
		bw.write("NN,C,NT" + off + ",20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		list2.add("NT" + off);
		for (int i=0; i<15; i++) {
			bw.write("," + list.get(i) + ", ");
		}
		bw.newLine();
		off++;
		bw.write("NN,C,NT" + off + ",20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		list2.add("NT" + off);
		for (int i=15; i<30; i++) {
			bw.write("," + list.get(i) + ", ");
		}
		bw.newLine();
		off++;
		bw.write("NN,C,BSPEND,20080702,E,,,A,,6,0000,,,,,0,,0000, ,0000,0000,0,3");
		for (int i=0; i<2; i++) {
			bw.write("," + list2.get(i) + ", ");
		}
		bw.newLine();
		
		bw.write("NJ,C,BSPSTA,20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		bw.newLine();
		for (int i=1001; i<=off; i++) {
			bw.write("NJ,C,NT" + i + ",20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
			bw.newLine();
		}
		bw.write("NJ,C,BSPEND,20080702,10,BSPSTA01,,J,1,,,,N,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,,");
		bw.newLine();
		bw.close();
	}

}
