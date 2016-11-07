package pgcon1.t;

import java.util.Scanner;

public class Q3b {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int oldTax = scanner.nextInt();
		int newTax = scanner.nextInt();
		int sum = scanner.nextInt();

		int max = 0;
		int sumOldTax = 0;
		int sumNewTax = 0;
		int itemAoldTax = 0;
		int itemAnewTax = 0;

		for (int i = 1; i < sum; i++) {
			itemAoldTax = i * (100 + oldTax) / 100;
			for (int j = i; j < sum; j++) {
				sumOldTax = itemAoldTax + (j * (100 + oldTax) / 100);
				if (sumOldTax == sum) {
					sumNewTax = (i * (100 + newTax) / 100) + (j * (100 + newTax) / 100);
					if (sumNewTax > max) {
						max = sumNewTax;
					}
				} else if (sumOldTax > sum) {
					break;
				}
			}
		}
		System.out.println(max);
		scanner.close();
	}
}

