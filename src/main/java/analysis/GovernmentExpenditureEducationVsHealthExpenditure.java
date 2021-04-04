package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GovernmentExpenditureEducationVsHealthExpenditure extends Analysis {
	
	public GovernmentExpenditureEducationVsHealthExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
				
		Data governmentEducationData = readData(EDUCATION, EDUCATIONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data healthData = readData(HEALTH, HEALTHCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (governmentEducationData == null || healthData == null) return null;

		Data ratioData = computeRatio(governmentEducationData, healthData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(ratioData);
		
		Result result = new Result("Government Expenditure on Education vs Current Health Expenditure", dataList);
		
		return result;
	}
	
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
