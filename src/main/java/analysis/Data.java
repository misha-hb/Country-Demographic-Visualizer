package analysis;

import java.util.List;

/**
 * class representing the data object retrieved
 */
public class Data {
	private String type;
	private List<Double> values;
	private List<Integer> years;
	
	/**
	 * constructor for data objects
	 * @param type represents the type of data
	 * @param values represents a list of the values of the data
	 * @param years represents a list of the years of data
	 */
	public Data(String type, List<Double> values, List<Integer> years) {
		this.type = type;
		this.values = values;
		this.years = years;
	}
		
	/**
	 * @param newValues are set as values
	 */
	public void setValues(List<Double> newValues) {
		this.values = newValues;
	}
	
	/**
	 * @param newType set as type
	 */
	public void setType(String newType) {
		this.type = newType;
	}
	
	/**
	 * @param newYears set as years
	 */
	public void setYears(List<Integer> newYears) {
		this.years = newYears;
	}
	
	/**
	 * @return list of values in data object
	 */
	public List<Double> getValues() {
		return this.values;
	}
	
	/**
	 * @return type of data object
	 */
	public String getType() {
		return this.type;
	}
	
	/**
	 * @return list of years of data object
	 */
	public List<Integer> getYears() {
		return this.years;
	}
	
	
}

