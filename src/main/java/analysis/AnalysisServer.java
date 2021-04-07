package analysis;

import java.util.List;

import main.MainUI;
import main.PieChart;
import main.BarChart;
import main.LineChart;
import main.ScatterChart;
import main.TimeSeriesChart;
import main.Report;
/**
 *contains method creating an analysis object by invoking AnalysisFactory class
 */
public class AnalysisServer {
	
	/**
	 * invokes AnalysisFactory object to create an analysis object
	 * @param userSelection contains the selections the user has made including analysis type, country, start/end year, 
	 */
	public void doAnalysis(Selection userSelection) {
		
		//ensures the user has made all necessary selections before performing analysis
		if((userSelection.getAnalysisType() == null) || (userSelection.getCountry() == null) || (userSelection.getEndYear() == null) || (userSelection.getStartYear() == null)) {
			MainUI ui = MainUI.getInstance();
			ui.displayError("All selections must be made to perform the analysis");
			return;
		}

		//creates new AnalysisFactory object and passes the user's selections as a parameter
		AnalysisFactory factory = new AnalysisFactory();
		Analysis analysisObj = factory.createAnalysis(userSelection);
	
		//result object is obtained by using the calculate method from the Analysis class
		Result resultObj = analysisObj.calculate(userSelection);
		
		if (resultObj != null) {

			//viewers that the user has selected are placed in a list
			List<String> viewers = userSelection.getViewers();
			
			//objects are created for the appropriate viewers and the result object is passed as a paramter so
			//that the charts can display the appropriate data
			for (String viewer : viewers) {
				switch (viewer) {
				case "Pie Chart" :
					new PieChart(resultObj);
					break;
				case "Bar Chart" :
					new BarChart(resultObj);
					break;
				case "Line Chart" :
					new LineChart(resultObj);
					break;
				case "Scatter Chart" :
					new ScatterChart(resultObj);
					break;
				case "Time Series Chart" :
					new TimeSeriesChart(resultObj);
					break;
				case "Report" :
					new Report(resultObj);
					break;
				}
			}
		
			MainUI.getInstance().getPanel().removeAll();
			resultObj.updateViewers();
			MainUI.getInstance().setVisible(true);
		}
	
		//if data can not be fetched (the result object is empty) then an appropriate message is displayed
		else {
			MainUI ui = MainUI.getInstance();
			ui.displayError("Cannot fetch data");
		}
	}
}
