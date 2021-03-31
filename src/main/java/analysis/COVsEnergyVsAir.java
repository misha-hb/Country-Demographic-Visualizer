package analysis;

import java.util.*;

public class COVsEnergyVsAir extends Analysis{
	
	private Reader reader;
	
	public COVsEnergyVsAir() {
		Reader reader = new Reader();
		
	}
	
	public Result calculate(Selection selection) {
		readData(selection);
	}
	
	public Data readData(Selection selection) {
		List<Data> dataList = new ArrayList<Data>();
		
		//Collect data from selection
		String analysisType = selection.getAnalysisType();
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		//Creating each URL per analysis Type
		String carbonURL = createURL("carbon", country, startYear, endYear);
		String energyURL = createURL("energy", country, startYear, endYear);
		String airURL = createURL("air", country, startYear, endYear);
		
		//Three separate reader calls per analysis type
		Data carbonData = reader.retrieveData(carbonURL,analysisType);
		Data energyData = reader.retrieveData(energyURL,analysisType);
		Data airData = reader.retrieveData(airURL,analysisType);
		
		dataList.add(carbonData);
		dataList.add(energyData);
		dataList.add(airData);
		
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

