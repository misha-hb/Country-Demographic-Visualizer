package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)
 *
 * Analysis type class for Ratio government expenditure vs Current health expenditure
 */
public class GovernmentExpenditureEducationVsHealthExpenditure extends Analysis {
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		super();
	}
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects to the result object.
	 */
	public Result calculate(Selection selection) {
				
		Data governmentEducationData = readData(EDUCATION, EDUCATIONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTH, HEALTHCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (governmentEducationData == null || healthData == null) return null;

		Data ratioData = computeRatio(governmentEducationData, healthData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(ratioData);
		
		Result result = new Result("Ratio of Government expenditure on education, total (% of GDP) vs Current health expenditure (% of GDP)", dataList);
		
		return result;
	}
	
	/**
	 * compute ratio for turning the values of two data objects into a new data object with a list of ratios
	 * @param d1 First data object for ratio
	 * @param d2 Second data object for ratio
	 * @return Ratio data object
	 */
	private Data computeRatio(Data d1, Data d2) {
		
		List<Double> ratioList = new ArrayList<Double>();
		
		List<Double> list1 = d1.getValues();
		List<Double> list2 = d2.getValues();
		double ratio, num1, num2;
		
		
		Iterator<Double> i1 = list1.iterator();
		Iterator<Double> i2 = list2.iterator();
		
		while (i1.hasNext()) {
			num1 = i1.next();
			num2 = i2.next();
			ratio = num1 / num2;
			System.out.println(ratio + " " + num1 + " " + num2);
			ratioList.add(ratio);
			
		}
		
		Data newData = new Data("Government Expenditure on Education / Current Health Expenditure", ratioList, d1.getYears());
		
		return newData;
	}
}
