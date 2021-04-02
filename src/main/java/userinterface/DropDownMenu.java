package userinterface;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import analysis.Selection;

public abstract class DropDownMenu {

	private JLabel label;
	protected JComboBox<String> list;
	
	public DropDownMenu(String labelString, Selection selection) {
		label = new JLabel(labelString);
	}

	public JLabel getLabel() {
		return label;
	}
	
	public JComboBox<String> getList() {
		return list;
	}

}
