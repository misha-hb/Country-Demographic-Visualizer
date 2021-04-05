package userinterface;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysis.CountryDictionary;
import analysis.Reader;
import analysis.Selection;

public class CountryMenu extends DropDownMenu {
	
	public CountryMenu(String labelString, Selection selection) {
		
		super(labelString, selection);
		
		Vector<String> countries = new Vector<String>();
		countries.add("Select country");
		
		Reader reader = new Reader();
		List<String[]> cfile = reader.readFile("CountriesFile.txt");
		for(int i = 0; i < cfile.size(); i++) {
			String country = cfile.get(i)[1];
			countries.add(country);
		}
		
		// Some countries are formatted so that they have " at the front, not sure if we should fix the file 

		//countries.add("USA");
		//countries.add("Canada");
		//countries.add("France");
		//countries.add("China");
		//countries.add("Brazil");
		//countries.sort(null);
		
		list = new JComboBox<String>(countries);
		list.addActionListener(new SelectAction("country", selection, list));

	}
	
}
