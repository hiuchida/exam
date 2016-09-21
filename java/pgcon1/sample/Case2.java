package pgcon1.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Case2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String[] lineArray = line.split(" ");
		Integer answer = 0;
		for (String token : lineArray) {
			answer += Integer.parseInt(token);
		}
		System.out.println("answer=" + answer);
	}

}
