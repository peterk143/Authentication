package peterk.java.auth;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.shiro.codec.Base64;


public class testAuth {

    public static void main(String[] args) {

        try {
        	URL url = new URL("http://lcsee.wvu.edu/~pkirkpat");
        	String encoding = Base64.encodeToString("peterk:htpasswd".getBytes());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", "Basic " + encoding);

            InputStream content;
            
            System.out.println("serveResponse: " + "[" + connection.getResponseCode() + 
            		"/" + connection.getResponseMessage() + "]");
            
            if(connection.getResponseCode() >= 400) {
                content = connection.getInputStream();
            } else {
                content = connection.getErrorStream();
                System.out.println("errorStream");
            }
            
            BufferedReader bReader = new BufferedReader(new InputStreamReader(content));
            String line;
            while((line = bReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch(Exception e) {
            System.out.println("shitz");
        	e.printStackTrace();
        }
    }
}
