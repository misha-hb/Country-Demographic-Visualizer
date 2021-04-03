package analysis;

import main.MainUI;

public class AnalysisServer {
	
	public void doAnalysis(Selection userSelection) {
	
		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
	
		Result resultObj = analysisObj.calculate(userSelection);
	
		if (resultObj != null)
			resultObj.notifyViewers();
	
		else {
			MainUI ui = MainUI.getInstance();
			ui.displayError("Cannot fetch data");
		}
	}
}
