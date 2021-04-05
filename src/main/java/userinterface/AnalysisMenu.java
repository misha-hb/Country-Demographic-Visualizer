package userinterface;

import java.util.Vector;

import javax.swing.JComboBox;

import analysis.Selection;

public class AnalysisMenu extends DropDownMenu {
 
	public AnalysisMenu(String labelString, Selection selection) {

		super(labelString, selection);
		
		Vector<String> methodsNames = new Vector<String>();
		methodsNames.add("Select analysis");
		methodsNames.add("Average Forest Area");
		methodsNames.add("Average Government Expenditure on Education");
		methodsNames.add("CO2 Emissions vs Energy Use vs PM2.5 Air Pollution");
		methodsNames.add("Current Health Expenditure per Capita vs Mortality Rate");
		methodsNames.add("PM2.5 Air Pollution vs Forest Area");
		methodsNames.add("Ratio of CO2 Emissions and GPD per Capita");
		methodsNames.add("Ratio of Government Expenditure on Education vs Current Health Expenditure");
		methodsNames.add("Hospital Beds and Current Health Expenditure");

		list = new JComboBox<String>(methodsNames);
		
		list.addActionListener(new SelectAction("analysis", selection, list));
		
	}

}
