package userinterface;

import javax.swing.JButton;
import javax.swing.JComboBox;

import analysis.Selection;

public class AddButton extends Button {
		
	public AddButton(String labelString, Selection selection, JComboBox<String> dropDownList) {

		super(labelString, selection, dropDownList);

		button.addActionListener(new SelectAction("add", selection, dropDownList));
	}
	
}
