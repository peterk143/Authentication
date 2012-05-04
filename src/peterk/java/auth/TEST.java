package peterk.java.auth;

public class TEST {

	/**
	 * main test class
	 */
	public static void main(String[] args) {
		new HttpBasicAuth().authenticate("peterk", "htpasswd", "http://lcsee.wvu.edu/~pkirkpat");
	
		new HttpsBasicAuth().authenticate("peterk", "wrong", "https://nagios001.lcsee.wvu.edu/nagios3");
	}
}
