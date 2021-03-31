package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioOfCarbonAndGPD extends Analysis {
	private Reader reader;
	private String carbonString = "CO2 emissions";
	private String governmentEducationString = "Government expenditure on education, total";
	
	public RatioOfCarbonAndGPD() {
		super();
		
	}
	
	public Result calculate(Selection selection) {
		Data carbonData = readData("CO2 emissions", selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data GPDData = readData(governmentEducationString, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
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
	
	public Data readData(String dataType, String country, String startYear, String endYear) {

		String URL = createURL(dataType, country, startYear, endYear);
		
		Data dataObj = reader.retrieveData(URL, dataType);

		return dataObj;
	}
	
	
	private void computeRatio() {
		
	}


}
