package main;

import java.util.List;

public class Selection {
  
  String analysisType, country;
  int startYear, endYear;
  List<String> viewers;
  
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


  public int getStartYear() {
    return startYear;
  }

  public int getEndYear() {
    return endYear;
  }

  private boolean validateCountry(String country) {
    // open country exclusion file and validate country
    // return true if valid
  }
  
  private boolean validatePeriod(int startYear, int endYear) {
  }


}
