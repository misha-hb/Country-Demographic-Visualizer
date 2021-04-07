package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Average Forest area (% of land area)
 *
 * Analysis type class for Average Forest area
 */
public class AverageForestArea extends Analysis {
	
	public AverageForestArea() {
		super();
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects and an average value to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data forestData = readData(FOREST, FORESTCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (forestData == null) return null;

		double average = computeAverage(forestData);
		List<Data> data = new ArrayList<Data>();
		data.add(forestData);
		Result result = new Result("Average Forest area (% of land area)", data, average);
		return result;
	}
}
