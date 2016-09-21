package pgcon1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node {
	private String id;
	private int point;
	private Set<Node> next = new HashSet<Node>();
	
	public Node(String id, int point) {
		this.id = id;
		this.point = point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}
	
	public void addPrev(Node p) {
		p.next.add(this);
	}
	
	public void seek(String ids, int points) {
		if (ids.indexOf(id) >= 0) {
			return;
		}
		Q5.add(ids + id, points + point);
		for (Node node : next) {
			node.seek(ids + id, points + point);
		}
	}
}

class Point {
	private String ids;
	private int points;
	
	public Point(String ids, int points) {
		this.ids = ids;
		this.points = points;
	}
	
	public String getIds() {
		return ids;
	}
	
	public int getPoints() {
		return points;
	}
}

public class Q5 {
	static List<Point> pointList = new ArrayList<Point>();
	
	public static void add(String id, int point) {
		pointList.add(new Point(id, point));
	}

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String line = br.readLine();
    	int job = Integer.parseInt(line);
    	Map<String, Node> map = new HashMap<String, Node>();
    	for (int i=0; i<job; i++) {
    		line = br.readLine();
    		String[] cols = line.split(" ");
    		String cur = cols[0];
    		int v = Integer.parseInt(cols[1]);
    		int n = Integer.parseInt(cols[2]);
			Node node = map.get(cur);
			if (node == null) {
				node = new Node(cur, v);
				map.put(cur, node);
			} else {
				node.setPoint(v);
			}
    		if (cur.equals("A")) {
    			continue;
    		}
    		for (int j=0; j<n; j++) {
    			String prev = cols[3+j];
    			Node prevNode = map.get(prev);
    			if (prevNode == null) {
    				prevNode = new Node(prev, 0);
    				map.put(prev, prevNode);
    			}
    			node.addPrev(prevNode);
    		}
    	}
    	Node node = map.get("A");
    	node.seek("", 0);
    	//System.out.println(points);
    	String maxKey = null;
    	int maxVal = 0;
    	for (Point p : pointList) {
    		String key = p.getIds();
    		int val = p.getPoints();
    		if (val > maxVal) {
    			maxKey = key;
    			maxVal = val;
    		} else if (val == maxVal) {
    			if (key.compareTo(maxKey) < 0) {
    				maxKey = key;
    			}
    		}
    	}
    	System.out.println(maxKey);
    }
    
}
