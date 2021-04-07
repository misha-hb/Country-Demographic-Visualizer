package userinterface;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import analysis.Selection;
/**
 * DropDownMenu 
 * Abstract class for all of the menu classes used in the UI
 *
 */
public abstract class DropDownMenu {

	private JLabel label;
	protected JComboBox<String> list;
	
	/**
	 * Constructor creates a drop down menu
	 * @param labelString
	 * @param selection
	 */
	public DropDownMenu(String labelString, Selection selection) {
		label = new JLabel(labelString);
	}

	public JLabel getLabel() { //will return the menu label
		return label;
	}
	
	public JComboBox<String> getList() { //returns list component
		return list;
	}

}
