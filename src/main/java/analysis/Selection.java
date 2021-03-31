package analysis;


import java.util.ArrayList;
import java.util.List;

public class Selection {
  
  private String analysisType, country;
  private int startYear, endYear;
  private List<String> viewers;
  
  public Selection(String analysisType, String country, int startYear, int endYear, List<String> viewers) {
	  this.analysisType = analysisType;
	  this.country = country;
	  this.startYear = startYear;
	  this.endYear = endYear;
	  this.viewers = viewers;
  }
  
  public Selection(String analysisType, String country, int startYear, int endYear) {
	  this.analysisType = analysisType;
	  this.country = country;
	  this.startYear = startYear;
	  this.endYear = endYear;
	  this.viewers = new ArrayList<String>();
  }
  
  public void setAnalysisType(String selectedType) {
    analysisType = selectedType;
  }
  
  public void setCountry(String selectedCountry) {
    if (validateCountry(selectedCountry))
    	country = selectedCountry;
  }
  

  public void setStartYear(int selectedYear) {
    startYear = selectedYear;
  }
  

  public void setEndYear(int selectedYear) {
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


  public int getStartYear() {
    return startYear;
  }

  public int getEndYear() {
    return endYear;
  }

  private boolean validateCountry(String country) {
    // open country exclusion file and validate country
    // return true if valid
	  return false;
  }
  
  private boolean validatePeriod(int startYear, int endYear) {
	  return false;
  }


}
