package analysis;

import java.util.Iterator;
import java.util.List;

public abstract class Analysis {
	
	protected static final String CARBON = "CO2 emissions";
	protected static final String CARBONCODE = "EN.ATM.CO2E.PC";
	
	protected static final String ENERGY = "Energy use";
	protected static final String ENERGYCODE = "EG.USE.PCAP.KG.OE";
	
	protected static final String AIR = "PM2.5 air pollution, mean annual exposure";
	protected static final String AIRCODE = "EN.ATM.PM25.MC.M3";
	
	protected static final String FOREST = "Forest area";
	protected static final String FORESTCODE = "AG.LND.FRST.ZS";
	
	protected static final String GDP = "GDP per capita";
	protected static final String GDPCODE = "NY.GDP.PCAP.CD";
	
	protected static final String EDUCATION = "Government expenditure on education, total";
	protected static final String EDUCATIONCODE = "SE.XPD.TOTL.GD.ZS";
	
	protected static final String BEDS = "Hospital beds";
	protected static final String BEDSCODE = "SH.MED.BEDS.ZS";
	
	protected static final String HEALTHPERCAPITA = "Current health expenditure per capita";
	protected static final String HEALTHPERCAPITACODE = "SH.XPD.CHEX.PC.CD";
	
	protected static final String INFANT = "Mortality rate, infant";
	protected static final String INFANTCODE = "SP.DYN.IMRT.IN";
	
	protected static final String HEALTH = "Current health expenditure";
	protected static final String HEALTHCODE = "SH.XPD.CHEX.GD.ZS";
	
	private Reader reader;
	
	
	public Analysis() {
		reader = new Reader();
	}
	
	public Reader getReader() {
		return this.reader;
	}
	
	public abstract Result calculate(Selection selection);
	
	public Data readData(String dataType, String country, String startYear, String endYear) {
		
		String url = createURL(dataType, country, startYear, endYear);
		
		Data d = reader.retrieveData(url,dataType);
		
		return d;
	}
	
	protected String createURL(String type, String country, String startYear, String endYear) {

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, type, startYear, endYear);
		
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
	
	public static void main(String[] args) {
		
		//Selection selection = new Selection("Average Government Expenditure on Education", "can", "2005", "2010");
		//AnalysisFactory f = new AnalysisFactory();
		//Analysis s = f.createAnalysis(selection);
		//s.calculate(selection);
		
	}
}
