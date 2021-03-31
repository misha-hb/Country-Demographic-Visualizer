package analysis;

import java.util.ArrayList;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure {
private Reader reader;
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
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
		String governmentEducationURL = createURL("government education", country, startYear, endYear);
		String totalHealthURL = createURL("total health", country, startYear, endYear);
		
		
		//Three separate reader calls per analysis type
		Data governmentEducationData = reader.retrieveData(governmentEducationURL,analysisType);
		Data totalHealthData = reader.retrieveData(totalHealthURL,analysisType);
		
		
		dataList.add(governmentEducationData);
		dataList.add(totalHealthData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.equals("carbon")) {
			indicator = "EN.ATM.CO2E.PC";
		} else if (type.equals("energy")) {
			indicator = "EG.USE.PCAP.KG.OE";
		} else if (type.equals("air")) {
			indicator  = "EN.ATM.PM25.MC.M3";	
		}
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
}
