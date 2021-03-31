package analysis;

import java.util.ArrayList;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure {
private Reader reader;
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		Reader reader = new Reader();
		
	}
	
	public Result calculate(Selection selection) {
		return null;
	}
	
	public Data readData(Selection selection) {
		List<Data> dataList = new ArrayList<Data>();
		
		//Collect data from selection
		String analysisType = selection.getAnalysisType();
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		//Creating each URL per analysis Type
		String governmentEducationURL = createURL("Government Expenditure on Education", country, startYear, endYear);
		String healthURL = createURL("Health Expenditure", country, startYear, endYear);
		
		
		//Three separate reader calls per analysis type
		Data governmentEducationData = reader.retrieveData(governmentEducationURL,analysisType);
		Data healthData = reader.retrieveData(healthURL,analysisType);
		
		
		dataList.add(governmentEducationData);
		dataList.add(healthData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("Government Expenditure on Education")) {
			indicator = "SE.XPD.TOTL.GD.ZS";
		} else if (type.equals("Health Expenditure")) {
			indicator = "SH.XPD.CHEX.PC.CD";
		
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
}
