package junit;

public class Util {
	public static boolean check(String strDays) {
		try {
			int days = Integer.parseInt(strDays);
			if (0 < days && days < 15) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
}
