package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysis.Selection;

public class EndYearMenu extends DropDownMenu {
	
	public EndYearMenu(String labelString, Selection selection) {

		super(labelString, selection);
		
		Vector<String> years = new Vector<String>();
		years.add("End Year");
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}

		list = new JComboBox<String>(years);
		list.addActionListener(new SelectAction("end", selection, list));

	}

}
