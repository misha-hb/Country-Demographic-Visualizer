package analysis;

import java.util.ArrayList;
import java.util.List;

public class HealthExpenditureVsMortality extends Analysis {
	private Reader reader;
	
	public HealthExpenditureVsMortality() {
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
		String healthURL = createURL("Health Expenditure", country, startYear, endYear);
		String mortalityURL = createURL("Mortality Rate", country, startYear, endYear);
		
		
		//Three separate reader calls per analysis type
		Data healthData = reader.retrieveData(healthURL,analysisType);
		Data mortalityData = reader.retrieveData(mortalityURL,analysisType);
		
		
		dataList.add(healthData);
		dataList.add(mortalityData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("Health Expenditure")) {
			indicator = "SH.XPD.CHEX.GD.ZS";
		} else if (type.equals("Mortality Rate")) {
			indicator = "SP.DYN.IMRT.IN";
		}
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
}
