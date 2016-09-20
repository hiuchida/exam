package thread;

import java.util.ArrayList;
import java.util.List;

public class CreateThread {
	public static void main(String[] args) {
		List<Thread> list = new ArrayList<Thread>();
		try {
			for (int i=1; true; i++) {
				Thread t = new Thread() {
					public void run() {
						while (true) {
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {}
						}
					}
				};
				t.start();
				list.add(t);
				System.out.println(i);
			}
		} catch (Error e) {
			e.printStackTrace();
		}
		for (Thread t : list) {
			t.stop();
		}
	}
}
