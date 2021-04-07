package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Average of Government expenditure on education, total (% of GDP)
 *
 * Analysis type class for Average Government expenditure
 */
public class AverageGovernmentExpenditure extends Analysis{
	
	public AverageGovernmentExpenditure() {
		super();
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects and an average value to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data governmentEducationData = readData(EDUCATION, EDUCATIONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (governmentEducationData == null) return null;

		double average = computeAverage(governmentEducationData);
		List<Data> data = new ArrayList<Data>();
		data.add(governmentEducationData);
		Result result = new Result("Average of Government expenditure on education, total (% of GDP)", data, average);
		return result;
	}
}
