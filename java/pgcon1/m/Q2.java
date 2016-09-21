package pgcon1.m;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q2 {

	public static void main(String[] args) throws IOException {

		ArrayList<String> oxlist = new ArrayList<String>();
		String[] ox;
		String o = "o";
		String x = "x";
		String h = "-";
		int oc = 0;
		int xc = 0;

		BufferedReader br = null;
		String line = "";

		br = new BufferedReader(new InputStreamReader(System.in));

		a:while (line != null) {

			while (oxlist.size() < 9) {

				line = br.readLine();
				ox = line.split("");

				for (int i = 0; i < ox.length; i++) {
					if (ox[i].equals(o)) {
						oc++;
						oxlist.add(ox[i]);
					} else if (ox[i].equals(x)) {
						xc++;
						oxlist.add(ox[i]);
					} else {
						oxlist.add(ox[i]);
					}
				}
			}

			if (oxlist.size() >= 9) {
				if (oxlist.contains(h)) {
					if (oc > xc) {
						if (((oxlist.get(0).equals(o)) && (oxlist.get(1).equals(o)) && (oxlist.get(2).equals(o)))
								|| ((oxlist.get(0).equals(o)) && (oxlist.get(3).equals(o)) && (oxlist.get(6).equals(o)))
								|| ((oxlist.get(0).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(8).equals(o)))
								|| ((oxlist.get(1).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(7).equals(o)))
								|| ((oxlist.get(2).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(6).equals(o)))
								|| ((oxlist.get(2).equals(o)) && (oxlist.get(5).equals(o)) && (oxlist.get(8).equals(o)))
								|| ((oxlist.get(3).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(5).equals(o)))
								|| ((oxlist.get(6).equals(o)) && (oxlist.get(7).equals(o))
										&& (oxlist.get(8).equals(o)))) {
							System.out.println("WIN");
							break;
						} else if (((oxlist.get(0).equals(x)) && (oxlist.get(1).equals(x)) && (oxlist.get(2).equals(x)))
								|| ((oxlist.get(0).equals(x)) && (oxlist.get(3).equals(x)) && (oxlist.get(6).equals(x)))
								|| ((oxlist.get(0).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(8).equals(x)))
								|| ((oxlist.get(1).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(7).equals(x)))
								|| ((oxlist.get(2).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(6).equals(x)))
								|| ((oxlist.get(2).equals(x)) && (oxlist.get(5).equals(x)) && (oxlist.get(8).equals(x)))
								|| ((oxlist.get(3).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(5).equals(x)))
								|| ((oxlist.get(6).equals(x)) && (oxlist.get(7).equals(x))
										&& (oxlist.get(8).equals(x)))) {
							System.out.println("LOSE");
							break;

						} else {
							System.out.println("NG");
							break;

						}
					} else {
						if (((oxlist.get(0).equals(o)) && (oxlist.get(1).equals(o)) && (oxlist.get(2).equals(o)))
								|| ((oxlist.get(0).equals(o)) && (oxlist.get(3).equals(o)) && (oxlist.get(6).equals(o)))
								|| ((oxlist.get(0).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(8).equals(o)))
								|| ((oxlist.get(1).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(7).equals(o)))
								|| ((oxlist.get(2).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(6).equals(o)))
								|| ((oxlist.get(2).equals(o)) && (oxlist.get(5).equals(o)) && (oxlist.get(8).equals(o)))
								|| ((oxlist.get(3).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(5).equals(o)))
								|| ((oxlist.get(6).equals(o)) && (oxlist.get(7).equals(o))
										&& (oxlist.get(8).equals(o)))) {
							System.out.println("WIN");
							break;
						} else if (((oxlist.get(0).equals(x)) && (oxlist.get(1).equals(x)) && (oxlist.get(2).equals(x)))
								|| ((oxlist.get(0).equals(x)) && (oxlist.get(3).equals(x)) && (oxlist.get(6).equals(x)))
								|| ((oxlist.get(0).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(8).equals(x)))
								|| ((oxlist.get(1).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(7).equals(x)))
								|| ((oxlist.get(2).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(6).equals(x)))
								|| ((oxlist.get(2).equals(x)) && (oxlist.get(5).equals(x)) && (oxlist.get(8).equals(x)))
								|| ((oxlist.get(3).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(5).equals(x)))
								|| ((oxlist.get(6).equals(x)) && (oxlist.get(7).equals(x))
										&& (oxlist.get(8).equals(x)))) {
							System.out.println("LOSE");
							break;

						} else {

							for (int i = 0; i < oxlist.size(); i++) {
								if (oxlist.get(i).equals(h)) {
									oxlist.set(i, o);
									if (((oxlist.get(0).equals(o)) && (oxlist.get(1).equals(o))
											&& (oxlist.get(2).equals(o)))
											|| ((oxlist.get(0).equals(o)) && (oxlist.get(3).equals(o))
													&& (oxlist.get(6).equals(o)))
											|| ((oxlist.get(0).equals(o)) && (oxlist.get(4).equals(o))
													&& (oxlist.get(8).equals(o)))
											|| ((oxlist.get(1).equals(o)) && (oxlist.get(4).equals(o))
													&& (oxlist.get(7).equals(o)))
											|| ((oxlist.get(2).equals(o)) && (oxlist.get(4).equals(o))
													&& (oxlist.get(6).equals(o)))
											|| ((oxlist.get(2).equals(o)) && (oxlist.get(5).equals(o))
													&& (oxlist.get(8).equals(o)))
											|| ((oxlist.get(3).equals(o)) && (oxlist.get(4).equals(o))
													&& (oxlist.get(5).equals(o)))
											|| ((oxlist.get(6).equals(o)) && (oxlist.get(7).equals(o))
													&& (oxlist.get(8).equals(o)))) {
										System.out.println("OK");
										break a;
									} else {
										oxlist.set(i, h);
										continue;
									}
								} else {
									continue;
								}
							}
							System.out.println("NO");
							break;
						}
					}

				} else {
					if (((oxlist.get(0).equals(o)) && (oxlist.get(1).equals(o)) && (oxlist.get(2).equals(o)))
							|| ((oxlist.get(0).equals(o)) && (oxlist.get(3).equals(o)) && (oxlist.get(6).equals(o)))
							|| ((oxlist.get(0).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(8).equals(o)))
							|| ((oxlist.get(1).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(7).equals(o)))
							|| ((oxlist.get(2).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(6).equals(o)))
							|| ((oxlist.get(2).equals(o)) && (oxlist.get(5).equals(o)) && (oxlist.get(8).equals(o)))
							|| ((oxlist.get(3).equals(o)) && (oxlist.get(4).equals(o)) && (oxlist.get(5).equals(o)))
							|| ((oxlist.get(6).equals(o)) && (oxlist.get(7).equals(o)) && (oxlist.get(8).equals(o)))) {
						System.out.println("WIN");
						break;
					} else if (((oxlist.get(0).equals(x)) && (oxlist.get(1).equals(x)) && (oxlist.get(2).equals(x)))
							|| ((oxlist.get(0).equals(x)) && (oxlist.get(3).equals(x)) && (oxlist.get(6).equals(x)))
							|| ((oxlist.get(0).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(8).equals(x)))
							|| ((oxlist.get(1).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(7).equals(x)))
							|| ((oxlist.get(2).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(6).equals(x)))
							|| ((oxlist.get(2).equals(x)) && (oxlist.get(5).equals(x)) && (oxlist.get(8).equals(x)))
							|| ((oxlist.get(3).equals(x)) && (oxlist.get(4).equals(x)) && (oxlist.get(5).equals(x)))
							|| ((oxlist.get(6).equals(x)) && (oxlist.get(7).equals(x)) && (oxlist.get(8).equals(x)))) {
						System.out.println("LOSE");
						break;
					} else {
						System.out.println("FIN");
						break;
					}
				}
			}
		}
	}
}