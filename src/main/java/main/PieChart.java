package main;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import analysis.Data;
import analysis.Result;
import analysis.Subject;

public class PieChart implements Viewer {
	private Result result;

	private PieChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		double value = result.getAverage();
		Data data = result.getData().get(0);
		
		DefaultPieDataset dataset = new DefaultPieDataset();

		
		if (data.getType().contentEquals("SE.XPD.TOTL.GD.ZS")) {
			
			 dataset.setValue("Government Expenditure", value);
			 dataset.setValue("Non-Government Expenditure", (100 - value));
			  
			 JFreeChart pieChart = ChartFactory.createPieChart("Average Government Expenditure",
			 dataset, true, true, false);
			 
			 ChartPanel chartPanel = new ChartPanel(pieChart);
			 chartPanel.setPreferredSize(new Dimension(400, 300));
			 chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
			 chartPanel.setBackground(Color.white);
		}
	}
}
