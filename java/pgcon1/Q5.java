package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Q5 {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	int job = Integer.parseInt(line);
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	for (int i=0; i<job; i++) {
    		line = br.readLine();
    		String[] cols = line.split(" ");
    		String cur = cols[0];
    		int v = Integer.parseInt(cols[1]);
    		int n = Integer.parseInt(cols[2]);
    		if (cur.equals("A")) {
    			map.put(cur, v);
    			continue;
    		}
    		for (int j=0; j<n; j++) {
    			String prev = cols[3+j];
    			String srch = search(map, prev);
    			int v2 = map.get(srch);
    			map.put(srch+cur, v+v2);
    		}
    	}
    	//System.out.println(map);
    	String maxKey = null;
    	int maxVal = 0;
    	for (String key : map.keySet()) {
    		int v = map.get(key);
    		if (v > maxVal) {
    			maxKey = key;
    			maxVal = v;
    		} else if (v == maxVal) {
    			if (key.compareTo(maxKey) < 0) {
    				maxKey = key;
    			}
    		}
    	}
    	System.out.println(maxKey);
    }
    
    private static String search(Map<String, Integer> map, String prev) {
    	for (String key : map.keySet()) {
    		if (key.endsWith(prev)) {
    			return key;
    		}
    	}
    	System.out.println(map);
    	throw new RuntimeException("Not found " + prev);
    }

}
