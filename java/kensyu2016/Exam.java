package kensyu2016;

public class Exam {

	public static void main(String[] args) {
		int a = 100, b = 100, c = 100;
		a = b = c = 100;
		// a = 1, b = 2, c = 3;
		// a;
		// a+b;

		StringBuffer sb = new StringBuffer();
		sb.append("A").append("B").append("C");

		for (int d = 0; d < 10; d++) {
			;
		}
		int d = +123;
		c = +a;

		boolean f = !false;
		// d = !1;
		d = ~1;
		d = 1 ^ 1;
		// d = ++1;
		// d = 1++;
		// System.out.println(d);

		d = 1;
		func(d++, d++);
		d = 1;
		func(++d, ++d);

		int i = 1234;
		Object o2 = (Object) i;

		Exam o = new Exam();
		f = o instanceof Exam;

		int[] ary = new int[1];
		int ary2[] = new int[1];
		// int ary3[10];
		int[] ary4;
		int ary5[];
		d = args.length;
		int[][] ary6 = new int[2][3];
		int ary7[][] = new int[2][3];

		switch (a) {
		case 1:
			d++;
		case 2:
			d++;
			break;
		}
		//switch ("a") { case "a": break; }
		/*
		 * switch (f) { case true: break; }
		 */
	}

	static void func(int a, int b) {
		System.out.println("a=" + a + ", b=" + b);
	}

}
