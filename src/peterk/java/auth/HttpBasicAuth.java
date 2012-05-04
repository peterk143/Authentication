package peterk.java.auth;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.shiro.codec.Base64;

public class HttpBasicAuth {

	public void authenticate(String uname, String paswd, String uri) {
		String encoded = Base64.encodeToString((uname + ":" + paswd).getBytes());
		
		try {
			URL url = new URL(uri);
			try {
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Authorization", "Basic " + encoded);
				System.out.println("response " + conn.getResponseCode());
				new Display().displayBuffer(conn.getInputStream());
			} catch (IOException e) {
				System.out.println("HttpBasicAuth IOException");
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			System.out.println("HttpBasicAuth MalformedURLException");
			e.printStackTrace();
		}
	}
}
