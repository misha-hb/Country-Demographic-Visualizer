package analysis;

import java.util.ArrayList;
import java.util.List;

public class RatioHospitalAndHealthExpenditure extends Analysis {
	
	public RatioHospitalAndHealthExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data hospitalBedsData = readData(BEDSCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTHPERCAPITACODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());

		return null;
	}
	
	private void computeRatio() {
	}
}
