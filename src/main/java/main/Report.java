package main;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import analysis.Result;
import analysis.Subject;

public class Report implements Viewer {

	private Result result;

	public Report(Result subject) {
		this.result = subject;
		subject.attach(this);
	}

	public void update(Subject subject) {
		if (subject.equals(result)) {
			drawViewer();
		}
	}

	public void drawViewer() {

		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(400, 300));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		
		String reportMessage;

		if (result.getAverage() != 0.0d) {
			reportMessage = String.format("%s\n" + "==============================\n" + "%s", result.getName(), result.getAverage());
		}
		
		else {
			reportMessage = String.format("%s\n" + "==============================\n", result.getName());
			List<Integer> years = result.getData().get(0).getYears();
			for (Integer y : years) {
				reportMessage += String.format("Year %s:\n"
						+ "\t%s => 5.6\n" + "\tHealth Expenditure per Capita => 10624\n"
						+ "\tHospital Beds/1000 people => 2.92\n" + "\n" + "Year 2017:\n" + "\tMortality/1000 births => 5.7\n"
						+ "\tHealth Expenditure per Capita => 10209\n" + "\tHospital Beds/1000 people => 2.87\n" + "\n"
						+ "Year 2016:\n" + "\tMortality/1000 births => 5.8\n" + "\tHealth Expenditure per Capita => 9877\n"
						+ "\tHospital Beds/1000 people => 2.77\n", result.getData().get(0));
			}

		}
	}
}
