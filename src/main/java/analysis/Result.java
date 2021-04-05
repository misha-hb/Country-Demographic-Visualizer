package analysis;

import java.util.List;

/**
 * class holding result to be displayed in viewers
 */
public class Result extends Subject{
	
	private String name;
	private List<Data> data;
	private double average;
	
	public Result(String name, List<Data> data, double average) {
		this.name = name;
		this.data = data;
		this.average = average;
	}
	
	public Result(String name, List<Data> data) {
		this.name = name;
		this.data = data;
	}
	
	public void setAverage(double newAverage) {
		average = newAverage;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAverage() {
		return this.average;
	}

	public List<Data> getData() {
		return this.data;
	}
	
	public void updateViewers() {
		notifyViewers();
	}
}
