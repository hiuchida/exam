package csv_repair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class CheckCSV {

	public static void main(String[] args) {
		System.out.println("CheckCSV started at " + new Date());
		int rc = execute(args);
		System.out.println("CheckCSV ended at " + new Date() + " returnCode=" + rc);
		System.exit(rc);
	}
	
	static int execute(String[] args) {
		if (args.length < 2) {
			System.err.println("usage: java CheckCSV FilePath MonitorId");
			return 0;
		}
		String fpath = args[0];
		String monitorId = args[1];
		BufferedReader r = null;
		try {
			r = new BufferedReader(new InputStreamReader(new FileInputStream(fpath), "UTF-8"));
		} catch (Exception e) {
			System.out.println("CSVファイル(" + fpath + ")のオープンに失敗しました。");
			e.printStackTrace();
			return 0;
		}
		try {
			int lineNo = 1;
			int errorCnt = 0;
			while (true) {
				String line = r.readLine();
				if (line == null) break;
				if (!line.startsWith("\""+monitorId)) {
					System.out.println("line " + lineNo + ": " + line);
					errorCnt++;
				}
				lineNo++;
			}
			r.close();
			return errorCnt;
		} catch (IOException e) {
			System.out.println("I/Oエラーが発生しました。");
			e.printStackTrace();
			return 0;
		}
	}

}
