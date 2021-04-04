package analysis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//The average of Government expenditure on education, total (% of GDP) for the selected years
public class AverageGovernmentExpenditure extends Analysis{
	
	public AverageGovernmentExpenditure() {
		super();
	}
	
	public Result calculate(Selection selection) {
		
		Data governmentEducationData = readData(EDUCATION, EDUCATIONCODE, selection.getCountry(), selection.getStartYear(), selection.getEndYear());
		
		if (governmentEducationData == null) return null;

		double average = computeAverage(governmentEducationData);
		List<Data> data = new ArrayList<Data>();
		data.add(governmentEducationData);
		Result result = new Result("Average Government Expenditure on Education", data, average);
		return result;
	}
	
	//private
	protected double computeAverage(Data data) {
		
		double total = 0.0;
		double average;
		double curr;
		
		List<Double> values = data.getValues();
		List<Integer> years = data.getYears();
		
		Iterator<Double> i1 = values.iterator();
		
		while (i1.hasNext()) {
			curr = i1.next();
			System.out.println(curr);
			total += curr;
		}
		
		average = total / years.size();
		System.out.println(average);
		return average;
	}
}
