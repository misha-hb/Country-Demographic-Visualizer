package userinterface;


import javax.swing.JButton;

import analysis.*;

public class RecalculateButton extends Button {
	
	public RecalculateButton(String labelString, Selection selection) {
		
		super(labelString, selection);
		
		button.addActionListener(new SelectAction("recalculate", selection));
	
	}

}
