package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioOfCarbonAndGPD extends Analysis {
	
	public RatioOfCarbonAndGPD() {
		super();
		
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
		String carbonURL = createURL("Carbon Emissions", country, startYear, endYear);
		String GPDURL = createURL("GPD", country, startYear, endYear);
		
		//Three separate reader calls per analysis type
		Data carbonData = getReader().retrieveData(carbonURL,analysisType);
		Data GPDData = getReader().retrieveData(GPDURL,analysisType);
		
		dataList.add(carbonData);
		dataList.add(GPDData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("Carbon Emissions")) {
			indicator = "EN.ATM.CO2E.PC";
		} else if (type.equals("GPD")) {
			indicator = "NY.GDP.PCAP.CD";
		}
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
	
	private void computeRatio() {
		
	}


}
