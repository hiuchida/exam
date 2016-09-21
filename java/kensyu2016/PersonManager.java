package kensyu2016;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PersonManager {
	//private static Person[] ary = new Person[10];
	//private static int cnt;
	private static List<Person> list = new ArrayList<Person>();
	//private static Set<String> set = new HashSet<String>();
	private static Map<String, Person> map = new LinkedHashMap<String, Person>();
	
	public static void add(Person p) {
		//ary[cnt++] = p;
		//if (set.contains(p.getName())) return;
		if (map.containsKey(p.getName())) return;
		list.add(p);
		//Collections.sort(list);
		Collections.sort(list, new PersonComparator());
		//set.add(p.getName());
		map.put(p.getName(), p);
	}
	
	public static Person get(int i) {
		//return ary[i];
		return list.get(i);
	}
	
	public static Person search(String name) {
		return map.get(name);
	}
	
	public static int size() {
		//return cnt;
		return list.size();
	}

	public static void main(String[] args) {
		add(new Person("B", 20, null));
		add(new Person("A", 10, null));
		add(new Person("A", 30, null));
		for (int i=0; i<size(); i++) {
			System.out.println(get(i));
		}
		System.out.println(search("A"));
		System.out.println(search("B"));
		for (Iterator<String> itr = map.keySet().iterator(); itr.hasNext(); ) {
			String key = itr.next();
			System.out.println(key);
		}
		for (String key : map.keySet()) {
			System.out.println(key);
		}
		for (Map.Entry<String, Person> e : map.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}

}
