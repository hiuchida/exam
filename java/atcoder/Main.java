package atcoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int a = Integer.parseInt(line);
		line = br.readLine();
		String[] flds = line.split(" ");
		int b = Integer.parseInt(flds[0]);
		int c = Integer.parseInt(flds[1]);
		line = br.readLine();
		System.out.println("" + (a+b+c) + " " + line);
	}

}
