package clone;

public class ArrayTest {
	/*
	public static void main(String[] args) {
		int[][] map = new int[3][3];
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				map[y][x] = x+y;
			}
		}
		System.out.println("before");
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				System.out.print(map[y][x] + " ");;
			}
			System.out.println("");
		}
		int[][] nmap = map.clone();
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				nmap[y][x] = 4-(x+y);
			}
		}
		System.out.println("after");
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				System.out.print(map[y][x] + " ");;
			}
			System.out.println("");
		}
	}
	*/
	/*
	public static void main(String[] args) {
		int[][] map = new int[3][3];
		System.out.println("before");
		for (int y=0; y<3; y++) {
			System.out.println(map[y]);
		}
		int[][] nmap = map.clone();
		System.out.println("after");
		for (int y=0; y<3; y++) {
			System.out.println(nmap[y]);
		}
	}
	*/
	/*
	public static void main(String[] args) {
		int[][] map = new int[3][3];
		System.out.println("before");
		for (int y=0; y<3; y++) {
			System.out.println(map[y]);
		}
		int[][] nmap = new int[3][];
		for (int y=0; y<3; y++) {
			nmap[y] = map[y].clone();
		}
		System.out.println("after");
		for (int y=0; y<3; y++) {
			System.out.println(nmap[y]);
		}
	}
	*/
	
	public static void main(String[] args) {
		int[][] map = new int[3][3];
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				map[y][x] = x+y;
			}
		}
		System.out.println("before");
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				System.out.print(map[y][x] + " ");;
			}
			System.out.println("");
		}
		int[][] nmap = new int[3][];
		for (int y=0; y<3; y++) {
			nmap[y] = map[y].clone();
		}
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				nmap[y][x] = 4-(x+y);
			}
		}
		System.out.println("after");
		for (int y=0; y<3; y++) {
			for (int x=0; x<3; x++) {
				System.out.print(map[y][x] + " ");;
			}
			System.out.println("");
		}
	}
}
