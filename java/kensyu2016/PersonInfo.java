package kensyu2016;

import java.util.Comparator;

public class PersonInfo {
	private String name;
	private String kana;
	private int age;

	public PersonInfo(String name, String kana, int age) {
		this.name = name;
		this.kana = kana;
		this.age = age;
	}

	public static class PersonComparator implements Comparator<PersonInfo> {
		public int compare(PersonInfo p1, PersonInfo p2) {
			if (p1.kana.equals(p2.kana)) {
				return p1.age - p2.age;
			}
			return p1.kana.compareTo(p2.kana);
		}
	}

	public String getName() {
		return name;
	}

	public String getKana() {
		return kana;
	}

	public int getAge() {
		return age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setKana(String kana) {
		this.kana = kana;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
