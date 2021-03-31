package analysis;

import java.util.ArrayList;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure extends Analysis {
	private Reader reader;
	private String governmentEducationString = "Government expenditure on education, total";
	private String healthString = "Current health expenditure";
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		Reader reader = new Reader();
	}
	
	public Result calculate(Selection selection) {
		
		//Collect data from selection
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		Data governmentEducationData = readData(governmentEducationString, country, startYear, endYear);
		Data healthData = readData(healthString, country, startYear, endYear);
		
		return null;
		
	}
	
	public Data readData(String dataType, String country, String startYear, String endYear) {
		
		//Creating each URL per analysis Type
		String URL = createURL(dataType, country, startYear, endYear);

		Data dataObj = reader.retrieveData(URL, dataType);

		return dataObj;
	}
	
}
