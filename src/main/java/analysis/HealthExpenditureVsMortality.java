package analysis;

import java.util.ArrayList;
import java.util.List;

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
		
		return null;
	}
}
