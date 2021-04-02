package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import analysis.Selection;


public class ViewersMenu extends DropDownMenu {
		
	public ViewersMenu(String labelString, Selection selection) {
		super(labelString, selection);

		Vector<String> viewers = new Vector<String>();
		viewers.add("Pie Chart");
		viewers.add("Line Chart");
		viewers.add("Bar Chart");
		viewers.add("Scatter Chart");
		viewers.add("Report");

		list = new JComboBox<String>(viewers);

	}

}
