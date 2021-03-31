package analysis;

import java.util.ArrayList;
import java.util.List;

public class AverageGovernmentExpenditure {
	private Reader reader;
	
	public AverageGovernmentExpenditure() {
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
		
		//Creating URL
		String governmentURL = createURL("Government Expenditure", country, startYear, endYear);
	
		
		//reader call for analysis type
		Data governmentData = reader.retrieveData(governmentURL,analysisType);
		
		dataList.add(governmentData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		indicator = "SE.XPD.TOTL.GD.ZS";
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
	
	private void computeAverage(Data data) {
	}
}
