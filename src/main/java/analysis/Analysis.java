package analysis;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Contains methods needed for analyzing the data
 */
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
	
	/**
	 * creates a reader object so that data can be retrieved using the retrieveData method 
	 */
	public Analysis() {
		reader = new Reader();
	}
	
	/**
	 * @return the reader object
	 */
	public Reader getReader() {
		return this.reader;
	}
	
	/**
	 * abstract method for calculating data
	 * @param selection contains country, start year, end year, analysis type
	 * @return
	 */
	public abstract Result calculate(Selection selection);
	
	/**
	 * reads information stored in the selection object to create a UML string to be used to access World Bank Database
	 * invokes the retrieveData method to get the data
	 * @param dataType type of data
	 * @param dataCode
	 * @param country country in the selection
	 * @param startYear start year in selection
	 * @param endYear end year in selection
	 * @return
	 */
	public Data readData(String dataType, String dataCode, String country, String startYear, String endYear) {
		
		try {
			
		//url is created and used to retrieve data from World Bank Database
		String url = createURL(dataCode, country, startYear, endYear);
		
		Data d = reader.retrieveData(url, dataType);
		
		return d;
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * creates URL
	 * @param code
	 * @param country selected by user
	 * @param startYear selected by user
	 * @param endYear selected by user
	 * @return the urlString
	 * @throws IOException
	 */
	protected String createURL(String code, String country, String startYear, String endYear) throws IOException {

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", getAbbreviation(country), code, startYear, endYear);
		
		return urlString;
	}
	
	/**
	 * computes average of data objects if needed
	 * @param data containing values and years of the data
	 * @return
	 */
	protected double computeAverage(Data data) {
			
		double total = 0.0;
		double average;
		double curr;
		
		//values and years are obtained from the data object
		List<Double> values = data.getValues();
		List<Integer> years = data.getYears();
		
		//iterates over values obtained from the data object
		Iterator<Double> i1 = values.iterator();
		
		//prints all values and adds it to the total
		while (i1.hasNext()) {
			curr = i1.next();
			total += curr;
		}
		
		//total is divided by the number of years to obtain the average and this is printed
		average = total / years.size();
		return average;
	}

	
	  /**
	   * @param abbrevation of the country specified
	   * @return abbreviation from the countries file for corresponding country
	   * @throws IOException
	   */
	  private String getAbbreviation(String country) {
		  country = country.toLowerCase();
		  
		  //uses the readFile method in the reader class to read contents of the CountriesFile
		  Reader reader = new Reader();
		  List<String[]> abvList = reader.readFile("CountriesFile.txt");
		  for (int i = 0; i < abvList.size(); i++) {
			  
			  //goes through the list until it finds the matching country and returns the abbreviation
			  if (country.compareTo(abvList.get(i)[1].toLowerCase()) == 0) {
				  return abvList.get(i)[5];
			  }
		  }
		  return null;
	  }
}

