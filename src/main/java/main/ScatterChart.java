package main;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.data.time.Year;

import analysis.Result;
import analysis.Subject;
import analysis.Data;


public class ScatterChart implements Viewer {
	private Result result;

	public ScatterChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		
		XYPlot plot = new XYPlot();
		List<Data> data = result.getData();
		
		DateAxis domainAxis = new DateAxis("Year");
		plot.setDomainAxis(domainAxis);
		
		int c = 0;
		for (Data d : data) {
			
			TimeSeriesCollection dataset = new TimeSeriesCollection();
			XYItemRenderer itemrenderer = new XYLineAndShapeRenderer(false, true);

			TimeSeries series = new TimeSeries(d.getType());
			for (int i = 0; i < d.getValues().size(); i++)
				series.add(new Year(d.getYears().get(i)), d.getValues().get(i));
			dataset.addSeries(series);
			
			plot.setDataset(c, dataset);
			plot.setRenderer(c, itemrenderer);
			plot.setRangeAxis(c, new NumberAxis(getAxisLabel(d.getType())));	// CHANGE
			plot.mapDatasetToRangeAxis(c, c);

			c++;
		}
		
		JFreeChart scatterChart = new JFreeChart(result.getName(),
				new Font("Serif", java.awt.Font.BOLD, 18), plot, true);

		ChartPanel chartPanel = new ChartPanel(scatterChart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		JPanel panel = MainUI.getPanel();
		panel.add(chartPanel);

	}
	
	private String getAxisLabel(String type) {
		String label = "";
		switch (type) {
		case "CO2 Emissions" :
			label = "Metric Tons";
			break;
		case "Current Health Expenditure" :
			label = "% of GDP";
			break;
		case "Current Health Expenditure per Capita" :
			label = "Current US$";
			break;
		case "Energy Use" :
			label = "kg of Oil";
			break;
		case "Forest Area" :
			label = "% of Land Area";
			break;
		case "GDP per Capita" :
			label = "Current US$";
			break;
		case "Government Expenditure on Education, Total" :
			label = "% of GDP";
			break;
		case "PM2.5 Air Pollution, Mean Annual Exposure" :
			label = "Micrograms per Cubic Meter";
			break;
		default :
		}
		
		return label;
	}
	
}
