package main;

import analysis.Data;
import analysis.Result;
import analysis.Subject;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class BarChart implements Viewer {
	private Result result;

	public BarChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		
		List<Data> dataList = result.getData(); //List of data Series required
		int series = dataList.size(); //To determine how many series in the graph
		DefaultCategoryDataset datasetOne = new DefaultCategoryDataset(); //Creating a data set for first series
		CategoryPlot plot = new CategoryPlot(); 
		
		/*
		 * Determining what the y-axis label will be
		 */
		String label = "";
		if(result.getName().equals("Air Pollution vs Forest Area")) {
			label = "Mean exposure / % of Area";
		} else if (result.getName().equals("CO2 Emissions vs Energy Use vs Air Pollution")) {
			label = "metric tones";
		} else if(result.getName().equals("Government Expenditure on Education vs Current Health Expenditure")) {
			label = "% of GPD";
		} else if (result.getName().equals("Current Health Expenditure per Capita vs Mortality Rate")) {
			label = "US$";
		} else if (result.getName().equals("Ratio of Hospital Beds and Current Health Expenditure")) {
			label = "US$";
		}else if(result.getName().equals("Ratio of CO2 Emissions and GPD per Capita")) {
			label = "US$";
		}
			
		
		
		/*
		 * Creating a Bar chart for data with at least one series
		 */
		Iterator<Data> DataIterator = dataList.iterator();
		Data firstData = DataIterator.next();
	
		for (int i = (firstData.getYears().size()) - 1; i >= 0; i--) {
			datasetOne.setValue((firstData.getValues()).get(i), firstData.getType(), Integer.toString((firstData.getYears()).get(i)));
		}
		
		BarRenderer barrenderer1 = new BarRenderer(); 
		plot.setDataset(0, datasetOne); 
		plot.setRenderer(0, barrenderer1); 
		
		CategoryAxis domainAxis = new CategoryAxis("Year"); 
		
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.setRangeAxis(1, new NumberAxis(label));
		plot.mapDatasetToRangeAxis(0, 0);// 1st data set to 1st y-axis
		
		
		
		/*
		 * Creating a bar chart for data with at least two Series
		 * The second series will be on the same "plane" as the first series
		 */
		if (series > 1) {
			Data secondData = DataIterator.next();
			for (int i = (secondData.getYears().size()) - 1; i >= 0; i--) {
				datasetOne.setValue((secondData.getValues()).get(i), secondData.getType(), Integer.toString((secondData.getYears()).get(i)));
			}
			 plot.setRenderer(1, barrenderer1);
		}
		
		/*
		 * Creating a bar chart for data with 3 Series
		 * Third series is on a secondary plane behind
		 */
		if (series == 3) {
			Data thirdData = DataIterator.next();
			DefaultCategoryDataset datasetTwo = new DefaultCategoryDataset();
			for (int i = (thirdData.getYears().size()) - 1; i >= 0; i--) {
				datasetTwo.setValue((thirdData.getValues()).get(i), thirdData.getType(), Integer.toString((thirdData.getYears()).get(i)));
			}
			 BarRenderer barrenderer2 = new BarRenderer(); //A new bar renderer for thrid series
			 plot.setDataset(1, datasetTwo);
			 plot.setRenderer(1, barrenderer2);
			 plot.mapDatasetToRangeAxis(0, 0); // 3rd data set to 2nd y-axis
		}
		
		JFreeChart barChart = new JFreeChart(result.getName(), new Font("Serif", java.awt.Font.BOLD, 18), plot, true);
		ChartPanel chartPanel = new ChartPanel(barChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white); 
		JPanel panel = MainUI.getPanel();
		panel.add(chartPanel);
	}	
}

