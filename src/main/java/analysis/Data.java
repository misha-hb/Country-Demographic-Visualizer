package analysis;

import java.util.List;

public class Data {
	private String type;
	private List<Double> values;
	private List<Integer> years;
	
	public Data(String type, List<Double> values, List<Integer> years) {
		this.type = type;
		this.values = values;
		this.years = years;
	}
	
	public void setValues(List<Double> newValues) {
		this.values = newValues;
	}
	
	public void setType(String newType) {
		this.type = newType;
	}
	
	public void setYears(List<Integer> newYears) {
		this.years = newYears;
	}
	
	public List<Double> getValues() {
		return this.values;
	}
	
	public String getType() {
		return this.type;
	}
	
	public List<Integer> getYears() {
		return this.years;
	}
	
	
}

