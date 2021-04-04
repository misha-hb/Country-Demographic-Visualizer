package analysis;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import main.MainUI;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

public class Selection {
  
  private String analysisType, country, startYear, endYear;
  private List<String> viewers;
  
  public Selection() {
	  this.analysisType = null;
	  this.country = null;
	  this.startYear = null;
	  this.endYear = null;
	  this.viewers = new ArrayList<String>();	// "the list of viewers needs to be initially populated when the system is first run"
  }
  
  public void setAnalysisType(String selectedType) {
	  analysisType = selectedType;
	  viewers = new ArrayList<String>();	// empty the current viewers
	  System.out.println(String.format("Selected analysis \"%s\"", selectedType));
  }
  
  public void setCountry(String selectedCountry) throws IOException {
	  if (validateCountry(selectedCountry)) {
		  country = selectedCountry;
		  System.out.println(String.format("Selected country \"%s\"", selectedCountry));
	  }
  }

  public void setStartYear(String selectedYear) {
	  startYear = selectedYear;
	  System.out.println(String.format("Selected start year \"%s\"", selectedYear));
  }
  
  public void setEndYear(String selectedYear) {
	  endYear = selectedYear;
	  System.out.println(String.format("Selected end year \"%s\"", selectedYear));
  }
  
  public void addViewer(String selectedViewer) {
	  if(validateViewerAddition(selectedViewer)) {
		  viewers.add(selectedViewer);
		  System.out.println(String.format("Added viewer \"%s\"", selectedViewer));
	  }
  }
  
  public void removeViewer(String selectedViewer) {
	  if(validateViewerRemoval(selectedViewer)) {
		  viewers.remove(selectedViewer);
		  System.out.println(String.format("Removed viewer \"%s\"", selectedViewer));
	  }
  }
  
  public String getAnalysisType() {
	  return analysisType;
  }

  public String getCountry() {
	  return country;
  }


  public String getStartYear() {
	  return startYear;
  }

  public String getEndYear() {
	  return endYear;
  }
  
  public List<String> getViewers() {
	  return viewers;
  }

  private boolean validateCountry(String country) throws IOException {
	  
	  // check if analysis is chosen
	  if (analysisType == null) {
		  MainUI ui = MainUI.getInstance();
		  ui.displayError("Analysis must be chosen first");
		  return false;
	  }
	  
	  // open country exclusion file and validate country
      // return true if valid
  	  country = country.toLowerCase();
	  Reader file = new Reader();
	  List<String[]> fileCountries = file.readFile("CountryExclusionFile.txt");
		  for (int i = 0; i < fileCountries.size(); i++) {
			  if (fileCountries.get(i)[0].toLowerCase().compareTo(analysisType.toLowerCase()) == 0) {
				  for (int j = 0; j < fileCountries.get(i).length; j++) {
					  if (fileCountries.get(i)[j].toLowerCase().compareTo(country) == 0) {
						  MainUI ui = MainUI.getInstance();
						  ui.displayError("This country is incompatible with the chosen analysis");
						  return false;
					  }
				  }
			  }		  
		  }
		  return true;
	}
  
  /**
   * checks if country selected previously is compatible with the selection start and end years
   * @param startYear
   * @param endYear
   * @return true is period is validated
   * @throws IOException
   */
  private boolean validatePeriod(int startYear, int endYear) throws IOException {
	  if (startYear > endYear)
		  return false;
	  
	  CountryDictionary dict = new CountryDictionary();
	  Hashtable<String, String[]> yearsDict = dict.getDict();
	  String [] yearsList = yearsDict.get(country.toLowerCase());
	  if (startYear < Integer.parseInt(yearsList[1]) || endYear > Integer.parseInt(yearsList[2])) {
			return false;	  
	  }
	  
	  return true;
  }

  
  private boolean validateViewerAddition(String viewer) {
	  
	  String singleDataAnalysis1 = "Average Forest Area";
	  String singleDataAnalysis2 = "Average Government Expenditure on Education";
	  
	  if (analysisType == null) {
		  MainUI UI = MainUI.getInstance();
		  UI.displayError("Analysis must be chosen first");
		  return false;
	  }
		  
	  if (!analysisType.contentEquals(singleDataAnalysis1) && !analysisType.contentEquals(singleDataAnalysis2)) {
		  if (viewer.contentEquals("Pie Chart")) {
			  MainUI ui = MainUI.getInstance();
			  ui.displayError("This viewer is incompatible with the selected analysis");
			  return false;
		  }
	  }
	  return true;
  }
  
  private boolean validateViewerRemoval(String viewer) {
	  
	  if(viewers == null) return false;
	 
	  String currentViewer;
	  Iterator<String> vlist = viewers.iterator();
	  
	  while (vlist.hasNext()) {
		  currentViewer = vlist.next();
		  if (currentViewer.contentEquals(viewer))
			  return true;
	  }
	  MainUI ui = MainUI.getInstance();
	  ui.displayError("Cannot remove viewer");
	  return false;
  }
  
}