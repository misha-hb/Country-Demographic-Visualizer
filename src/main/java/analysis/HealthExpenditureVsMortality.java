package analysis;

import java.util.ArrayList;
import java.util.List;


//Health and mortality expenditure
public class HealthExpenditureVsMortality extends Analysis {
	
	public HealthExpenditureVsMortality() {
		super();
	}
	
	public Result calculate(Selection selection) {
		//Collect data from selection
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		Data healthData = readData(HEALTHPERCAPITACODE, country, startYear, endYear);
		Data mortalityData = readData(INFANTCODE, country, startYear, endYear);
		
		if (healthData == null || mortalityData == null) return null;

		List<Data> dataList = new ArrayList<Data>();
		dataList.add(healthData);
		dataList.add(mortalityData);
		Result result = new Result("Current Health Expenditure per Capita vs Mortality Rate", dataList);
		return result;
	}
}
