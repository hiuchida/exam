package log_parser;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TasklistLogParser {
	
	static int no;
	static String startDate1;
	static String startDate2;
	static List<String> tasklist1 = new ArrayList<>();
	static List<String> tasklist2 = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		String fname = "/tmp/tasklist.log";
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fname), "MS932"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.startsWith("###")) {
				if (line.endsWith("OUTPUT TASKLIST START")) {
					String date = line.substring(14, 22).trim();
					start(date);
				}
			}
			if (line.startsWith("java.exe")) {
				task(line);
			}
			if (line.startsWith("postgres.exe")) {
				task(line);
			}
		}
		br.close();
		Collections.sort(tasklist1);
		Collections.sort(tasklist2);
		fname = fname.replaceAll("log", "txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fname));
		bw.write(startDate1 + "時点\t\t\t\t\t" + startDate2 + "時点");
		bw.newLine();
		int idx1 = 0;
		int idx2 = 0;
		while (idx1 < tasklist1.size() && idx2 < tasklist2.size()) {
			String task1 = tasklist1.get(idx1);
			String task2 = tasklist2.get(idx2);
			String id1 = task1.substring(0, 34);
			String id2 = task2.substring(0, 34);
			int cmp = id1.compareTo(id2);
			if (cmp == 0) {
				same(bw, task1, task2);
				idx1++;
				idx2++;
			} else if (cmp < 0) {
				left(bw, task1);
				idx1++;
			} else {
				right(bw, task2);
				idx2++;
			}
		}
		while (idx1 < tasklist1.size()) {
			String task1 = tasklist1.get(idx1);
			left(bw, task1);
			idx1++;
		}
		while (idx2 < tasklist2.size()) {
			String task2 = tasklist2.get(idx2);
			right(bw, task2);
			idx2++;
		}
		bw.close();
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "ms");
	}

	static void start(String date) {
		no++;
		switch (no) {
		case 1:
			startDate1 = date;
			break;
		case 2:
			startDate2 = date;
			break;
		}
	}
	
	static void task(String line) {
		switch (no) {
		case 1:
			tasklist1.add(line);
			break;
		case 2:
			tasklist2.add(line);
			break;
		}
	}
	
	static void same(BufferedWriter bw, String task1, String task2) throws Exception {
		String exe1 = task1.substring(0, 25).trim();
		String pid1 = task1.substring(26, 34).trim();
		String mem1 = task1.substring(64, 74).trim();
		String cpu1 = task1.substring(144, 156).trim();
		String exe2 = task2.substring(0, 25).trim();
		String pid2 = task2.substring(26, 34).trim();
		String mem2 = task2.substring(64, 74).trim();
		String cpu2 = task2.substring(144, 156).trim();
		bw.write(exe1+"\t"+pid1+"\t"+mem1+"\t"+cpu1+"\t\t"+exe2+"\t"+pid2+"\t"+mem2+"\t"+cpu2);
		bw.newLine();
	}
	
	static void left(BufferedWriter bw, String task1) throws Exception {
		String exe1 = task1.substring(0, 25).trim();
		String pid1 = task1.substring(26, 34).trim();
		String mem1 = task1.substring(64, 74).trim();
		String cpu1 = task1.substring(144, 156).trim();
		bw.write(exe1+"\t"+pid1+"\t"+mem1+"\t"+cpu1);
		bw.newLine();
	}
	
	static void right(BufferedWriter bw, String task2) throws Exception {
		String exe2 = task2.substring(0, 25).trim();
		String pid2 = task2.substring(26, 34).trim();
		String mem2 = task2.substring(64, 74).trim();
		String cpu2 = task2.substring(144, 156).trim();
		bw.write("\t\t\t\t\t"+exe2+"\t"+pid2+"\t"+mem2+"\t"+cpu2);
		bw.newLine();
	}
}
