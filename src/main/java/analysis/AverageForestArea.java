package analysis;

import java.util.ArrayList;
import java.util.List;

public class AverageForestArea extends Analysis {
	
	public AverageForestArea() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data forestData = readData(FOREST, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}
	
	private void computeAverage(Data data) {
	}
}
