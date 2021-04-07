package analysis;

import java.util.List;

/**
 * class holding result to be displayed in viewers
 */
public class Result extends Subject{
	
	private String name;
	private List<Data> data;
	private double average;
	
	/**
	 * constructor setting the private variables
	 * @param name of the data
	 * @param data list of data objects
	 * @param average 
	 */
	public Result(String name, List<Data> data, double average) {
		this.name = name;
		this.data = data;
		this.average = average;
	}
	
	/**
	 * a second constructor for result objects that do not have a average
	 * @param name of the data
	 * @param data list of data objects
	 */
	public Result(String name, List<Data> data) {
		this.name = name;
		this.data = data;
	}
	
	/**
	 * @param newAverage the average to be set
	 */
	public void setAverage(double newAverage) {
		average = newAverage;
	}
	
	/**
	 * @return name of the data in the result objects
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * @return average of the data in the result object
	 */
	public double getAverage() {
		return this.average;
	}

	/**
	 * @return list of data objects in the result objects
	 */
	public List<Data> getData() {
		return this.data;
	}
	
	/**
	 * notifies viewers
	 */
	public void updateViewers() {
		notifyViewers();
	}
}
