package login;

import java.io.BufferedReader;
import java.io.FileReader;

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
  public boolean verifyCredentials(String usr, String pwd) {
	  	// open credentials database and verify username and password
		
		//only the password is case sensitive  
		usr = usr.toLowerCase();  
		String[] fileArray = readFile("credentialsdatabase.txt");
		for (int i = 0; i < fileArray.length; i++) {
			if (fileArray[i].compareTo(usr) == 0 && fileArray[i+1].compareTo(pwd) == 0)
				return true;
		}
		return false;
  }
		
  
  /**
   * @param file to be read (country exclusion file / credentials database file)
   * @return array with contents of country exclusion file/credentials database read
   */
  public String[] readFile(String file) {
	  String [] databaseArray = new String [1];
	  try {  
		  	BufferedReader reader = new BufferedReader(new FileReader(file));
		  	String readLine = reader.readLine();
	    	while (readLine != null) {
	    		databaseArray = readLine.split(";");
	    		readLine = reader.readLine();
	    	}
	    	reader.close();
	    }
		finally {
			return databaseArray;
		}
  }

}
