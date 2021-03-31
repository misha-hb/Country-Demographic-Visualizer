package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioHospitalAndHealthExpenditure extends Analysis {
	private Reader reader;
	private String hospitalBedsString = "Government expenditure on education, total";
	private String healthString = "Current health expenditure";

	
	public RatioHospitalAndHealthExpenditure() {
		Reader reader = new Reader();
	}
	
	public Result calculate(Selection selection) {
		
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		Data hospitalBedsData = readData(hospitalBedsString, country, startYear, endYear);
		Data healthData = readData(healthString, country, startYear, endYear);

	}
	
	public Data readData(String dataType, String country, String startYear, String endYear) {

		String URL = createURL(dataType, country, startYear, endYear);
		
		Data dataObj = reader.retrieveData(URL, dataType);

		return dataObj;
	}
	
s	
	private void computeRatio() {
	}
}
