package analysis;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class CountryDictionary {
	
	private static CountryDictionary dict;
	private Hashtable<String, String[]> countriesDict = new Hashtable<String,String[]>();
	
	public static CountryDictionary getDictionary() {
		if (dict == null)
			dict = new CountryDictionary();
		return dict;
	}
	
	
	/**
	 * @param file to be read
	 * created dictionary from file in the form of (country name: [abbreviation, start year, end year])
	 */
	private CountryDictionary() {
		
		Reader reader = new Reader();
		List<String[]> countriesDatabase = reader.readFile("CountriesFile.txt");
	
		for (int i = 0; i < countriesDatabase.size(); i++) {
			String [] valueList = new String[3];
			valueList[0] = countriesDatabase.get(i)[5].toLowerCase();
			String startYear = countriesDatabase.get(i)[countriesDatabase.get(i).length - 2].toLowerCase();
			String endYear = countriesDatabase.get(i)[countriesDatabase.get(i).length - 1].toLowerCase();
	
			if (startYear.compareTo("Now") == 0 || startYear.compareTo("now") == 0)
				startYear = "2021";
			if (endYear.compareTo("Now") == 0 || endYear.compareTo("now") == 0)
				endYear = "2021";

			valueList[1] = startYear;
			valueList[2] = endYear;
			countriesDict.put(countriesDatabase.get(i)[1].toLowerCase(), valueList);
		}
	}
	
	
	public Hashtable<String, String[]> getDict() {
		return countriesDict;
	  }
}
