package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//carbon and gdp analysis
public class RatioOfCarbonAndGPD extends Analysis {
	private Reader reader;
	private String carbonString = "CO2 emissions";
	private String governmentEducationString = "Government expenditure on education, total";
	
	public RatioOfCarbonAndGPD() {
		super();	
	}
	
	public Result calculate(Selection selection) {
		Data carbonData = readData(CARBON, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data GDPData = readData(GDP, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		Data ratioData = computeRatio(carbonData, GDPData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(ratioData);
		Result result = new Result(dataList);
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
		
		Data newData = new Data(ratioList, d1.getYears());
		return newData;
	}
}
