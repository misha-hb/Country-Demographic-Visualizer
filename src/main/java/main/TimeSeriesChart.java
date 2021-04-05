package main;


import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.chart.util.TableOrder;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import analysis.Data;
import analysis.Result;
import analysis.Subject;

public class TimeSeriesChart implements Viewer{
	private Result result;

	public TimeSeriesChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		List<Data> dataList = result.getData(); // List of data Series required
		int series = dataList.size(); // To determine how many series in the graph

		/*
		 * Determining what the y-axis label will be
		 */
		String label = "";
		if (result.getName().equals("Air Pollution vs Forest Area")) {
			label = "Mean exposure / % of Area";
		} else if (result.getName().equals("CO2 Emissions vs Energy Use vs Air Pollution")) {
			label = "metric tones";
		} else if (result.getName().equals("Government Expenditure on Education vs Current Health Expenditure")) {
			label = "% of GPD";
		} else if (result.getName().equals("Current Health Expenditure per Capita vs Mortality Rate")) {
			label = "US$";
		} else if (result.getName().equals("Hospital Beds and Current Health Expenditure")) {
			label = "US$"; 
		} else if (result.getName().equals("Ratio of CO2 Emissions and GPD per Capita")) {
			label = "US$";
		}

		/*
		 * Setting the first series on the chart
		 */

		Iterator<Data> DataIterator = dataList.iterator();
		Data firstData = DataIterator.next();
		TimeSeries series1 = new TimeSeries(firstData.getType());

		for (int i = 0; i <= (firstData.getYears().size() - 1); i++) {
			series1.add(new Year(firstData.getYears().get(i)), (firstData.getValues()).get(i));
		}
		TimeSeriesCollection dataset = new TimeSeriesCollection();
		dataset.addSeries(series1);
		XYPlot plot = new XYPlot();

		if (series > 1) {
			Data secondData = DataIterator.next();
			TimeSeries series2 = new TimeSeries(secondData.getType());
			for (int i = 0; i <= (secondData.getYears().size() - 1); i++) {
				series2.add(new Year(secondData.getYears().get(i)), (secondData.getValues()).get(i));
			}
			TimeSeriesCollection dataset2 = new TimeSeriesCollection();
			dataset2.addSeries(series2);
			plot.setDataset(1, dataset2);
		}

		if (series == 3) {
			Data thirdData = DataIterator.next();
			TimeSeries series3 = new TimeSeries(thirdData.getType());
			for (int i = 0; i <= (thirdData.getYears().size() - 1); i++) {
				series3.add(new Year(thirdData.getYears().get(i)), (thirdData.getValues()).get(i));

			}
			dataset.addSeries(series3);
		}

		XYSplineRenderer splinerenderer1 = new XYSplineRenderer();
		XYSplineRenderer splinerenderer2 = new XYSplineRenderer();

		plot.setDataset(0, dataset);
		plot.setRenderer(0, splinerenderer1);
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		plot.setRangeAxis(new NumberAxis(""));

		plot.setRenderer(1, splinerenderer2);
		plot.setRangeAxis(1, new NumberAxis(label));

		plot.mapDatasetToRangeAxis(0, 0);// 1st dataset to 1st y-axis
		plot.mapDatasetToRangeAxis(1, 1); // 2nd dataset to 2nd y-axis

		JFreeChart chart = new JFreeChart(result.getName(), new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		JPanel panel = MainUI.getPanel();
		panel.add(chartPanel);
	}
}

