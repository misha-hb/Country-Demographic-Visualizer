package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AverageForestArea extends Analysis {
	
	public AverageForestArea() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data forestData = readData(FORESTCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		double average = computeAverage(forestData);
		List<Data> data = new ArrayList<Data>();
		data.add(forestData);
		Result result = new Result("Average Forest Area", data, average);
		return result;
	}
}
