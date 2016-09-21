package csv_repair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import csv_parser.CSVParser;

public class Repair {

	public static void main(String[] args) throws IOException {
		String csvpath = "C:\\BSP\\A-AUTO_APServer\\temp\\TW_NETINFO1.CSV"; //args[0];
		String bakpath = csvpath.substring(0, csvpath.lastIndexOf(".")) + ".BAK";
		/*
		File csvfile = new File(csvpath);
		File bakfile = new File(bakpath);
		bakfile.delete();
		csvfile.renameTo(bakfile);
		*/
		BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(csvpath), "UTF-8"));
		//BufferedWriter w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvpath), "UTF-8"));
		int lineNo = 1;
		String line = r.readLine();
		//w.write(line);
		//w.newLine();
		lineNo++;
		int maxCol = 0;
		while (true) {
			CSVParser csvp = new CSVParser();
			line = r.readLine();
			if (line == null) break;
			while (csvp.splitCsv(line, lineNo)) {
				line = r.readLine();
				if (line == null) break;
				lineNo++;
			}
			List<String> cols = csvp.getFields();
			for (int i=0; i<cols.size(); i++) {
				String v = cols.get(i);
				if (v.equals("\"\n\"")) {
					cols.set(i, "\" \"");
					System.out.println(lineNo + "[" + (i+1) + "]: " + v);
				}
			}
			if (maxCol < cols.size()) {
				maxCol = cols.size();
			}
			lineNo++;
		}
		r.close();
		System.out.println(maxCol);
	}

}
