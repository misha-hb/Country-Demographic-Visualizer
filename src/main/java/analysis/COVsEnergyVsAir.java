package analysis;

import java.util.ArrayList;
import java.util.List;

/**
 * CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)
 *
 * Analysis type class for CO2 emissions vs Energy use vs Air pollution
 */
public class COVsEnergyVsAir extends Analysis{


	public COVsEnergyVsAir() {
		super();	
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data carbonData = readData(CARBON, CARBONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data energyData = readData(ENERGY, ENERGYCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data airData = readData(AIR, AIRCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (carbonData == null || energyData == null || airData == null) return null;

		List<Data> dataList = new ArrayList<Data>();
		
		dataList.add(carbonData);
		dataList.add(energyData);
		dataList.add(airData);
		
		Result result = new Result("CO2 emissions (metric tons per capita) vs Energy use (kg of oil equivalent per capita) vs PM2.5 air pollution, mean annual exposure (micrograms per cubic meter)", dataList);
		
		return result;
	}

}

