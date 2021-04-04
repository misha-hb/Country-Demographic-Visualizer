package main;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import analysis.Data;
import analysis.Result;
import analysis.Subject;

public class PieChart implements Viewer {
	private Result result;

	public PieChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		
		double value = this.result.getAverage();
		
		DefaultPieDataset dataset = new DefaultPieDataset(); 
		
		if (result.getName().contentEquals("Average Forest Area")) {

			dataset.setValue("Forest Area", value);
			dataset.setValue("Non-Forest Area", 100 - value);
			
		}else if (result.getName().contentEquals("Average Government Expenditure on Education")) {
		
			dataset.setValue("Government Expenditure on Education", value);
			dataset.setValue("Government Expenditure on non-education", 100 - value);
		}
		
		JFreeChart pieChart = ChartFactory.createPieChart(result.getName(), dataset, true, true, false);
		
		ChartPanel chartPanel = new ChartPanel(pieChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		
		MainUI.getPanel().add(chartPanel);
		//JFrame frame = MainUI.getInstance();
		//frame.setSize(900, 600);
		//frame.pack();
		//frame.setVisible(true);
	}
}