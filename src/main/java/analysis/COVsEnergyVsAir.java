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
		
		return null;
	}

}

