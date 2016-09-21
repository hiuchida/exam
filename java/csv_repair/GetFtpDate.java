package csv_repair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetFtpDate {

	public static void main(String[] args) {
		int rc = execute(args);
		System.exit(rc);
	}

	static int execute(String[] args) {
		/*
		if (args.length < 1) {
			System.err.println("usage: java GetFtpDate FilePath");
			return 1;
		}
		String logpath = args[0];
		*/
		String logpath = "C:/Program Files (x86)/PostgreSQL/8.4/data/pg_log/postgresql.log";
		BufferedReader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(logpath), "UTF-8"));
		} catch (Exception e) {
			System.out.println("LOGファイル(" + logpath + ")のオープンに失敗しました。");
			e.printStackTrace();
			return 2;
		}
		try {
			int lineNo = 1;
			//int errorLineNo = 0; //20160510 remove
			int errorLineNo = -1; //20160510 add
			String ftpdate = null;
			while (true) {
				String line = r.readLine();
				if (line == null) break;
				//int idx = line.indexOf("ERROR:  syntax error"); //20160509 remove
				int idx = line.indexOf("ERROR:"); //20160509 add
				if (idx >= 0) {
					errorLineNo = lineNo;
				} else { //20160510 add
					//int idx2 = line.indexOf("STATEMENT:"); //20160509 remove
					int idx2 = line.indexOf("STATEMENT:  INSERT INTO TW_NETINFO"); //20160509 add
					if (idx2 >= 0 && lineNo == errorLineNo + 1) {
						String v = getFtpDate(line);
						if (v != null) {
							ftpdate = v;
						}
					}
				} //20160510 add
				lineNo++;
			}
			r.close();
			if (ftpdate == null) {
				System.out.println("FtpDateが見つかりません。");
				return 3;
			}
			System.out.println(ftpdate);
		} catch (IOException e) {
			System.out.println("I/Oエラーが発生しました。");
			e.printStackTrace();
			return 4;
		}
		return 0;
	}
	
	static String getFtpDate(String line) {
		int idx = line.indexOf("VALUES(");
		if (idx < 0) {
			return null;
		}
		//int idx2 = line.indexOf("','", idx); //20160510 remove
		int idx2 = line.indexOf("','", idx + 7); //20160510 add
		if (idx2 < 0) {
			return null;
		}
		int idx3 = line.indexOf("'", idx2 + 3);
		if (idx3 < 0) {
			return null;
		}
		return line.substring(idx2 + 3, idx3);
	}

}
