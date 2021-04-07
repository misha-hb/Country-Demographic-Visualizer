package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;

import analysis.Selection;

/**
 * StartYearMenu
 * will populate the start year drop down menu
 *
 */
public class StartYearMenu extends DropDownMenu {
	/**
	 * Constructor for class
	 * @param labelString
	 * @param selection
	 */
	public StartYearMenu(String labelString, Selection selection) {

		super(labelString, selection);
		
		Vector<String> years = new Vector<String>();//populating start years in menu
		years.add("Start Year");
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}

		list = new JComboBox<String>(years);
		list.addActionListener(new SelectAction("start", selection, list)); 

	}

}
