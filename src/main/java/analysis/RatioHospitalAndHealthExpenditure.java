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
		
		Data hospitalBedsData = readData(hospitalBedsString, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(healthString, selection.getCountry(), selection.getStartYear(), selection.getEndYear());

		return null;
	}
	
	public Data readData(String dataType, String country, String startYear, String endYear) {

		String URL = createURL(dataType, country, startYear, endYear);
		
		Data dataObj = reader.retrieveData(URL, dataType);

		return dataObj;
	}
	
	private void computeRatio() {
	}
}
