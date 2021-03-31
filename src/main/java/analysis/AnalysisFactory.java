package analysis;

public class AnalysisFactory {
	
	public Analysis createAnalysis(Selection selection) {
		Analysis analysisObj;
		String type = selection.getAnalysisType();
		
		//if (type.contentEquals("CO2 Emissions vs Energy Use vs Air Pollution"))
			//analysisObj = new Analysis1();
		//else if (type.contentEquals("Air Pollution vs Forest Area"))
			//analysisObj = new Analysis2();
		//else if (type.contentEquals("Ratio of CO2 Emissions and GPD per Capita"))
			//analysisObj = new Analysis3();
		//else if (type.contentEquals("Average Forest Area"))
			//analysisObj = new Analysis4();
		//else if (type.contentEquals("Average Government Expenditure per Capita"))
			//analysisObj = new Analysis5();
		//else if (type.contentEquals("Ratio of Hospital Beds and Current Health Expenditure"))
			//analysisObj = new Analysis6();
		//else if (type.contentEquals("Current Health Expenditure per Capita vs Mortality Rate"))
			//analysisObj = new Analysis7();
		//else
			//analysisObj = new Analysis8();
		
		analysisObj = new Analysis();	// remove later
		return analysisObj;

	}
	
}
