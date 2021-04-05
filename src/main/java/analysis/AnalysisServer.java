package analysis;

import java.awt.BorderLayout;
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
