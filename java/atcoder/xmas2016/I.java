package atcoder.xmas2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class I {
	final int _intMax = Integer.MAX_VALUE; //=2147483647>10^9
	final int _intMin = Integer.MIN_VALUE;
	final long _longMax = Long.MAX_VALUE; //=9223372036854775807L>10^18
	final long _longMin = Long.MIN_VALUE;
	static boolean bElapsed = false;
	int h;
	int w;
	int ans;

	void solve() {
		int[] ia = readNums();
		h = ia[0];
		w = ia[1];
		byte[][] map = new byte[h][w];
		ia = readNums();
		int i = ia[0];
		int s = ia[1];
		int o = ia[2];
		int tsum = 0;
		int xsum = 0;
		int ysum = 0;
		int osum = 0;
		int isum = 0;
		for (int y=0; y<h; y++) {
			String line = readLine();
			for (int x=0; x<w; x++) {
				char ch = line.charAt(x);
				if (ch == 'o') {
					map[y][x] = 1;
					tsum = (tsum + x + y) % 2;
					xsum = (xsum + x) % 2;
					ysum = (ysum + y) % 2;
					osum += (x + y) % 4;
					isum += x%2+y%2;
				}
			}
		}
		/*
		if (tsum == 1) pln("T");
		else if (xsum == 1 || ysum == 1) pln("L");
		else if ((osum - i*2 - s*2) % 4 == 0) pln("O");
		else if ((isum - i*2) % 4 == 2) pln("I");
		else pln("S");
		*/
		
		dfs(map, i, s, o);
		String tbl = "?ISOLT";
		pln(tbl.charAt(ans));
		
	}
	boolean dfs(byte[][] map, int i, int s, int o) {
		/*
		pln(i+" "+s+" "+o);
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				p(map[y][x] == 1 ? 'o' : '.');
			}
			pln("");
		}
		*/
		if (i == 0 && s == 0 && o == 0) {
			int v = find(map);
			if (v > 0 && ans == 0) ans = v;
			return ans > 0;
		}
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				if (o > 0) {
					byte[][] nmap = clone(map);
					int v = checkO(nmap, x, y);
					if (v > 0) {
						if (dfs(nmap, i, s, o-1)) return true;
					}
				}
				if (i > 0) {
					byte[][] nmap = clone(map);
					int v = checkI(nmap, x, y, 1);
					if (v > 0) {
						if (dfs(nmap, i-1, s, o)) return true;
					}
				}
				if (i > 0) {
					byte[][] nmap = clone(map);
					int v = checkI(nmap, x, y, 2);
					if (v > 0) {
						if (dfs(nmap, i-1, s, o)) return true;
					}
				}
				if (s > 0) {
					byte[][] nmap = clone(map);
					int v = checkS(nmap, x, y, 1);
					if (v > 0) {
						if (dfs(nmap, i, s-1, o)) return true;
					}
				}
				if (s > 0) {
					byte[][] nmap = clone(map);
					int v = checkS(nmap, x, y, 2);
					if (v > 0) {
						if (dfs(nmap, i, s-1, o)) return true;
					}
				}
				if (s > 0) {
					byte[][] nmap = clone(map);
					int v = checkS(nmap, x, y, 4);
					if (v > 0) {
						if (dfs(nmap, i, s-1, o)) return true;
					}
				}
				if (s > 0) {
					byte[][] nmap = clone(map);
					int v = checkS(nmap, x, y, 8);
					if (v > 0) {
						if (dfs(nmap, i, s-1, o)) return true;
					}
				}
			}
		}
		return false;
	}
	byte[][] clone(byte[][] map) {
		byte[][] nmap = new byte[h][w];
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				nmap[y][x] = map[y][x];
			}
		}
		return nmap;
	}
	int find(byte[][] map) {
		for (int y=0; y<h; y++) {
			for (int x=0; x<w; x++) {
				if (checkI(map, x, y, 3) > 0) return 1;
				if (checkS(map, x, y, 15) > 0) return 2;
				if (checkO(map, x, y) > 0) return 3;
				if (checkL(map, x, y) > 0) return 4;
				if (checkT(map, x, y) > 0) return 5;
			}
		}
		return 0;
	}
	int checkO(byte[][] map, int x, int y) {
		int ans = 0;
		if (x+1<w && y+1<h) {
			int v = map[y][x] + map[y][x+1] + map[y+1][x] + map[y+1][x+1];
			if (v == 4) {
				ans += 1;
				map[y][x] = 0;
				map[y][x+1] = 0;
				map[y+1][x] = 0;
				map[y+1][x+1] = 0;
			}
		}
		return ans;
	}
	int checkI(byte[][] map, int x, int y, int no) {
		int ans = 0;
		if (x+3<w && no % 2 == 1) {
			int v = map[y][x] + map[y][x+1] + map[y][x+2] + map[y][x+3];
			if (v == 4) {
				ans += 1;
				map[y][x] = 0;
				map[y][x+1] = 0;
				map[y][x+2] = 0;
				map[y][x+3] = 0;
			}
		}
		if (y+3<h && no / 2 == 1) {
			int v = map[y][x] + map[y+1][x] + map[y+2][x] + map[y+3][x];
			if (v == 4) {
				ans += 2;
				map[y][x] = 0;
				map[y+1][x] = 0;
				map[y+2][x] = 0;
				map[y+3][x] = 0;
			}
		}
		return ans;
	}
	int checkS(byte[][] map, int x, int y, int no) {
		int ans = 0;
		if (x+2<w && y+1<h) {
			int v = map[y][x+1] + map[y][x+2] + map[y+1][x] + map[y+1][x+1];
			if (v == 4 && no % 2 == 1) {
				ans += 1;
				map[y][x+1] = 0;
				map[y][x+2] = 0;
				map[y+1][x] = 0;
				map[y+1][x+1] = 0;
			}
			v = map[y][x] + map[y][x+1] + map[y+1][x+1] + map[y+1][x+2];
			if (v == 4 && no / 2 % 2 == 1) {
				ans += 2;
				map[y][x] = 0;
				map[y][x+1] = 0;
				map[y+1][x+1] = 0;
				map[y+1][x+2] = 0;
			}
		}
		if (x+1<w && y+2<h) {
			int v = map[y+1][x] + map[y+2][x] + map[y][x+1] + map[y+1][x+1];
			if (v == 4 && no / 4 % 2 == 1) {
				ans += 4;
				map[y+1][x] = 0;
				map[y+2][x] = 0;
				map[y][x+1] = 0;
				map[y+1][x+1] = 0;
			}
			v = map[y][x] + map[y+1][x] + map[y+1][x+1] + map[y+2][x+1];
			if (v == 4 && no / 8 == 1) {
				ans += 8;
				map[y][x] = 0;
				map[y+1][x] = 0;
				map[y+1][x+1] = 0;
				map[y+2][x+1] = 0;
			}
		}
		return ans;
	}
	int checkL(byte[][] map, int x, int y) {
		int ans = 0;
		if (x+2<w && y+1<h) {
			int v = check3x(map, x, y);
			if (v == 3) {
				if (map[y+1][x] == 1 || map[y+1][x+2] == 1) return 1;
			}
			v = check3x(map, x, y+1);
			if (v == 3) {
				if (map[y][x] == 1 || map[y][x+2] == 1) return 1;
			}
		}
		if (x+1<w && y+2<h) {
			int v = check3y(map, x, y);
			if (v == 3) {
				if (map[y][x+1] == 1 || map[y+2][x+1] == 1) return 1;
			}
			v = check3y(map, x+1, y);
			if (v == 3) {
				if (map[y][x] == 1 || map[y+2][x] == 1) return 1;
			}
		}
		return ans;
	}
	int checkT(byte[][] map, int x, int y) {
		int ans = 0;
		if (x+2<w && y+1<h) {
			int v = check3x(map, x, y) + map[y+1][x+1];
			if (v == 4) ans += 1;
			v = check3x(map, x, y+1) + map[y][x+1];
			if (v == 4) ans += 2;
		}
		if (x+1<w && y+2<h) {
			int v = check3y(map, x, y) + map[y+1][x+1];
			if (v == 4) ans += 4;
			v = check3y(map, x+1, y) + map[y+1][x];
			if (v == 4) ans += 8;
		}
		return ans;
	}
	int check3x(byte[][] map, int x, int y) {
		int ans = 0;
		for (int i=0; i<3; i++) {
			ans += map[y][x+i];
		}
		return ans;
	}
	int check3y(byte[][] map, int x, int y) {
		int ans = 0;
		for (int i=0; i<3; i++) {
			ans += map[y+i][x];
		}
		return ans;
	}
	
	long ceil2pow(long n) {
		if (n == 0) return 1;
		n--;
		n |= (n >>> 1);
		n |= (n >>> 2);
		n |= (n >>> 4);
		n |= (n >>> 8);
		n |= (n >>> 16);
		n++;
		return n;
		/*
		long pow = 1;
		while (pow < n) pow <<= 1;
		return pow;
		*/
	}
	int gcd(int a, int b) {
		if (a < b) return gcd(b, a);
		if (b == 0) return a;
		return gcd(b, a % b);
	}
	long sqrt(long n) {
		return (long)Math.sqrt(n);
	}
	long pow(long n, long p) {
		return (long)Math.pow(n, p);
	}
	long pow_mod(long n, long p, long m) {
		if (p == 0) return 1;
		else if (p % 2 == 1) return pow_mod(n, p-1, m) * n % m;
		long sum = pow_mod(n, p/2, m);
		return sum * sum % m;
	}
	int pint(String s) {
		return Integer.parseInt(s);
	}
	long plong(String s) {
		return Long.parseLong(s);
	}
	String readLine() {
		try {
			return _in.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	int readNum() {
		String line = readLine();
		return pint(line);
	}
	String[] readFlds() {
		String line = readLine();
		return line.split(" ");
	}
	int[] readNums() {
		String[] flds = readFlds();
		int[] nums = new int[flds.length];
		for (int i=0; i<flds.length; i++) {
			nums[i] = pint(flds[i]);
		}
		return nums;
	}
	void p(char c) {
		_out.print(c);
	}
	void pln(char c) {
		_out.println(c);
	}
	void p(double d) {
		_out.print(d);
	}
	void pln(double d) {
		_out.println(d);
	}
	void p(long l) {
		_out.print(l);
	}
	void pln(long l) {
		_out.println(l);
	}
	void p(String s) {
		_out.print(s);
	}
	void pln(String s) {
		_out.println(s);
	}
	static BufferedReader _in;
	static PrintWriter _out;
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		_in = new BufferedReader(new InputStreamReader(System.in));
		_out = new PrintWriter(System.out);
		new I().solve();
		_out.flush();
		long end = System.currentTimeMillis();
		if (bElapsed) {
			System.err.println((end-start) + "ms");
		}
	}
}
