package userinterface;

import java.util.List;
import java.util.Vector;

import javax.swing.JComboBox;

import analysis.Reader;
import analysis.Selection;

/**
 * Country Menu
 *Represents the drop down menu for all of the countries on the UI
 */
public class CountryMenu extends DropDownMenu {
	
	/**
	 * Constructor for class will use reader to create country menu
	 * @param labelString
	 * @param selection
	 */
	public CountryMenu(String labelString, Selection selection) {
		
		super(labelString, selection);
		
		Vector<String> countries = new Vector<String>();
		countries.add("Select country"); 
		
		Reader reader = new Reader(); //reads the Country file to populate menu
		List<String[]> cfile = reader.readFile("CountriesFile.txt");
		for(int i = 0; i < cfile.size(); i++) {
			String country = cfile.get(i)[1];
			countries.add(country);
		}
		
		list = new JComboBox<String>(countries); //Creates a list and recieves the country selection to the list
		list.addActionListener(new SelectAction("country", selection, list));

	}
	
}
