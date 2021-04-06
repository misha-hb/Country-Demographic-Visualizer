package userinterface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComboBox;

import analysis.AnalysisServer;
import analysis.Selection;

/**
 * Responds to user actions from user interface components
 */
public class SelectAction implements ActionListener {

	private Selection selection;
	private JComboBox<String> list;
	private String type;

	/**
	 * Constructor for action not linked to a drop-down menu 
	 * @param type - type of action
	 * @param selection - Selection object used for action
	 */
	public SelectAction(String type, Selection selection) {
		this.type = type;
		this.selection = selection;
	}
	
	/**
	 * Constructor for action linked to a drop-down menu
	 * @param type - type of action
	 * @param selection - Selection object used for action
	 * @param list - drop-down menu to retrieve selection from
	 */
	public SelectAction(String type, Selection selection, JComboBox<String> list) {
		this.type = type;
		this.selection = selection;
		this.list = list;
	}
	
	/**
	 * Invoked from user click on a button or drop-down menu
	 * Modifies or uses Selection object
	 */
	public void actionPerformed(ActionEvent e) {
		try {
			switch (type) {
			case "add" :			// Addition of viewer
				selection.addViewer(String.valueOf(list.getSelectedItem()));
				break;
			case "analysis" :		// Selection of analysis
				selection.setAnalysisType(String.valueOf(list.getSelectedItem()));
				break;
			case "country" :		// Selection of country
				selection.setCountry(String.valueOf(list.getSelectedItem()));
				break;
			case "end" :			// Selection of end year
				selection.setEndYear(String.valueOf(list.getSelectedItem()));
				break;
			case "remove" :			// Removal of viewer
				selection.removeViewer(String.valueOf(list.getSelectedItem()));
				break;
			case "recalculate" :	// Invocation of analysis
				AnalysisServer server = new AnalysisServer();
				server.doAnalysis(selection);
				break;
			case "start" :			// Selection of start year
				selection.setStartYear(String.valueOf(list.getSelectedItem()));
				break;
			}
		}
		catch (IOException exception) {}
	}

}
