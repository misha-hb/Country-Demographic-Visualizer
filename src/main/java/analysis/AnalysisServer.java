package analysis;

public class AnalysisServer {
	private Selection selection;
	
	public void run(Selection selection) {
		
	}
	
	public void doAnalysis(Selection userSelection) {
		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
		Result resultObj = analysisObj.calculate(userSelection);
		resultObj.notifyViewers();
	}

}
