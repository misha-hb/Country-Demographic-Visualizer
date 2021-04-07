package userinterface;

import javax.swing.JComboBox;

import analysis.Selection;

/**
 * Remove button for viewers
 */
public class RemoveButton extends Button {
		
	/**
	 * Constructor
	 * @param labelString
	 * @param selection - Selection object to remove selected viewer
	 * @param dropDownList - ViewersMenu list
	 */
	public RemoveButton(String labelString, Selection selection, JComboBox<String> dropDownList) {

		super(labelString, selection, dropDownList);

		button.addActionListener(new SelectAction("remove", selection, dropDownList));
	}
	
}
