package analysis;

import java.awt.BorderLayout;
import java.util.List;

import main.MainUI;
import main.PieChart;
import main.BarChart;
import main.LineChart;
import main.ScatterChart;
import main.TimeSeriesChart;
import main.Report;

public class AnalysisServer {
	
	public void doAnalysis(Selection userSelection) {
		
		if (userSelection.getAnalysisType().contentEquals("Select analysis") || userSelection.getCountry().contentEquals("Select country") || userSelection.getStartYear().contentEquals("Start Year") || userSelection.getEndYear().contentEquals("End Year")) { 
			MainUI ui = MainUI.getInstance();
			ui.displayError("All selections must be made to perform the analysis");
			return;
		}

		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
	
		Result resultObj = analysisObj.calculate(userSelection);
		
		if (resultObj != null) {

			List<String> viewers = userSelection.getViewers();
			
			for (String viewer : viewers) {
				switch (viewer) {
				case "Pie Chart" :
					new PieChart(resultObj);
					break;
				case "Bar Chart" :
					new BarChart(resultObj);
					break;
				case "Line Chart" :
					new LineChart(resultObj);
					break;
				case "Scatter Chart" :
					new ScatterChart(resultObj);
					break;
				case "Time Series Chart" :
					new TimeSeriesChart(resultObj);
					break;
				case "Report" :
					new Report(resultObj);
					break;
				}
			}
		
			MainUI.getInstance().getPanel().removeAll();
			resultObj.updateViewers();
			MainUI.getInstance().setVisible(true);
		}
	
		else {
			MainUI ui = MainUI.getInstance();
			ui.displayError("Cannot fetch data");
		}
	}
}
