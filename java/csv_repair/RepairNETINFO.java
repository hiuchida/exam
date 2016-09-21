package csv_repair;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Date;
import java.util.List;

import csv_parser.CSVParser;

public class RepairNETINFO {

	public static void main(String[] args) {
		System.out.println("RepairNETINFO started at " + new Date());
		int rc = execute(args);
		System.out.println("RepairNETINFO ended at " + new Date() + " returnCode=" + rc);
		System.exit(rc);
	}
	
	static int execute(String[] args) {
		/*
		if (args.length < 1) {
			System.err.println("usage: java RepairNETINFO FilePath");
			return 1;
		}
		String csvpath = args[0];
		*/
		String csvpath = "C:/BSP/A-AUTO_APServer/temp/TW_NETINFO1.CSV";
		String bakpath = csvpath.substring(0, csvpath.lastIndexOf(".")) + ".BAK";
		File csvfile = new File(csvpath);
		File bakfile = new File(bakpath);
		if (bakfile.exists()) {
			if (!bakfile.delete()) {
				System.out.println("バックアップファイル(" + bakpath + ")の削除に失敗しました。");
				return 2;
			}
		}
		if (!csvfile.renameTo(bakfile)) {
			System.out.println("CSVファイル(" + csvpath + ")をバックアップファイル(" + bakpath + ")へのリネームに失敗しました。");
			return 3;
		}
		System.out.println("CSVファイル(" + csvpath + ")をバックアップファイル(" + bakpath + ")へリネームしました。");
		BufferedReader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(bakpath), "UTF-8"));
		} catch (Exception e) {
			System.out.println("バックアップファイル(" + bakpath + ")のオープンに失敗しました。");
			e.printStackTrace();
			return 4;
		}
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvpath), "UTF-8"));
		} catch (Exception e) {
			System.out.println("CSVファイル(" + csvpath + ")のオープンに失敗しました。");
			e.printStackTrace();
			try {
				r.close();
			} catch (Exception e1) {}
			return 5;
		}
		try {
			int lineNo = 1;
			String line = r.readLine();
			if (line != null) { //20160502 add
				w.write(line);
				w.newLine();
			} //20160502 add
			lineNo++;
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
						System.out.println("line " + lineNo + "[" + (i+1) + "]: " + v + " -> " + cols.get(i));
					}
				}
				if (cols.size() > 4) { //20160502 add
					String v4 = cols.get(4);
					if (!v4.equals("\"        \"")) {
						cols.set(4, "\"        \"");
						System.out.println("line " + lineNo + "[5]: " + v4 + " -> " + cols.get(4));
					}
				} //20160502 add
				if (cols.size() > 7) { //20160502 add
					String v7 = cols.get(7);
					if (!v7.equals("\" \"")) {
						cols.set(7, "\" \"");
						System.out.println("line " + lineNo + "[8]: " + v7 + " -> " + cols.get(7));
					}
				} //20160502 add
				if (cols.size() > 31) { //20160502 add
					String v31 = cols.get(31);
					if (!v31.equals("\" \"") && !v31.equals("\"P\"")) {
						cols.set(31,  "\" \"");
						System.out.println("line " + lineNo + "[32]: " + v31 + " -> " + cols.get(31));
					}
				} //20160502 add
				if (cols.size() > 50) { //20160502 add
					String v50 = cols.get(50);
					if (!v50.equals("0")) {
						cols.set(50, "0");
						System.out.println("line " + lineNo + "[51]: " + v50 + " -> " + cols.get(50));
					}
				} //20160502 add
				if (cols.size() > 51) { //20160502 add
					String v51 = cols.get(51);
					if (!v51.equals("0")) {
						cols.set(51, "0");
						System.out.println("line " + lineNo + "[52]: " + v51 + " -> " + cols.get(51));
					}
				} //20160502 add
				//20160517 add start
				if (cols.size() > 54) {
					String v54 = cols.get(54);
					if (!v54.equals("0")) {
						cols.set(54, "0");
						System.out.println("line " + lineNo + "[55]: " + v54 + " -> " + cols.get(54));
					}
				}
				//20160517 add end
				StringBuffer sb = new StringBuffer();
				for (int i=0; i<cols.size(); i++) {
					if (i > 0) {
						sb.append(",");
					}
					sb.append(cols.get(i));
				}
				if (cols.size() == 83) { //20160502 add
					w.write(sb.toString());
					w.newLine();
				} else { //20160502 add
					System.out.println("line " + lineNo + " Error:" + sb.toString()); //20160502 add
				} //20160502 add
				lineNo++;
			}
			w.close();
			r.close();
		} catch (IOException e) {
			System.out.println("I/Oエラーが発生しました。");
			e.printStackTrace();
			return 6;
		}
		return 0;
	}

}
