package main;

import analysis.Result;
import analysis.Subject;

public class BarChart implements Viewer{
	private Result result;

	private BarChart(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {
		String type = result.getType();
		int[] values = result.getValues();
		int[] years = result.getYears();
		

		// Draw operation for Bar Chart
	}
}
