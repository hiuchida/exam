package csv_repair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import csv_parser.CSVParser;

public class GetSCHDAY {

	public static void main(String[] args) {
		int rc = execute(args);
		System.exit(rc);
	}
	
	static int execute(String[] args) {
		/*
		if (args.length < 1) {
			System.err.println("usage: java GetSCHDAY FilePath");
			return 1;
		}
		String csvpath = args[0];
		*/
		String csvpath = "C:/BSP/A-AUTO_APServer/temp/TW_NETINFO1.CSV";
		BufferedReader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(csvpath), "UTF-8"));
		} catch (Exception e) {
			System.out.println("CSVファイル(" + csvpath + ")のオープンに失敗しました。");
			e.printStackTrace();
			return 2;
		}
		try {
			int lineNo = 1;
			Set<String> set = new LinkedHashSet<String>();
			String line = r.readLine();
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
				String v1 = cols.get(1);
				v1 = v1.substring(1, v1.length()-1);
				if (v1.length() == 8) { //20160502 add
					if (!set.contains(v1)) {
						set.add(v1);
					}
				} //20160502 add
				lineNo++;
			}
			r.close();
			if (set.size() == 0) {
				System.out.println("SCHDAYが見つかりません。");
				return 3;
			}
			boolean bFirst = true;
			for (String s : set) {
				if (!bFirst) {
					System.out.print(",");
				}
				System.out.print("'" + s + "'");
				bFirst = false;
			}
		} catch (IOException e) {
			System.out.println("I/Oエラーが発生しました。");
			e.printStackTrace();
			return 4;
		}
		return 0;
	}

}
