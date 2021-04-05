package userinterface;

import javax.swing.JComboBox;

import analysis.Selection;

/**
 * Add button for viewers
 * 
 *
 */
public class AddButton extends Button {
		
	public AddButton(String labelString, Selection selection, JComboBox<String> dropDownList) {

		super(labelString, selection, dropDownList);

		button.addActionListener(new SelectAction("add", selection, dropDownList));
	}
	
}
