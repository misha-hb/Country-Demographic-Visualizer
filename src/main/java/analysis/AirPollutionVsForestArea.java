package analysis;

import java.util.ArrayList;
import java.util.List;

//PM2.5 air pollution, mean annual exposure (micrograms per cubic meter) vs Forest area (% of land area) 
public class AirPollutionVsForestArea extends Analysis{
	
	public AirPollutionVsForestArea() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data airData = readData(AIR, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data forestData = readData(FOREST, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}
}
