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

/**
 * Represents the bar chart that will appear on the main UI 
 */

public class BarChart implements Viewer {
	
	private Result result;
	
	/**
	 * Constructor for class 
	 * will set the result object
	 * @param subject
	 */
	public BarChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	/**
	 * Will update the viewer if viewer class if notified by subject
	 * @param subject
	 */
	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	/**
	 * will populate the viewer data and draw the bars for the chart
	 */
	public void drawViewer() {
		
		List<Data> dataList = result.getData(); //List of data Series required
		int series = dataList.size(); //To determine how many series in the graph
		DefaultCategoryDataset datasetOne = new DefaultCategoryDataset(); //Creating a data set for first series
		CategoryPlot plot = new CategoryPlot(); 
		
		/*
		 * Determining what the y-axis label will be
		 */ 
		String label = "";
		if(result.getName().equals("PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)")) {
			label = "Mean exposure / % of Area";
		} else if (result.getName().equals("CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)")) {
			label = "metric tones";
		} else if(result.getName().equals("Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)")) {
			label = "% of GPD";
		} else if (result.getName().equals("Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)")) {
			label = "US$";
		} else if (result.getName().equals("Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)")) {
			label = "US$";
		}else if(result.getName().equals("Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$)")) {
			label = "US$";
		}
			
		
		
		/*
		 * Creating a Bar chart for data with at least one series
		 */
		Iterator<Data> DataIterator = dataList.iterator();
		Data firstData = DataIterator.next();
	
		for (int i = (firstData.getYears().size()) - 1; i >= 0; i--) { //setting the values for each year
			datasetOne.setValue((firstData.getValues()).get(i), firstData.getType(), Integer.toString((firstData.getYears()).get(i)));
		}
		
		//creating a new bar renderer of first( and/or second) data set and setting the renderer in the plot
		BarRenderer barrenderer1 = new BarRenderer(); 
		plot.setDataset(0, datasetOne);
		plot.setRenderer(0, barrenderer1); 
		
		//setting the domain and the range axis for the chart
		CategoryAxis domainAxis = new CategoryAxis("Year"); 
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));
		plot.setRangeAxis(1, new NumberAxis(label));
		plot.mapDatasetToRangeAxis(0, 0);// 1st data (and/or second) set to 1st y-axis
		
		
		
		/*
		 * Creating a bar chart for data with at least two Series
		 * The second series will be on the same "plane" as the first series
		 */
		if (series > 1) {
			Data secondData = DataIterator.next();
			for (int i = (secondData.getYears().size()) - 1; i >= 0; i--) { //setting the values for each year
				datasetOne.setValue((secondData.getValues()).get(i), secondData.getType(), Integer.toString((secondData.getYears()).get(i)));
			}
			//setting the renderer in the plot
			 plot.setRenderer(1, barrenderer1); 
		}
		
		/*
		 * Creating a bar chart for data with 3 Series
		 * Third series visually is on a secondary plane behind the first and second
		 */
		if (series == 3) {
			Data thirdData = DataIterator.next();
			DefaultCategoryDataset datasetTwo = new DefaultCategoryDataset();
			for (int i = (thirdData.getYears().size()) - 1; i >= 0; i--) { //setting the values for each year
				datasetTwo.setValue((thirdData.getValues()).get(i), thirdData.getType(), Integer.toString((thirdData.getYears()).get(i)));
			}
			 BarRenderer barrenderer2 = new BarRenderer(); //A new bar renderer for third series
			 plot.setDataset(1, datasetTwo);
			 plot.setRenderer(1, barrenderer2); //setting the renderer in the plot
			 plot.mapDatasetToRangeAxis(0, 0); // 3rd data set to 2nd y-axis
		}
		
		//setting the chart dimension and visual characteristics such as fonts and borders
		JFreeChart barChart = new JFreeChart(result.getName(), new Font("Serif", java.awt.Font.BOLD, 18), plot, true); //setting font
		ChartPanel chartPanel = new ChartPanel(barChart); // creating a new chart Panel
		chartPanel.setPreferredSize(new Dimension(400, 300)); 
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white); 
		JPanel panel = MainUI.getPanel();
		panel.add(chartPanel); //Adding bar chart panel to the UI panel
	}	
}

