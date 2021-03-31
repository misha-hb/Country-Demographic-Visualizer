package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioHospitalAndHealthExpenditure {
	private Reader reader;
	
	public RatioHospitalAndHealthExpenditure() {
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
		String hospitalBedsURL = createURL("hospital beds", country, startYear, endYear);
		String healthURL = createURL("health", country, startYear, endYear);
		
		//Three separate reader calls per analysis type
		Data hospitalBedsData = reader.retrieveData(hospitalBedsURL,analysisType);
		Data healthData = reader.retrieveData(healthURL,analysisType);
		
		dataList.add(hospitalBedsData);
		dataList.add(healthData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("hospital beds")) {
			indicator = "SH.MED.BEDS.ZS";
		} else if (type.equals("health")) {
			indicator = "SH.XPD.CHEX.PC.CD";
		}
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
	
	private void computeRatio() {
		
	}
}
