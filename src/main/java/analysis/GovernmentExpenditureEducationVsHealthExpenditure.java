package analysis;

import java.util.ArrayList;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure extends Analysis {
	private String governmentEducationString = "Government expenditure on education, total";
	private String healthString = "Current health expenditure";
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
				
		Data governmentEducationData = readData(governmentEducationString, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(healthString, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
		
	}
	
	public Data readData(String dataType, String country, String startYear, String endYear) {
		
		String URL = createURL(dataType, country, startYear, endYear);

		Data dataObj =  getReader().retrieveData(URL, dataType);

		return dataObj;
	}
	
}
