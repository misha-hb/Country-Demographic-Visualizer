package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;

import analysis.Selection;

	/**
	 * EndYearMenu
	 * class represents the end year drop down menu, 
	 * and will populate appropriate years in the menu
	 */
public class EndYearMenu extends DropDownMenu {
	/**
	 * Constructor for class
	 * @param labelString
	 * @param selection
	 */
	public EndYearMenu(String labelString, Selection selection) {

		super(labelString, selection);
		
		Vector<String> years = new Vector<String>(); //populating the end year's menu
		years.add("End Year");
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}

		list = new JComboBox<String>(years);
		list.addActionListener(new SelectAction("end", selection, list));

	}

}
