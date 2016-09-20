package process;

public class CreateProcess {
	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("/home/hiuchida/arc.sh");
			Process p = pb.start();
			int rc = p.waitFor();
			System.out.println("rc=" + rc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
