package login;

import javax.swing.JFrame;
import main.MainUI;

/**
 * the real login server that is eventually accessed once the user is verified
 */
public class RealLogin implements Login {

	public boolean authenticate() {
		JFrame frame = MainUI.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(true);
		return true;
	}

}