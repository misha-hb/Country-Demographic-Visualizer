package analysis;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public abstract class Analysis {
	
	protected static final String CARBON = "CO2 Emissions";
	protected static final String CARBONCODE = "EN.ATM.CO2E.PC";
	
	protected static final String HEALTH = "Current Health Expenditure";
	protected static final String HEALTHCODE = "SH.XPD.CHEX.GD.ZS";
	
	protected static final String HEALTHPERCAPITA = "Current Health Expenditure per Capita";
	protected static final String HEALTHPERCAPITACODE = "SH.XPD.CHEX.PC.CD";
	
	protected static final String ENERGY = "Energy Use";
	protected static final String ENERGYCODE = "EG.USE.PCAP.KG.OE";
	
	protected static final String FOREST = "Forest Area";
	protected static final String FORESTCODE = "AG.LND.FRST.ZS";
	
	protected static final String GDP = "GDP per Capita";
	protected static final String GDPCODE = "NY.GDP.PCAP.CD";
	
	protected static final String EDUCATION = "Government Expenditure on Education, Total";
	protected static final String EDUCATIONCODE = "SE.XPD.TOTL.GD.ZS";
	
	protected static final String BEDS = "Hospital Beds";
	protected static final String BEDSCODE = "SH.MED.BEDS.ZS";
	
	protected static final String INFANT = "Mortality Rate, Infant";
	protected static final String INFANTCODE = "SP.DYN.IMRT.IN";
	
	protected static final String AIR = "PM2.5 Air Pollution, Mean Annual Exposure";
	protected static final String AIRCODE = "EN.ATM.PM25.MC.M3";
	
	private Reader reader;
	
	
	public Analysis() {
		reader = new Reader();
	}
	
	public Reader getReader() {
		return this.reader;
	}
	
	public abstract Result calculate(Selection selection);
	
	public Data readData(String dataType, String dataCode, String country, String startYear, String endYear) {
		
		String url = createURL(dataCode, country, startYear, endYear);
		
		Data d = reader.retrieveData(url, dataType);
		
		return d;
	}
	
	protected String createURL(String code, String country, String startYear, String endYear) {

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", getAbbreviation(country), code, startYear, endYear);
		
		System.out.println(urlString);
		return urlString;
	}
	
	protected double computeAverage(Data data) {
			
		double total = 0.0;
		double average;
		double curr;
		
		List<Double> values = data.getValues();
		List<Integer> years = data.getYears();
		
		Iterator<Double> i1 = values.iterator();
		
		while (i1.hasNext()) {
			curr = i1.next();
			System.out.println(curr);
			total += curr;
		}
		
		average = total / years.size();
		System.out.println(average);
		return average;
	}
	
	//public static void main(String[] args) {
		
		//Selection selection = new Selection();//new Selection("Average Forest Area", "can", "2000", "2020");
		//AnalysisFactory f = new AnalysisFactory();
		//Analysis s = f.createAnalysis(selection);
		//s.calculate(selection);
		
	//}
	
	
	  /**
	   * @param abbrevation of the country specified
	   * @return abbreviation from the countries file for corresponding country
	   * @throws IOException
	   */
	  private String getAbbreviation(String country) throws IOException {
		  country = country.toLowerCase();
		  Reader reader = new Reader();
		  List<String[]> abvList = reader.readFile("CountriesFile.txt");
		  for (int i = 0; i < abvList.size(); i++) {
			  if (country.compareTo(abvList.get(i)[1].toLowerCase()) == 0) {
				  return abvList.get(i)[5];
				  }
				}
		  return "abbreviation not found";
		  }
}

