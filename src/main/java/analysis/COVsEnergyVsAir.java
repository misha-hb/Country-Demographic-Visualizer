package analysis;

import java.util.*;

public class COVsEnergyVsAir extends Analysis{


	public COVsEnergyVsAir() {
		super();	
	}
	
	public Result calculate(Selection selection) {
		
		Data carbonData = readData(CARBON, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data energyData = readData(ENERGY, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data airData = readData(AIR, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		return null;
	}

}

