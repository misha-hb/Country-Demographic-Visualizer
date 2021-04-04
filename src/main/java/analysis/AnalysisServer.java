package analysis;

import java.util.List;

import main.BarChart;
import main.LineChart;
import main.MainUI;
import main.PieChart;
import main.Report;
import main.ScatterChart;

public class AnalysisServer {
	
	public void doAnalysis(Selection userSelection) {
	
		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
	
		Result resultObj = analysisObj.calculate(userSelection);
		
		if (resultObj != null) {

			List<String> viewers = userSelection.getViewers();
			
			for (String viewer : viewers) {
				switch (viewer) {
				case "Pie Chart" :
					resultObj.attach(new PieChart(resultObj));
					break;
				case "Bar Chart" :
					resultObj.attach(new BarChart(resultObj));
					break;
				case "Line Chart" :
					resultObj.attach(new LineChart(resultObj));
					break;
				case "Scatter Chart" :
					resultObj.attach(new ScatterChart(resultObj));
					break;
				case "Report" :
					resultObj.attach(new Report(resultObj));
					break;
				}
			}
		
			resultObj.notifyViewers();
		}
	
		else {
			MainUI ui = MainUI.getInstance();
			ui.displayError("Cannot fetch data");
		}
	}
}
