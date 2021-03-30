package main;

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
		String type = result.getType();
		int[] values = result.getValues();
		int[] years = result.getYears();
		

		// Draw operation for Pie Chart
	}
}
