package analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Analysis class for PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) 
 */
public class AirPollutionVsForestArea extends Analysis{
	
	public AirPollutionVsForestArea() {
		super();
	}
	
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
