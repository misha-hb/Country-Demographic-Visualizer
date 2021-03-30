package analysis;

import java.util.Iterator;
import java.util.List;

public class Analysis {
	private Reader reader;
	
	public Analysis() {
		reader = new Reader();
	}
	
	public Result calculate(Selection selection) {
		return null;
	}
	
	public Data readData(Selection selection) {
		String analysisType = selection.getAnalysisType();
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		String url = createURL(analysisType, country, startYear, endYear);
		
		return reader.retrieveData(url,analysisType);
	}
	
	private String createURL(String analysisType, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (analysisType.equals("Total Population")) {
			indicator = "SP.POP.TOTL";
		}

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		System.out.println(urlString);
		return urlString;
	}
}
