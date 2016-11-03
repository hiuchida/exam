package pgcon2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q5 {
	static boolean bElapsed = false;
	int interval;
	List<String> movieList = new ArrayList<>();
	List<Schedule> scheduleList = new ArrayList<>();
	List<Schedule> answerList = new ArrayList<>();
	int answerCnt;

	void solve(BufferedReader br) throws Exception {
		String line = br.readLine();
		int n = Integer.parseInt(line);
		line = br.readLine();
		interval = Integer.parseInt(line);
		for (int i=0; i<n; i++) {
			line = br.readLine();
			parse(i, line);
		}
		Collections.sort(scheduleList);
		for (int i=0; i<scheduleList.size(); i++) {
			List<Schedule> list = new ArrayList<>();
			Set<Integer> set = new HashSet<>();
			Schedule prev = scheduleList.get(i);
			list.add(prev);
			set.add(prev.movieIdx);
			search(i+1, list, set);
		}
		pln(answerList.size());
		pln(answerCnt);
		for (int i=0; i<answerList.size(); i++) {
			Schedule s = answerList.get(i);
			int diff=-1;
			if (i+1<answerList.size()) {
				Schedule next = answerList.get(i+1);
				diff = next.start - s.end;
			}
			String title = movieList.get(s.movieIdx);
			String start = s.getStartStr();
			String end = s.getEndStr();
			if (diff>=0) {
				pln(title+" "+start+" "+end+" "+diff);
			} else {
				pln(title+" "+start+" "+end);
			}
		}
	}
	
	void parse(int idx, String line) {
		String[] flds = line.split(" ");
		movieList.add(flds[0]);
		boolean bStart = true;
		int start = 0;
		for (int i=1; i<flds.length; i++) {
			if (flds[i].length() == 0) continue;
			String[] hhmm = flds[i].split(":");
			int time = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
			if (bStart) start = time;
			else scheduleList.add(new Schedule(idx, start, time));
			bStart = !bStart;
		}
	}
	
	void search(int idx, List<Schedule> list, Set<Integer> set) {
		check(list);
		if (list.size() >= movieList.size()) return;
		Schedule prev = list.get(list.size()-1);
		for (int i=idx; i<scheduleList.size(); i++) {
			Schedule s = scheduleList.get(i);
			if (set.contains(s.movieIdx)) continue;
			if (s.start - prev.end < interval) continue;
			list.add(s);
			set.add(s.movieIdx);
			search(i+1, list, set);
			list.remove(list.size()-1);
			set.remove(s.movieIdx);
		}		
	}
	
	void check(List<Schedule> list) {
		if (answerList == null) {
			answerList = new ArrayList<>(list);
			answerCnt = 1;
		} else if (list.size() > answerList.size()) {
			answerList = new ArrayList<>(list);
			answerCnt = 1;
		} else if (list.size() == answerList.size()) {
			if (isReplace(list)) {
				answerList = new ArrayList<>(list);
			}
			answerCnt++;
		}
	}
	
	boolean isReplace(List<Schedule> list) {
		int s1 = list.get(0).start;
		int s2 = answerList.get(0).start;
		if (s1 > s2) return true;
		for (int i=0; i<list.size(); i++) {
			Schedule sc1 = list.get(i);
			Schedule sc2 = answerList.get(i);
			if (sc1.movieIdx < sc2.movieIdx) return true;
			else if (sc1.movieIdx > sc2.movieIdx) return false;
		}
		return false;
	}

	class Schedule implements Comparable<Schedule> {
		int movieIdx;
		int start;
		int end;

		public Schedule(int idx, int start, int end) {
			this.movieIdx = idx;
			this.start = start;
			this.end = end;
		}
		
		public int compareTo(Schedule o) {
			int diff = start - o.start;
			if (diff != 0) return diff;
			return movieIdx - o.movieIdx;
		}
		
		public String getStartStr() {
			return getStr(start);
		}
		
		public String getEndStr() {
			return getStr(end);
		}
		
		private String getStr(int time) {
			return String.format("%02d:%02d", time/60, time%60);
		}
	}
	
	void p(char c) {
		System.out.print(c);
	}
	void pln(char c) {
		System.out.println(c);
	}
	void p(long l) {
		System.out.print(l);
	}
	void pln(long l) {
		System.out.println(l);
	}
	void p(String s) {
		System.out.print(s);
	}
	void pln(String s) {
		System.out.println(s);
	}
	//Integer.MAX_VALUE=2147483647>10^9
	//Long.MAX_VALUE=9223372036854775807L>10^18
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		new Q5().solve(br);
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.out.println((end-start) + "ms");
		}
	}
}
