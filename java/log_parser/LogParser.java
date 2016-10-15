package log_parser;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

	static List<Log> list = new ArrayList<>();

	enum Status {
		NONE, START, STOP
	}

	static class Log {
		String date;
		String thread;
		String userid;
		String ipaddr;
		String level;
		String msg;
		Status status;
		Log end;

		public boolean parse(String line) {
			if (line.charAt(4) != '-' || line.charAt(7) != '-' || line.charAt(13) != ':' || line.charAt(16) != ':') {
				return false;
			}
			date = line.substring(0, 23);
			thread = line.substring(25, 38).trim();
			userid = line.substring(40, 57).trim();
			ipaddr = line.substring(58, 74).trim();
			level = line.substring(76, 81).trim();
			msg = line.substring(83);
			status = Status.NONE;
			if (msg.endsWith("[Start]")) {
				status = Status.START;
			} else if (msg.endsWith("[ End ]")) {
				status = Status.STOP;
			}
			if (status != Status.NONE) {
				msg = msg.substring(0, msg.length() - 7).trim();
			}
			/*
			 * System.out.println("<"+date+">");
			 * System.out.println("<"+thread+">");
			 * System.out.println("<"+userid+">");
			 * System.out.println("<"+ipaddr+">");
			 * System.out.println("<"+level+">");
			 * System.out.println("<"+msg+">");
			 * System.out.println("<"+status+">");
			 */
			return status != Status.NONE;
		}
	}

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		String fname = "app.log";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fname), "MS932"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			Log log = new Log();
			if (log.parse(line)) {
				if ("bsp.auto.managed.watch.WatchChartManager.getPage()".equals(log.msg)) {
					list.add(log);
				}
			}
		}
		br.close();
		for (int i = 0; i < list.size(); i++) {
			Log log = list.get(i);
			if (log.status == Status.START) {
				for (int j = i + 1; j < list.size(); j++) {
					Log log2 = list.get(j);
					if (!log.thread.equals(log2.thread))
						continue;
					if (log2.status == Status.START)
						break;
					log.end = log2;
					break;
				}
			}
		}
		for (Log log : list) {
			if (log.status == Status.START) {
				System.out.print(log.date.substring(0, 19) + ",");
				if (log.end != null) {
					System.out.print(log.end.date.substring(0, 19));
				}
				System.out.print("," + log.thread + ",");
				if (log.end != null) {
					System.out.print(log.end.ipaddr);
				} else {
					System.out.print(log.ipaddr);
				}
				System.out.println("");
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

}
