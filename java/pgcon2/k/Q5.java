package pgcon2.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Q5 {
    private static class Time implements Comparable<Time> {
        private int hour;
        private int minute;
        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }
        public int getHour() {
            return this.hour;
        }
        public int getMinute() {
            return this.minute;
        }
        public String toString() {
            return String.format("%02d:%02d", hour, minute);
        }
        public int diff(Time that) {
            return (this.hour - that.hour) * 60 + (this.minute - that.minute);
        }
        public int compareTo(Time that) {
            if (this.hour < that.hour) {
                return -1;
            } else if (this.hour > that.hour) {
                return 1;
            } else if (this.minute < that.minute) {
                return -1;
            } else if (this.minute > that.minute) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    private static class Period implements Comparable<Period> {
        private Time startTime;
        private Time endTime;
        private int interval;
        public Period(Time startTime, Time endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.interval = (this.endTime.getHour() - this.startTime.getHour()) * 60 + (this.endTime.getMinute() - this.startTime.getMinute());
        }
        public Time getStartTime() {
            return this.startTime;
        }
        public Time getEndTime() {
            return this.endTime;
        }
        public int getInterval() {
            return this.interval;
        }
        public String toString() {
            return startTime + " " + endTime;
        }
        public int compareTo(Period that) {
            int r;
            if ((r = this.startTime.compareTo(that.startTime)) != 0) {
                return r;
            } else if ((r = this.endTime.compareTo(that.endTime)) != 0) {
                return r;
            } else {
                return 0;
            }
        }
    }
    private static class Movie implements Comparable<Movie> {
        private int index;
        private String title;

        private int selectedScheduleIdx = 0;

        public Movie(int index, String title) {
            this.index = index;
            this.title = title;
        }
        public int getIndex() {
            return index;
        }
        public String getTitle() {
            return this.title;
        }
        public String toString() {
            return title;
        }
        public int compareTo(Movie that) {
            if (this.index < that.index) {
                return -1;
            } else if (this.index > that.index) {
                return 1;
            } else {
                return 0;
            }
        }
    }
    private static class ScheduleList {
        private Movie movie;
        private List<Period> scheduleList = new ArrayList<>();
        public ScheduleList(Movie movie) {
            this.movie = movie;
        }
        public Movie getMovie() {
            return this.movie;
        }
        public int getScheduleCount() {
            return this.scheduleList.size();
        }
        public Period getScheduleAt(int index) {
            return this.scheduleList.get(index);
        }
        public void addSchedule(Period schedule) {
            this.scheduleList.add(schedule);
            Collections.sort(this.scheduleList);
        }
        public String toString() {
            return this.movie + " " + this.scheduleList;
        }
    }
    private static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Pair<K, V>> {
        private K k;
        private V v;
        public Pair(K k, V v) {
            this.k = k;
            this.v = v;
        }
        public K getKey() {
            return this.k;
        }
        public V getValue() {
            return this.v;
        }
        public String toString() {
            return k + " " + v;
        }
        public int compareTo(Pair<K, V> that) {
            int r;
            if ((r = this.getValue().compareTo(that.getValue())) != 0) {
                return r;
            }
            if ((r = this.getKey().compareTo(that.getKey())) != 0) {
                return r;
            }
            return 0;
        }
    }
    private static class SelectedSchedule {
        private ScheduleList[] scheduleListArray;
        private int[] idxAry;
        public void setSelected(ScheduleList[] ary, int[] idxAry) {
            if (ary.length != idxAry.length) {
                throw new IllegalArgumentException(ary.length + " != " + idxAry.length);
            }
            this.scheduleListArray = ary;
            this.idxAry = idxAry;
        }
        public ScheduleList[] getScheduleListArray() {
            return this.scheduleListArray;
        }
        public int[] getIndexArray() {
            return this.idxAry;
        }
        public int length() {
            return scheduleListArray.length;
        }
        public Pair<Movie, Period> getPairAt(int idx) {
            ScheduleList schList = this.scheduleListArray[idx];
            Movie movie = schList.getMovie();
            Period schedule = schList.getScheduleAt(idxAry[idx]);
            return new Pair<>(movie, schedule);
        }
        public List<Pair<Movie, Period>> getPairList() {
            List<Pair<Movie, Period>> list = new ArrayList<>();
            for (int i = 0; i < this.length(); ++i) {
                list.add(this.getPairAt(i));
            }
            Collections.sort(list);
            return list;
        }
        public boolean isSet() {
            return this.scheduleListArray != null;
        }
    }
    private static class Combination<T> implements Iterator {
        private List<T> list;
        private int[] indexes;
        private int[] lastIndexes;
        private int r;

        private List<T> combination;

        public Combination(List<T> list, int r) throws IllegalArgumentException {
            if(list.isEmpty() || r < 1 || list.size() < r){
                throw new IllegalArgumentException();
            }
            this.list = list;
            this.r = r;
            this.indexes = null;
            this.lastIndexes = this.getLastIndexes();

            this.combination = new ArrayList<>();
        }

        private int[] getFirstIndexes(){
            int[] indexes = new int[this.r];

            for(int i = 0;i < this.r;i++){
                indexes[i] = i;
            }

            return indexes;
        }

        private int[] getLastIndexes(){
            int[] indexes = new int[this.r];

            for(int i = this.r - 1, j = this.list.size() - 1;i >= 0;i--, j--){
                indexes[i] = j;
            }

            return indexes;
        }

        public List<T> next(){
            if(Arrays.equals(this.indexes, this.lastIndexes)){
                return null;
            }
            if(this.indexes == null){
                this.indexes = this.getFirstIndexes();
            } else if(this.indexes[this.indexes.length - 1] < this.list.size() - 1){
                this.indexes[this.indexes.length - 1]++;
            } else{
                int index = 0;
                for(int i = this.indexes.length - 2;i >= 0;i--){
                    if(this.indexes[i] != this.indexes[i + 1] - 1){
                        this.indexes[i]++;
                        index = i;
                        break;
                    }
                }
                for(int i = index + 1;i < this.indexes.length;i++){
                    this.indexes[i] = this.indexes[i - 1] + 1;
                }
            }

            combination.clear();
            for(int i = 0;i < this.indexes.length;i++){
                combination.add(list.get(this.indexes[i]));
            }
            return combination;
        }

        public boolean hasNext(){
            if(Arrays.equals(this.indexes, this.lastIndexes)){
                return false;
            }
            return true;
        }
        public void remove() {
        }
    }
    private static class ScheduleSolver implements Iterator {
        private List<ScheduleList> scheduleListList;
        private int interval;
        private int[] output;

        private int[] selected;

        public ScheduleSolver(List<ScheduleList> scheduleListList, int interval, int[] output) {
            this.scheduleListList = scheduleListList;
            this.interval = interval;
            this.output = output;

            this.selected = new int[this.scheduleListList.size()];
        }
        public boolean hasNext() {
            if (this.selected[0] >= this.scheduleListList.get(0).getScheduleCount()) {
                return false;
            }

            return true;
        }
        public int[] next() {
            boolean isOk;
            do {
                if (this.selected[0] >= this.scheduleListList.get(0).getScheduleCount()) {
                    return null;
                }

                isOk = false;
                System.arraycopy(this.selected, 0, this.output, 0, this.output.length);
                isOk = checkOutput();

                ++this.selected[this.selected.length - 1];
                for (int i = this.selected.length - 1; i >= 0; --i) {
                    if (this.selected[i] >= this.scheduleListList.get(i).getScheduleCount()) {
                        if (i > 0) {
                            this.selected[i] = 0;
                            ++this.selected[i - 1];
                        }
                    } else {
                        break;
                    }
                }
            } while (!isOk);

            return this.output;
        }
        public void remove() {
        }
        private boolean checkOutput() {
            List<Pair<Movie, Period>> list = new ArrayList<>();
            int i = 0;
            for (ScheduleList sl : this.scheduleListList) {
                Movie m = sl.getMovie();
                Period p = sl.getScheduleAt(this.output[i]);
                list.add(new Pair<>(m, p));

                ++i;
            }

            Collections.sort(list);

            Pair<Movie, Period> pair1 = list.get(0);
            for (int j = 1; j < list.size(); ++j) {
                Pair<Movie, Period> pair2 = list.get(j);
                if (pair1.getValue().getEndTime().compareTo(pair2.getValue().getStartTime()) > 0) {
                    return false;
                } else if (pair2.getValue().getStartTime().diff(pair1.getValue().getEndTime()) < this.interval) {
                    return false;
                }
                pair1 = pair2;
            }

            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int I = sc.nextInt();
        List<ScheduleList> schedules = new ArrayList<>(N);
        sc.nextLine(); // 改行をスキップ

        // 読み込み
        for (int i = 0; i < N; ++i) {
            String line = sc.nextLine();
            String[] tokens = line.split("[ ]+");
            if (tokens.length > 0) {
                String title = tokens[0];
                Movie movie = new Movie(i, title);
                schedules.add(new ScheduleList(movie));
                for (int j = 1; j + 1 < tokens.length; j += 2) {
                    String startTime = tokens[j];
                    String endTime = tokens[j + 1];
                    String[] start = startTime.split(":");
                    String[] end = endTime.split(":");
                    Period schedule =
                        new Period(
                            new Time(
                                Integer.parseInt(start[0]),
                                Integer.parseInt(start[1])),
                            new Time(
                                Integer.parseInt(end[0]),
                                Integer.parseInt(end[1])));
                    schedules.get(i).addSchedule(schedule);
                }
            }
        }

        // 解析
        int maxCount = N;
        boolean found;
        int foundCount;
        List<Pair<Movie, Period>> answer = null;
        SelectedSchedule tmp = new SelectedSchedule();
        do {
            found = false;
            foundCount = 0;

            Combination<ScheduleList> c = new Combination<>(schedules, maxCount);
            int[] selectedSchedule = new int[maxCount];
            while (c.hasNext()) {
                List<ScheduleList> selectedMovie = c.next();

                ScheduleSolver ss = new ScheduleSolver(selectedMovie, I, selectedSchedule);
                while (ss.hasNext()) {
                    if (ss.next() == null) {
                        break;
                    }

                    ++foundCount;
                    tmp.setSelected(selectedMovie.toArray(new ScheduleList[selectedMovie.size()]), selectedSchedule.clone());
                    List<Pair<Movie, Period>> tmpList = tmp.getPairList();

                    if (answer == null) {
                        answer = tmpList;
                    } else {
                        Period p0 = answer.get(0).getValue();
                        Period p1 = tmpList.get(0).getValue();

                        if (p0.getStartTime().compareTo(p1.getStartTime()) < 0) {
                            answer = tmpList;
                        } else if (p0.getStartTime().compareTo(p1.getStartTime()) == 0) {
                            for (int i = 0; i < answer.size(); ++i) {
                                Pair<Movie, Period> pair0 = answer.get(i);
                                Pair<Movie, Period> pair1 = tmpList.get(i);
                                if (pair0.getKey().getIndex() == pair1.getKey().getIndex()) {
                                    continue;
                                } else if (pair0.getKey().getIndex() < pair1.getKey().getIndex()) {
                                    break;
                                }
                                answer = tmpList;
                            }
                        }
                    }

                    found = true;
                }
            }

            if (!found) {
                --maxCount;
            }
        } while (!found && maxCount > 0);

        System.out.println(maxCount);
        System.out.println(foundCount);
        for (int i = 0; i < answer.size() - 1; ++i) {
            Pair<Movie, Period> p = answer.get(i);
            Pair<Movie, Period> next = answer.get(i + 1);
            System.out.print(p);
            System.out.print(" ");
            System.out.print(next.getValue().getStartTime().diff(p.getValue().getEndTime()));
            System.out.println();
        }
        Pair<Movie, Period> p = answer.get(answer.size() - 1);
        System.out.println(p);
    }
}
