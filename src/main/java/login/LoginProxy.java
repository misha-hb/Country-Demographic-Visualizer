package login;

import java.io.*;

public class LoginProxy implements Login {

	private String username, password;
  	private Login RL;
  
  	public LoginProxy(String usr, String pwd) {
      username = usr;
      password = pwd;
      RL = new RealLogin();
    }
 
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
