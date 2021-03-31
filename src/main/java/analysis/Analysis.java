package analysis;

import java.util.Iterator;
import java.util.List;

public abstract class Analysis {
	private Reader reader;
	
	public Analysis() {
		reader = new Reader();
	}
	
	public Result calculate(Selection selection) {
		return null;
	}
	
	public Data readData(Selection selection) {
		String analysisType = selection.getAnalysisType();
		String country = selection.getCountry();
		String startYear = selection.getStartYear();
		String endYear = selection.getEndYear();
		
		String url = createURL(analysisType, country, startYear, endYear);
		
		return reader.retrieveData(url,analysisType);
	}
	
	protected String createURL(String type, String country, String startYear, String endYear) {
		String indicator = "";
		
		if (type.contentEquals("CO2 emissions")) {
			indicator = "EN.ATM.CO2E.PC";
		}else if (type.contentEquals("Energy use")) {
			indicator = "EG.USE.PCAP.KG.OE";
		}else if (type.contentEquals("PM2.5 air pollution, mean annual exposure")) {
			indicator = "EN.ATM.PM25.MC.M3";
		}else if (type.contentEquals("Forest area")) {
			indicator = "AG.LND.FRST.ZS";
		}else if (type.contentEquals("GDP per capita")) {
			indicator = "NY.GDP.PCAP.CD";
		}else if (type.contentEquals("Government expenditure on education, total")) {
			indicator = "SE.XPD.TOTL.GD.ZS";
		}else if (type.contentEquals("Hospital beds")) {
			indicator = "SH.MED.BEDS.ZS";
		}else if (type.contentEquals("Current health expenditure per capita")) {
			indicator = "SH.XPD.CHEX.PC.CD";
		}else if (type.contentEquals("Mortality rate, infant")) {
			indicator = "SP.DYN.IMRT.IN";
		}else if (type.contentEquals("Current health expenditure")) {
			indicator = "SH.XPD.CHEX.GD.ZS";
		}

		String urlString = String.format("http://api.worldbank.org/v2/country/%s/indicator/%s?date=%s:%s&format=json", country, indicator, startYear, endYear);
		
		System.out.println(urlString);
		return urlString;
	}
}
