package userinterface;

import analysis.Selection;

public class RemoveButton extends Button {
	
	public void triggerRemove(Selection userSelection, String viewerSelection) {
		userSelection.addViewer(viewerSelection);
	}

}
