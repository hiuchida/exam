package pgcon1.sample;

import java.util.Scanner;

public class Case1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int answer = 0;
			int n = sc.nextInt();
			for (int j = 0; j < n; j++) {
				int a = sc.nextInt();
				answer += a;
			}
			System.out.println("answer=" + answer);
		}
	}
}
