package analysis;

import java.util.ArrayList;
import java.util.List;

public class AverageForestArea extends Analysis {
	
	public AverageForestArea() {
		super();
	}
	
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
