package login;

public class LoginServer {
  
  private static LoginServer instanceServer;
  
  public static LoginServer getInstance() {
    if (instanceServer == null)
      instanceServer = new LoginServer();
    return instanceServer;
  }
  
  public boolean verifyCredentials(String usr, String pwd) {
	if (true)	// open database and verify
		return true;
	return false;
  }

}
