package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysis.Selection;

public class StartYearMenu extends DropDownMenu {
	
	public StartYearMenu(String labelString, Selection selection) {
		super(labelString, selection);
		
		Vector<String> years = new Vector<String>();
		for (int i = 2021; i >= 2010; i--) {
			years.add("" + i);
		}

		list = new JComboBox<String>(years);
		list.addActionListener(new SelectAction("start", selection, list));

	}

}
