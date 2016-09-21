package pgcon1.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q1 {

	static BufferedReader br;
	static String line;
	static StringTokenizer token;

	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayList<Integer> have = new ArrayList<Integer>();
		ArrayList<Integer> sell = new ArrayList<Integer>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line, " ");
		int last = Integer.parseInt(token.nextToken());

		if (last < 1 || last > 1000) {
			while(last < 1 || last > 1000){
				//System.out.println("もう一度入力してください。");
				line = br.readLine();
				token = new StringTokenizer(line, " ");
				last = Integer.parseInt(token.nextToken());
			}
		}

		while ((line = br.readLine()) != null) {
			token = new StringTokenizer(line, " ");
			// System.out.print("持っている巻は");
			int first = Integer.parseInt(token.nextToken());
			if(first==0) {
				break;
			}else {
				if (first <= last) {
					// System.out.print(s+" ");
					have.add(first);
				}
			}
			while (token.hasMoreTokens()) {
				int h = Integer.parseInt(token.nextToken());
				if (h == 0) {
					break;
				}
				if (h <= last) {
					// System.out.print(h+" ");
					have.add(h);
				}
			}
			break;
		}

		while ((line = br.readLine()) != null) {
			token = new StringTokenizer(line, " ");
			// System.out.print("在庫のある巻は");
			int first = Integer.parseInt(token.nextToken());
			if(first==0) {
				break;
			}else {
				if (first <= last) {
					// System.out.print(s+" ");
					sell.add(first);
				}
			}
			while (token.hasMoreTokens()) {
				int s = Integer.parseInt(token.nextToken());
				//if (s == 0) {
					//break;
				//}
				if (s <= last) {
					// System.out.print(s+" ");
					sell.add(s);
				}
			}
			break;
		}

		for (int i = 0; i < have.size(); i++) {
			for (int j = 0; j < sell.size(); j++) {
				if (have.get(i).equals(sell.get(j))) {
					sell.remove(j);
				}
				else if (sell.get(j)==0){
					sell.remove(j);
				}
			}
		}

		if (sell.size()==0) {
			System.out.println("None");
		}
		Collections.sort(sell);
		int se = sell.size();
		for (int j = 0; j < se; j++) {
			System.out.print(sell.get(j));
			if (j == se - 1) {
				System.out.println("");
			} else {
				System.out.print(" ");
			}
		}
	}

}
