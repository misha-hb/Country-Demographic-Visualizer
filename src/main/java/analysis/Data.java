package analysis;

import java.util.List;

public class Data {
	private String type;
	private List<Double> values;
	private List<Double> years;
	
	public Data(String type, List<Double> values, List<Double> years) {
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
	
	public void setYears(List<Double> newYears) {
		this.years = newYears;
	}
	
	public List<Double> getValues() {
		return this.values;
	}
	
	public String getType() {
		return this.type;
	}
	
	public List<Double> getYears() {
		return this.years;
	}
	
	
}

