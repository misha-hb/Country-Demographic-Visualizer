package main;

import analysis.Result;
import analysis.Subject;

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

	public void drawViewer() {
		String type = result.getType();
		int[] values = result.getValues();
		int[] years = result.getYears();
		

		// Draw operation for Line Chart
	}
}
