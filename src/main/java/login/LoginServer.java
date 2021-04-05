package login;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import analysis.Reader;

/**
 * Accesses the credentials database to determine whether the user
 * can gain access with the username and password provided
 */
public class LoginServer {
  
  private static LoginServer instanceServer;
  
  //singleton design pattern ensuring that only one user is logged in the entire time the system is
  //being used
  public static LoginServer getInstance() {
    if (instanceServer == null)
      instanceServer = new LoginServer();
    return instanceServer;
  }
  
  /**
   * checks whether the username and password entered is valid and inside the credentials database text file
   * @param usr username entered by user
   * @param pwd password entered by user
   * @return true if user credentials are validated
   * @throws IOException
   */
  public boolean verifyCredentials(String usr, String pwd) throws IOException {
  	// open credentials database and verify username and password
	
	//only the password is case sensitive  
	usr = usr.toLowerCase();  
	Reader reader = new Reader();
	List<String[]> fileArray = reader.readFile("CredentialsDatabase.txt");
	for (int i = 0; i < fileArray.size(); i++) {
		if (fileArray.get(i)[0].compareTo(usr) == 0 && fileArray.get(i)[1].compareTo(pwd) == 0)
			return true;
	}
	return false;
  }
}
