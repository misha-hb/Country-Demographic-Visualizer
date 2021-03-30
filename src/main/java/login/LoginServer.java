package login;

public class LoginServer {
  
  private static LoginServer instanceServer;
  
  public LoginServer getInstance() {
    if (instanceServer == null)
      instanceServer = new LoginServer();
    return instanceServer;
  }
  
  //public boolean verifyCredentials(String usr, String pwd) {
  	// open credentials database and verify username and password
  //}

}
