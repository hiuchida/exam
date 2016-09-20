package http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendFile {
	public static void main(String[] args) {
		BufferedOutputStream os = null;
		BufferedInputStream is = null;
		BufferedReader r = null;
		try {
			URL url = new URL("http://localhost:8080/upload.jsp");
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("x-filename", "arc.log");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			os = new BufferedOutputStream(conn.getOutputStream());
			is = new BufferedInputStream(new FileInputStream("/home/hiuchida/workspace/procon/arc.log"));
			while (true) {
				int dat = is.read();
				if (dat < 0) break;
				os.write(dat);
			}
			is.close();
			is = null;
			os.close();
			os = null;
			r = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			while (true) {
				String line = r.readLine();
				if (line == null) break;
				System.out.println(line);
			}
			r.close();
			r = null;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (is != null)
				try {
					is.close();
				} catch (IOException e) {}
			if (os != null)
				try {
					os.close();
				} catch (IOException e) {}
			if (r != null)
				try {
					r.close();
				} catch (IOException e) {}
		}
	}
}
