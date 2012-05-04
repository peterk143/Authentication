package peterk.java.auth;

import java.security.KeyStore;
import java.security.KeyStoreException;

public class certsNThings {
	
	public void doStuff() {
		char[] passwd = {'a','b','c','d','e'};
		
		try {
			KeyStore keys = KeyStore.getInstance(KeyStore.getDefaultType());
		} catch (KeyStoreException e) {
			System.out.println("keystore error");
			e.printStackTrace();
		}// end try/catch
	}// end doStuff()
}// end certsNThings