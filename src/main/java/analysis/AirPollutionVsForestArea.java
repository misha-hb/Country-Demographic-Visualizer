package analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) 
 *
 * Analysis type class for Air Pollution vs Forest Area
 * 
 */
public class AirPollutionVsForestArea extends Analysis{
	
	public AirPollutionVsForestArea() {
		super();
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data airData = readData(AIR, AIRCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data forestData = readData(FOREST, FORESTCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (airData == null || forestData == null) return null;

		List<Data> dataList = new ArrayList<Data>();
		dataList.add(airData);
		dataList.add(forestData);

		Result result = new Result("PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area)", dataList);
		
		return result;

	}
}
