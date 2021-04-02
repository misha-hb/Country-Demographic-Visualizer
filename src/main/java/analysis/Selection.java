package analysis;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Selection {
  
  private String analysisType, country, startYear, endYear;
  private List<String> viewers;
  
  
  //public Selection() {
	  //this.analysisType = null;
	  //this.country = null;
	  //this.startYear = null;
	  //this.endYear = null;
	  //this.viewers = null;
  //}
  public Selection(String analysisType, String country, String startYear, String endYear, List<String> viewers) {
	  this.analysisType = analysisType;
	  this.country = country;
	  this.startYear = startYear;
	  this.endYear = endYear;
	  this.viewers = viewers;
  }
  
  public Selection(String analysisType, String country, String startYear, String endYear) {
	  this.analysisType = analysisType;
	  this.country = country;
	  this.startYear = startYear;
	  this.endYear = endYear;
	  this.viewers = new ArrayList<String>();
  }
  
  public void setAnalysisType(String selectedType) {
    analysisType = selectedType;
  }
  
  public void setCountry(String selectedCountry) throws IOException {
    if (validateCountry(selectedCountry))
    	country = selectedCountry;
  }
  

  public void setStartYear(String selectedYear) {
    startYear = selectedYear;
  }
  

  public void setEndYear(String selectedYear) {
    endYear = selectedYear;
  }
  
  public void addViewer(String selectedViewer) {
    viewers.add(selectedViewer);
  }
  
  public void removeViewer(String selectedViewer) {
    viewers.remove(selectedViewer);
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

  private boolean validateCountry(String country) throws IOException {
      // open country exclusion file and validate country
      // return true if valid
  	  Reader file = new Reader();
  	  String [] analysisKind = file.readFile("CountryExclusionFile.txt");
  	  String [] countries;
  	  for (int i = 0; i < analysisKind.length; i++) {
  		  if (analysisKind[i].toLowerCase().compareTo(analysisType) == 0) {
  			  countries = analysisKind[i].split(":");
  			  for (int m = 0; m < countries.length; m++) {
  				  if (countries[m].toLowerCase().compareTo(country) == 0)
  					  return false;
  			  }
  		  }		  
  	  }
  	  return true;
    }
  
  private boolean validatePeriod(int startYear, int endYear) {
	  return false;
  }


}
