package main;

import analysis.Result;
import analysis.Subject;

public class ScatterChart implements Viewer {
	private Result result;

	private ScatterChart(Result subject) {
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
		

		// Draw operation for Scatter Chart
	}
}
