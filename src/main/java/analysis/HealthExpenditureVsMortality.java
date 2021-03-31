package analysis;

import java.util.ArrayList;
import java.util.List;

public class HealthExpenditureVsMortality extends Analysis {
	private Reader reader;
	private String healthString = "Current health expenditure";
	private String mortalityString = "Mortality rate, infant";
	
	public HealthExpenditureVsMortality() {
		Reader reader = new Reader();
		
	}
	
	public Result calculate(Selection selection) {
		//Collect data from selection
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		Data healthData = readData(healthString, country, startYear, endYear);
		Data mortalityData = readData(mortalityString, country, startYear, endYear);
		
		return null;
	}
	
	public Data readData(String dataType, String country, String startYear, String endYear) {		
		
		String URL = createURL(dataType, country, startYear, endYear);
		
		Data dataObj = reader.retrieveData(URL, dataType);
		
		return dataObj;
	}
	
}
