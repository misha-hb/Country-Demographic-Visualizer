package login;

import java.io.*;

/**
 * This class ensures that the user is only able to access the system if
 * they have the proper credentials 
 */
public class LoginProxy implements Login {

	private String username, password;
  	private Login RL;
  
  	public LoginProxy(String usr, String pwd) {
      username = usr;
      password = pwd;
      RL = new RealLogin();
    }
  
  	/**
  	 * This method authenticates the username and password entered by the user
  	 * returns true if the user is verified
  	 */
  	public boolean authenticate() {
 
      LoginServer server = LoginServer.getInstance();
      try {
    	  if (server.verifyCredentials(username, password)) {
    		  RL.authenticate();
    		  return true;}
      }
      catch (IOException e) {}
      return false;
    }
}
