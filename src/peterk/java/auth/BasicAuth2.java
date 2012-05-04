package peterk.java.auth;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class BasicAuth2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 // Using the IniSecurityManagerFactory, which will use the an INI file
        // as the security file.
        Factory<org.apache.shiro.mgt.SecurityManager> factory = 
            new IniSecurityManagerFactory("auth.ini");

        // Setting up the SecurityManager...
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        Subject user = SecurityUtils.getSubject();

       System.out.println("User is authenticated:  " + user.isAuthenticated());

        UsernamePasswordToken token = 
        new UsernamePasswordToken(
            "cn=pkirkpat,ou=people,dc=lcsee,dc=wvu,dc=edu", "password");

        user.login(token);
        System.out.println("Token login");
	}// end main
}// end BasicAuth2