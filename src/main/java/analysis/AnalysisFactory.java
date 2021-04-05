package analysis;

public class AnalysisFactory {
	 
	public Analysis createAnalysis(Selection selection) {
		Analysis analysisObj;
		String type = selection.getAnalysisType();
		
		if (type.contentEquals("CO2 Emissions vs Energy Use vs PM2.5 Air Pollution"))
			analysisObj = new COVsEnergyVsAir();
		else if (type.contentEquals("PM2.5 Air Pollution vs Forest Area"))
			analysisObj = new AirPollutionVsForestArea();
		else if (type.contentEquals("Ratio of CO2 Emissions and GPD per Capita"))
			analysisObj = new RatioOfCarbonAndGPD();
		else if (type.contentEquals("Average Forest Area"))
			analysisObj = new AverageForestArea();
		else if (type.contentEquals("Average Government Expenditure on Education"))
			analysisObj = new AverageGovernmentExpenditure();
		else if (type.contentEquals("Hospital Beds and Current Health Expenditure"))
			analysisObj = new HospitalAndHealthExpenditure();
		else if (type.contentEquals("Current Health Expenditure per Capita vs Mortality Rate"))
			analysisObj = new HealthExpenditureVsMortality();
		else
			analysisObj = new GovernmentExpenditureEducationVsHealthExpenditure();
		
		return analysisObj;

	}
	
}
