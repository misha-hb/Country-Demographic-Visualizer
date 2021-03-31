package analysis;

import java.util.ArrayList;
import java.util.List;
//The average of Government expenditure on education, total (% of GDP) for the selected years
public class AverageGovernmentExpenditure extends Analysis{
	
	public AverageGovernmentExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data governmentEducationData = readData(EDUCATION, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}
	
	private void computeAverage(Data data) {
	}
}
