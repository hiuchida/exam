package pgcon3;

public class Combination {
	public static void combination(String q, String ans, int k){
        // Base Case
		if(ans.length() == k) {
            System.out.println(ans);
        }
        // General Case
        else {
            while (q.length() > 0) {
            	combination(q.substring(1), ans + q.charAt(0), k);
            	q = q.substring(1);
            }
        }
    }
    public static void main(String[] args) {
    	combination("abcd", "", 2);
    }
}
