package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioOfCarbonAndGPD extends Analysis {
	private Reader reader;
	
	public RatioOfCarbonAndGPD() {
		Reader reader = new Reader();
		
	}
	
	public Result calculate(Selection selection) {
		Data carbonData = readData("Carbon Emissions", selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data GPDData = readData("GPD", selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
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
