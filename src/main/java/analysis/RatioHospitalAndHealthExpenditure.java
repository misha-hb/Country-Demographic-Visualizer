package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Hospital beds and Health expenditure
public class RatioHospitalAndHealthExpenditure extends Analysis {
	
	public RatioHospitalAndHealthExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data hospitalBedsData = readData(BEDS, BEDSCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTHPERCAPITA, HEALTHPERCAPITACODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (hospitalBedsData == null || healthData == null) return null;

		Data newHealthData = computeRatio(hospitalBedsData, healthData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(hospitalBedsData);
		dataList.add(newHealthData);
		Result result = new Result("Ratio of Hospital Beds and Current Health Expenditure", dataList);
		return result;
	}
	
	private Data computeRatio(Data d1, Data d2) {
		
		List<Double> healthList = d2.getValues();
		double newValue;
		List<Double> newHealthList = new ArrayList<Double>();
		
		Iterator<Double> itr = healthList.iterator();
		
		while (itr.hasNext()) {
			newValue = (itr.next()*1000);
			newHealthList.add(newValue);
		}
		
		Data newData = new Data("Current Health Expenditure", newHealthList, d2.getYears());
		return newData;	
	}
}
