package main;

import java.awt.Color;
import java.awt.Dimension;

import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import analysis.Data;
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
		
		List<Data> dataList = result.getData();
		
		
		
		JTextArea report = new JTextArea();
		report.setEditable(false);
		report.setPreferredSize(new Dimension(900, 800));
		report.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		report.setBackground(Color.white);
		String reportMessage;
		String name = result.getName();
		reportMessage = String.format("%s\n", name);
		reportMessage += "==============================\n";
		
		
		if (dataList.size() == 1) {
			
			if (name.contentEquals("Average Forest area (% of land area)") || name.contentEquals("Average of Government expenditure on education, total (% of GDP)")) {
				double average = result.getAverage();
				reportMessage += String.format("Average:\n\t%s", average);	
			}else {
				Data data = dataList.get(0);
				List<Double> values = data.getValues();
				List<Integer> years = data.getYears();
				Iterator<Double> valuesIterator = values.iterator();
				
				for (Integer year : years) {
					reportMessage += String.format("Year %s:\n", year);
					reportMessage += String.format("\t%s => %s\n", name, valuesIterator.next()) ;
				}
			}
		}else if (dataList.size() == 2) {
			
			Data data1 = dataList.get(0);
			Data data2 = dataList.get(1);
			
			List<Double> values1 = data1.getValues();
			List<Double> values2 = data2.getValues();
			List<Integer> years = data1.getYears();
			
			Iterator<Double> valuesIterator1 = values1.iterator();
			Iterator<Double> valuesIterator2 = values2.iterator();
			
			for (Integer year : years) {
				reportMessage += String.format("Year %s:\n", year);
				
				switch (name) {
				case "PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)" :
					reportMessage += String.format("\tPM2.5 air pollution, mean annual exposure (micrograms per cubic meter) => %s\n" , valuesIterator1.next());
					reportMessage += String.format("\tForest area (%% of land area) => %s\n" , valuesIterator2.next());
					break;
				case "Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)" :
					reportMessage += String.format("\tHospital beds (per 1,000 people) => %s\n" , valuesIterator1.next());
					reportMessage += String.format("\tCurrent health expenditure (per 1,000 people) => %s\n" , valuesIterator2.next());
					break;
				case "Current health expenditure per capita (current US$) vs Mortality rate, infant (per 1,000 live births)" :
					reportMessage += String.format("\tCurrent health expenditure per capita (current US$) => %s\n" , valuesIterator1.next());
					reportMessage += String.format("\tMortality rate, infant (per 1,000 live births) => %s\n" , valuesIterator2.next());
				}
			}
		}else {
			Data data1 = dataList.get(0);
			Data data2 = dataList.get(1);
			Data data3 = dataList.get(2);
			
			List<Double> values1 = data1.getValues();
			List<Double> values2 = data2.getValues();
			List<Double> values3 = data3.getValues();
			List<Integer> years = data1.getYears();
			
			Iterator<Double> valuesIterator1 = values1.iterator();
			Iterator<Double> valuesIterator2 = values2.iterator();
			Iterator<Double> valuesIterator3 = values3.iterator();
			
			for (Integer year : years) {
				reportMessage += String.format("Year %s:\n", year);
				
				reportMessage += String.format("\tCO2 emissions (metric tons per capita) => %s\n" , valuesIterator1.next());
				reportMessage += String.format("\tEnergy use (kg of oil equivalent per capita) => %s\n" , valuesIterator2.next());
				reportMessage += String.format("\tPM2.5 air pollution, mean annual exposure (micrograms per cubic meter) => %s\n" , valuesIterator3.next());
			}
		}	
			
		report.setText(reportMessage);
		JScrollPane outputScrollPane = new JScrollPane(report);
		
		MainUI.getPanel().add(outputScrollPane);
		
		
	}
}
