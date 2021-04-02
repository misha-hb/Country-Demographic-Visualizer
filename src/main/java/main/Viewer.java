package main;

import org.jfree.chart.ChartPanel;

import analysis.Subject;

public interface Viewer {
	
	public void update(Subject subject);
	public void drawViewer();
}
