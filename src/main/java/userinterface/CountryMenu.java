package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysis.Selection;

public class CountryMenu extends DropDownMenu {
	
	public CountryMenu(String labelString, Selection selection) {
		
		super(labelString, selection);
		
		Vector<String> countries = new Vector<String>();
		countries.add("USA");
		countries.add("Canada");
		countries.add("France");
		countries.add("China");
		countries.add("Brazil");
		countries.sort(null);
		
		list = new JComboBox<String>(countries);
		list.addActionListener(new SelectAction("country", selection, list));

	}
	
}
