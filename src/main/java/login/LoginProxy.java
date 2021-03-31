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
<<<<<<< HEAD
      if (server.verifyCredentials(username, password))
        RL.authenticate();
        return true;
=======
      try {
    	  if (server.verifyCredentials(username, password)) {
    		  RL.authenticate();
    		  return true;}
      }
      catch (IOException e) {}
>>>>>>> branch 'master' of https://repo.csd.uwo.ca/scm/compsci2212_w2021/group4.git
      return false;
    }

}
