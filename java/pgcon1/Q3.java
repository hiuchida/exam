package pgcon1;

import java.util.Scanner;

public class Q3 {

	static Scanner sc = new Scanner(System.in);
	
    public static void main(String[] args) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		int s = sc.nextInt();
		int max = 0;
		for (int s1=1; s1<s; s1++) {
			for (int s2=1; s2<s; s2++) {
				if (s1+s2 > s) continue;
				int v1 = s1*(100+x)/100 + s2*(100+x)/100;
				if (v1 != s) continue;
				int v2 = s1*(100+y)/100 + s2*(100+y)/100;
				if (v2 > max) {
					max = v2;
				}
			}
		}
		System.out.println(max);
    }

}
