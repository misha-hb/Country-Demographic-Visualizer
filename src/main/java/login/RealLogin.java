package login;

import javax.swing.JFrame;
import main.MainUI;

/**
 * Displays main user interface
 * Assessed when user credentials are verified
 * the real login server that is eventually accessed once the user is verified
 */
public class RealLogin implements Login {

	/**
	 * Displays main user interface
	 */
	public boolean authenticate() {
		JFrame frame = MainUI.getInstance();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.pack();
		frame.setVisible(true);
		return true;
	}
	
}
