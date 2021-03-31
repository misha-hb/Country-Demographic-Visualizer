package analysis;

import java.util.ArrayList;
import java.util.List;

public class AverageForestArea {
	private Reader reader;
	
	public AverageForestArea() {
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
		
		//Creating URL
		String forestURL = createURL("Forest Area", country, startYear, endYear);
	
		
		//reader call for analysis type
		Data forestData = reader.retrieveData(forestURL,analysisType);
		
		dataList.add(forestData);
		
		return null;
	}
	
	private String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		indicator = "AG.LND.FRST.ZS";
		
		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		return urlString;
	}
	
	private void computeAverage(Data data) {
	}
}
