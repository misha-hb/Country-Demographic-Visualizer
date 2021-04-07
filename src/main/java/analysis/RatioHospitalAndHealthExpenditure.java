package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)
 *
 * Analysis type class for Hospital Beds vs Current Health Expenditure
 */
public class RatioHospitalAndHealthExpenditure extends Analysis {
	
	public RatioHospitalAndHealthExpenditure() {
		super();
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data hospitalBedsData = readData(BEDS, BEDSCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTHPERCAPITA, HEALTHPERCAPITACODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (hospitalBedsData == null || healthData == null) return null;

		Data newHealthData = computeRatio(hospitalBedsData, healthData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(hospitalBedsData);
		dataList.add(newHealthData);
		Result result = new Result("Hospital beds (per 1,000 people) and Current health expenditure (per 1,000 people)", dataList);
		return result;
	}
	
	/**
	 * compute ratio method for converting Health expenditure per capita into health expenditure per 1000 people. Creates a new data object with the changed data.
	 * @param d1 first data object with data that will not be changed
	 * @param d2 second data object with data that will be adjusted
	 * @return new data object with adjusted data
	 */
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
