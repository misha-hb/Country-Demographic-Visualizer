package login;

import javax.swing.JFrame;
import main.MainUI;


public class RealLogin implements Login {

	public boolean authenticate() {
		JFrame frame = MainUI.getInstance();
		frame.setSize(900, 600);
		frame.pack();
		frame.setVisible(true);
		return true;
	}

}
