package analysis;

import java.util.*;

public class COVsEnergyVsAir extends Analysis{


	public COVsEnergyVsAir() {
		super();	
	}
	
	public Result calculate(Selection selection) {
		
		Data carbonData = readData(CARBONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data energyData = readData(ENERGYCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data airData = readData(AIRCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		List<Data> dataList = new ArrayList<Data>();
		
		dataList.add(carbonData);
		dataList.add(energyData);
		dataList.add(airData);
		
		Result result = new Result(dataList);
		
		return result;
	}

}

