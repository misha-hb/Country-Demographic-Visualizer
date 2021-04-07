package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import analysis.Result;
import analysis.Subject;


/**
 * Pie Chart class that can be displayed on the Main UI
 */
public class PieChart implements Viewer {
	private Result result;

	/**
	 * Constructor
	 * @param subject The result object that will have this pie chart attached to it
	 */
	public PieChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}
	
	/**
	 * Update method checks whether the passed Subject object is equal to the result instance variable and then does the drawViewer method if they are the same.
	 */
	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	/**
	 * Method for creating and displaying the Pie Chart on the main UI.
	 */
	public void drawViewer() {
		
		double value = this.result.getAverage();
		
		DefaultPieDataset dataset = new DefaultPieDataset(); 
		
		//Pie Chart if analysis type is Average Forest Area
		if (result.getName().contentEquals("Average Forest area (% of land area)")) {

			dataset.setValue("Forest Area", value);
			dataset.setValue("Non-Forest Area", 100 - value);
		//Pie Chart if analysis type is Average Government Expenditure on education
		}else if (result.getName().contentEquals("Average of Government expenditure on education, total (% of GDP)")) {
		
			dataset.setValue("Government Expenditure on Education", value);
			dataset.setValue("Government Expenditure on non-education", 100 - value);
		}
		
		JFreeChart pieChart = ChartFactory.createPieChart(result.getName(), dataset, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		
		MainUI.getPanel().add(chartPanel);
	}
}