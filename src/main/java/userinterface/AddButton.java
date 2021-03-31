package userinterface;

import analysis.Selection;

public class AddButton extends Button {

	public void triggerAdd(Selection userSelection, String viewerSelection) {
		userSelection.addViewer(viewerSelection);
	}
}
