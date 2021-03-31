package analysis;

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
		
		return reader.retrieveData(url,dataType);
	}
	
	protected String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.contentEquals(CARBON)) {
			indicator = CARBONCODE;
		}else if (type.contentEquals(ENERGY)) {
			indicator = ENERGYCODE;
		}else if (type.contentEquals(AIR)) {
			indicator = AIRCODE;
		}else if (type.contentEquals(FOREST)) {
			indicator = FORESTCODE;
		}else if (type.contentEquals(GDP)) {
			indicator = GDPCODE;
		}else if (type.contentEquals(EDUCATION)) {
			indicator = EDUCATIONCODE;
		}else if (type.contentEquals(BEDS)) {
			indicator = BEDSCODE;
		}else if (type.contentEquals(HEALTHPERCAPITA)) {
			indicator = HEALTHPERCAPITACODE;
		}else if (type.contentEquals(INFANT)) {
			indicator = INFANTCODE;
		}else if (type.contentEquals(HEALTH)) {
			indicator = HEALTHCODE;
		}

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		System.out.println(urlString);
		return urlString;
	}
}
