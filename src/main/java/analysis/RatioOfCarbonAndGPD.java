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
	
	/**
	 * calculate method creates a Result object based on the passed Selection object. Passes a list of data objects to the result object.
	 */
	public Result calculate(Selection selection) {
		
		Data carbonData = readData(CARBON, CARBONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		Data GDPData = readData(GDP, GDPCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (carbonData == null || carbonData == null) return null;

		Data ratioData = computeRatio(carbonData, GDPData);
		
		List<Data> dataList = new ArrayList<Data>();
		dataList.add(ratioData);
		Result result = new Result("Ratio of CO2 emissions (metric tons per capita) and GDP per capita (current US$)", dataList);
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
		
		Data newData = new Data("CO2 Emissions / GDP per Capita", ratioList, d1.getYears());
		return newData;
	}
}
