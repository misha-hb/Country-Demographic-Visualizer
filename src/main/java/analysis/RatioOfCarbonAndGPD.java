package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioOfCarbonAndGPD extends Analysis {
	
	public RatioOfCarbonAndGPD() {
		super();	
	}
	
	public Result calculate(Selection selection) {
		Data carbonData = readData(CARBONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data gdpData = readData(GDPCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}
		
	
	private void computeRatio() {
		
	}


}
