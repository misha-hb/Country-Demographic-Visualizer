package analysis;

public class Result extends Subject{
	private String type;
	private int[] values, years;

	public String getType() {
		return this.type;
	}

	public int[] getValues() {
		return this.values;
	}

	public int[] getYears() {
		return this.years;
	}

	public void updateViewers() {
		notifyViewers();
	}
}
