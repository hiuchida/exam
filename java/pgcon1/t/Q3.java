package pgcon1.t;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int oldTax = scanner.nextInt();
		int newTax = scanner.nextInt();
		int sum = scanner.nextInt();

		int max = 0;
		int itemA = 0;
		int itemB = 0;
		int itemAoldTax = 0;
		int itemBoldTax = 0;
		int sumNewTax = 0;

		for (int i = 1; i < sum; i++) {
			itemA = i;
			itemAoldTax = itemA * (100 + oldTax) / 100;
			itemBoldTax = sum - itemAoldTax;
			if (itemBoldTax <= 0) {
				break;
			}
			itemB = (int)Math.ceil(itemBoldTax / ((100.0 + oldTax) / 100.0));
			itemBoldTax = itemB * (100 + oldTax) / 100;
			if (itemAoldTax + itemBoldTax == sum) {
				sumNewTax = (itemA * (100 + newTax) / 100) + (itemB * (100 + newTax) / 100);
				if (sumNewTax > max) {
					max = sumNewTax;
				}
			}
		}
		System.out.println(max);
		scanner.close();
	}
}
