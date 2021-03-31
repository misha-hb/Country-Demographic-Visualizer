package analysis;

import java.util.ArrayList;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure extends Analysis {
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
				
		Data governmentEducationData = readData(EDUCATIONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTHCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}
}
