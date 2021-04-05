package userinterface;

import javax.swing.JButton;
import javax.swing.JComboBox;

import analysis.Selection;

/**
 * Abstract class for all buttons used in the Country Statistics Window
 */
public abstract class Button {

	protected JButton button;
	
	public Button(String labelString, Selection selection) {
		button = new JButton(labelString);
	}
	
	public Button(String labelString, Selection selection, JComboBox<String> dropDownList) {
		button = new JButton(labelString);
	}
	
	public JButton getButton() {
		return button;
	}

}
