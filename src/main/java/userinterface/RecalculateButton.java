package userinterface;

import analysis.Selection;

public class RecalculateButton extends Button {
	
	public RecalculateButton(String labelString, Selection selection) {
		
		super(labelString, selection);
		
		button.addActionListener(new SelectAction("recalculate", selection));
	
	}

}
