package userinterface;

import javax.swing.JButton;
import javax.swing.JComboBox;

import analysis.Selection;

/**
 * Abstract class for all buttons used in the Country Statistics Window
 */
public abstract class Button {

	protected JButton button;
	
	/**
	 * Constructor for buttons not linked to a drop-down menu
	 * @param labelString - label for the button
	 * @param selection - Selection object to store selections
	 */
	public Button(String labelString, Selection selection) {
		button = new JButton(labelString);
	}
	
	/**
	 * Constructor for buttons linked to a drop-down menu
	 * @param labelString - label for the button
	 * @param selection - Selection object to store selections
	 * @param dropDownList - drop-down menu to retrieve selection from
	 */
	public Button(String labelString, Selection selection, JComboBox<String> dropDownList) {
		button = new JButton(labelString);
	}
	
	/**
	 * @return JButton of this object
	 */
	public JButton getButton() {
		return button;
	}

}
