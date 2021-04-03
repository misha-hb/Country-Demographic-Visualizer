package userinterface;

import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JComboBox;

import analysis.AnalysisServer;
import analysis.Selection;

public class SelectAction implements java.awt.event.ActionListener {

	private Selection selection;
	private JComboBox<String> list;
	private String type;

	public SelectAction(String type, Selection selection) {
		this.type = type;
		this.selection = selection;
	}
	
	public SelectAction(String type, Selection selection, JComboBox<String> list) {
		this.type = type;
		this.selection = selection;
		this.list = list;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			switch (type) {
			case "add" :
				selection.addViewer(String.valueOf(list.getSelectedItem()));
				break;
			case "analysis" :
				selection.setAnalysisType(String.valueOf(list.getSelectedItem()));
				break;
			case "country" :
				selection.setCountry(String.valueOf(list.getSelectedItem()));
				break;
			case "end" :
				selection.setEndYear(String.valueOf(list.getSelectedItem()));
				break;
			case "remove" :
				selection.removeViewer(String.valueOf(list.getSelectedItem()));
				break;
			case "recalculate" :
				AnalysisServer server = new AnalysisServer();
				server.doAnalysis(selection);
				break;
			case "start" :
				selection.setStartYear(String.valueOf(list.getSelectedItem()));
				break;
			}
		}
		catch (IOException exception) {}
	}

}
