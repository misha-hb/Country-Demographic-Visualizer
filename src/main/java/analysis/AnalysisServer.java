package analysis;

import java.util.List;

import main.MainUI;
import main.PieChart;

public class AnalysisServer {
	
	public void doAnalysis(Selection userSelection) {
	
		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
	
		Result resultObj = analysisObj.calculate(userSelection);
		
		List<String> viewers = userSelection.getViewers();
		
		for (String viewer : viewers) {
			switch (viewer) {
			case "Pie Chart" :
				new PieChart(resultObj);
			}
		}
		
	
		if (resultObj != null)
			resultObj.notifyViewers();
	
		else {
			MainUI ui = MainUI.getInstance();
			ui.displayError("Cannot fetch data");
		}
	}
}
