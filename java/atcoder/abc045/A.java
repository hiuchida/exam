package atcoder.abc045;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int a = Integer.parseInt(line);
		line = br.readLine();
		int b = Integer.parseInt(line);
		line = br.readLine();
		int h = Integer.parseInt(line);
		System.out.println((a+b)*h/2);
	}

}
