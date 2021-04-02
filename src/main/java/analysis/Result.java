package analysis;

import java.util.List;

public class Result extends Subject{
	List<Data> data;
	double average;
	
	public Result(List<Data> data, double average) {
		this.data = data;
		this.average = average;
	}
	
	public Result(List<Data> data) {
		this.data = data;
	}
	
	public void setAverage(double newAverage) {
		average = newAverage;
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
