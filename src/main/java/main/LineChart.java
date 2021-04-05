package main;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import analysis.Result;
import analysis.Subject;
import analysis.Data;
import main.MainUI;

/**
 * class representing the line chart viewer
 */
public class LineChart implements Viewer {
	private Result result;

	public LineChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	/**
	 * draws the viewer depending on the result object containing the data
	 */
	public void drawViewer() {
		XYSeriesCollection dataset = new XYSeriesCollection();
		
		//holds data
		List<Data> dataList = result.getData(); 
		
		//determines the number of series in the viewer
		int numOfSeries = dataList.size(); 
		
		//iterates over data 
		Iterator<Data> iterator = dataList.iterator();
		Data data = iterator.next();
		
		//creates a line chart for 1 series
		XYSeries series1 = new XYSeries(data.getType());
		for (int i = (data.getYears().size()) - 1; i >= 0; i--) {
			series1.add(data.getYears().get(i), data.getValues().get(i));
		}
		dataset.addSeries(series1);

		//creates a line chart if there are 2 series
		if (numOfSeries >= 2) {
			Data next = iterator.next();
			XYSeries series2 = new XYSeries(next.getType());
			for (int i = (next.getYears().size()) - 1; i >= 0; i--) {
				series2.add(next.getYears().get(i), next.getValues().get(i));
			}
			dataset.addSeries(series2);
		}
		
		//creates a line chart depending on whether there are 3 series
		if (numOfSeries == 3) {
			Data third = iterator.next();
			XYSeries series3 = new XYSeries(third.getType());
			for (int i = (third.getYears().size()) - 1; i >= 0; i--) {
				series3.add(third.getYears().get(i), third.getValues().get(i));
			}
			dataset.addSeries(series3);
		}
		
		JFreeChart chart = ChartFactory.createXYLineChart(result.getName(), "Year", "", dataset,
				PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);

		plot.setDomainGridlinesVisible(true);
		plot.setDomainGridlinePaint(Color.BLACK);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(
				new TextTitle(result.getName(), new Font("Serif", java.awt.Font.BOLD, 18)));

		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(400, 300));
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		JPanel panel = MainUI.getPanel();
		panel.add(chartPanel);
		
		
		
	}
}

