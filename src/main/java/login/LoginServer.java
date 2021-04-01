package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import analysis.Reader;

public class LoginServer {
  
  private static LoginServer instanceServer;
  
  public static LoginServer getInstance() {
    if (instanceServer == null)
      instanceServer = new LoginServer();
    return instanceServer;
  }
  
  /**
   * @param usr is the username entered by the user
   * @param pwd is the password entered by the user
   * @return true if credentials are verified
   */
  public boolean verifyCredentials(String usr, String pwd) throws IOException {
	  	// open credentials database and verify username and password
		
		//only the password is case sensitive  
		usr = usr.toLowerCase();
		Reader file = new Reader();
		String[] fileArray = file.readFile("CredentialsDatabase.txt");
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].compareTo(usr) == 0 && fileArray[i+1].compareTo(pwd) == 0)
				return true;
		}
		return false;
	  }
		
}
