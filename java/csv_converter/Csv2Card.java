package csv_converter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import csv_parser.CSVParser;

public class Csv2Card {

	static BufferedWriter w1 = null;
	static BufferedWriter w2 = null;
	
	public static void main(String[] args) throws IOException {
		String csvpath = "auto.csv";
		String cardpath1 = "aux_netwkcard";
		String cardpath2 = "aux_schecard";
		BufferedReader r = null;
		r = new BufferedReader(new InputStreamReader(new FileInputStream(csvpath), "MS932"));
		w1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cardpath1), "MS932"));
		w2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cardpath2), "MS932"));
		w2.write("SCSCHE01              0            AUTOHOLT                                     ");
		w2.newLine();
		w2.write("SCSCHE01              1 HA0131001                                               ");
		w2.newLine();
		w2.write("SCSCHE01              2 01 1604                                                 ");
		w2.newLine();
		w2.write("SCSCHE01              9 デモID                                            ");
		w2.newLine();
		int lineNo = 1;
		String prevId = null;
		String prevDate = null;
		List<String> preid = null;
		while (true) {
			CSVParser csvp = new CSVParser();
			String line = r.readLine();
			if (line == null) break;
			while (csvp.splitCsv(line, lineNo)) {
				line = r.readLine();
				if (line == null) break;
				lineNo++;
			}
			List<String> cols = csvp.getFields();
			String type = cols.get(0);
			if ("NN".equals(type)) {
				String id = cols.get(2);
				String date = cols.get(3);
				if (prevId != null && !prevId.equals(id)) {
					write1(prevId, preid);
					write2(prevId);
				}
				prevId = id;
				prevDate = date;
				preid = new ArrayList<String>();
				for (int i=0; i<16; i++) {
					if (cols.size() > 23+i*2) {
						String s = cols.get(23+i*2);
						if (s.length() > 0) {
							preid.add(s);
						}
					}
				}
				System.out.println(id + "," + date + "," + preid);
			} else {
				if (prevId != null) {
					write1(prevId, preid);
					write2(prevId);
					prevId = null;
				}
			}
		}
		w2.close();
		w1.close();
		r.close();
	}
	
	static void write1(String id, List<String> preid) throws IOException {
		id = formatId(id);
		w1.write("NC" + id + "  0   A  060000                                                      ");
		w1.newLine();
		while (preid.size() > 0) {
			w1.write("NC" + id + "  1 ");
			for (int i=0; i<4 && preid.size() > 0; i++) {
				String pid = preid.remove(0);
				pid = formatId(pid);
				w1.write(pid + "  ");
			}
			w1.newLine();
		}
		w1.write("NC" + id + "  2 日次スタート処理");
		w1.newLine();
		w1.write("NC" + id + "  4010BSPSTA01 000000000000000000           0000                     ");
		w1.newLine();
	}
	
	static void write2(String id) throws IOException {
		id = formatId(id);
		w2.write("SC" + id + "            U ASCHE01                                  ");
		w2.newLine();
	}
	
	static String formatId(String id) {
		id = id + "        ";
		return id.substring(0, 8);
	}

}
