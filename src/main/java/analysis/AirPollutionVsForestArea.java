package analysis;

import java.util.ArrayList;
import java.util.List;

public class AirPollutionVsForestArea {
	private Reader reader;
	
	public AirPollutionVsForestArea() {
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
		String airURL = createURL("Air Pollution", country, startYear, endYear);
		String forestURL = createURL("Forest Area", country, startYear, endYear);
		
		//Three separate reader calls per analysis type
		Data airData = reader.retrieveData(airURL,analysisType);
		Data forestData = reader.retrieveData(forestURL,analysisType);
	
		
		dataList.add(airData);
		dataList.add(forestData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("Air Pollution")) {
			indicator = "EN.ATM.PM25.MC.M3";
		} else if (type.equals("Forest Area")) {
			indicator = "AG.LND.FRST.ZS";	
		}
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
}


}
