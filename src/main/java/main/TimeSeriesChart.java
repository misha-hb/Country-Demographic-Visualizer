package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;

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
		if (result.getName().equals("PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)")) {
			label = "Mean exposure / % of Area";
		} else if (result.getName().equals("CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)")) {
			label = "metric tones";
		} else if (result.getName().equals("Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)")) {
			label = "% of GPD";
		} else if (result.getName().equals("Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)")) {
			label = "US$";
		} else if (result.getName().equals("Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)")) {
			label = "US$"; 
		} else if (result.getName().equals("Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$)")) {
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

