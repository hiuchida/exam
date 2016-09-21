package pgcon1.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q5 {

	public static void main(String[] args) throws IOException {

		ArrayList<String[]> jobs = new ArrayList<String[]>();
		ArrayList<String> pass = new ArrayList<String>();


		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		StringTokenizer token = new StringTokenizer(line, " ");

		int number = Integer.parseInt(token.nextToken());
		String[][] job = new String[number][];

		String[] jj = new String[token.countTokens()];

		int count = 0;

		while ((line = br.readLine()) != null) {



			while (token.hasMoreTokens()) {
				for (int i = 0; i < jj.length; i++) {
					jj[i] = token.nextToken();
				}
			}

			jobs.add(jj);
			for (int i = 0; i < jobs.size(); i++) {

				job[i] = jobs.get(i);
			}

			count++;
			if(count>=number){
				break;
			}
		}
		pass.add("A");
		for (int i = 0; i < job.length; i++) {
			for (int j = i+1; j < job.length; j++) {
				if(job[i][0].contains(job[j][0])){
					pass.add(job[j][0]);
				}


			}


		}
	}
}
