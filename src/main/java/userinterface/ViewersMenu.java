package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;

import analysis.Selection;

/**
 * Class will populate the menu that hold all the viewer names
 */
public class ViewersMenu extends DropDownMenu {
	/**
	 * Constructor for class
	 * @param labelString
	 * @param selection
	 */
	public ViewersMenu(String labelString, Selection selection) {
		super(labelString, selection);

		Vector<String> viewers = new Vector<String>(); //Will add each analysis name into the menu
		viewers.add("Select viewer");
		viewers.add("Pie Chart");
		viewers.add("Line Chart");
		viewers.add("Bar Chart");
		viewers.add("Scatter Chart");
		viewers.add("Time Series Chart");
		viewers.add("Report");

		list = new JComboBox<String>(viewers);//inserts list of viewers into box for menu

	}

}
