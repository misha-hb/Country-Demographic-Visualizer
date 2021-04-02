package userinterface;

import javax.swing.JButton;
import javax.swing.JComboBox;

import analysis.Selection;

public class RemoveButton extends Button {
		
	public RemoveButton(String labelString, Selection selection, JComboBox<String> dropDownList) {

		super(labelString, selection, dropDownList);

		button.addActionListener(new SelectAction("remove", selection, dropDownList));
	}
	
}
