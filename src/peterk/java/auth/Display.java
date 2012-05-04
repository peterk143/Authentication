package peterk.java.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Display {

	public void displayBuffer(InputStream iStream) {
		String line = null;
		BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
		
		try {
			while((line = bReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Display IOException");
			e.printStackTrace();
		}
	}
}
