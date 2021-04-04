package analysis;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class Reader {
	
	public Reader() {
	}
	
	public Data retrieveData(String urlString, String type) {
			List<Double> values = new ArrayList<Double>();
			List<Integer> years = new ArrayList<Integer>();
			
			try {
				URL url = new URL(urlString);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.connect();
				int responsecode = conn.getResponseCode();
				if (responsecode == 200) {
					String inline = "";
					Scanner sc = new Scanner(url.openStream());
					while (sc.hasNext()) {
						inline += sc.nextLine();
					}
					sc.close();
					JsonArray jsonArray = new JsonParser().parse(inline).getAsJsonArray();
					int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
					
					for (int i = 0; i < sizeOfResults; i++) {
						years.add(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsInt());
						if (jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").isJsonNull()) {
							values.add(0.0);
						}else {
							values.add(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("value").getAsDouble());
						}
					}
					
					Data data = new Data(type, values, years);
					return data;
				}
			}catch (IOException e) {
				e.printStackTrace();
			}catch (IndexOutOfBoundsException e) {
				return null;
			}
		return null;
	}
	
	
	/**
	 * @param file to be read (country exclusion file / credentials database file)
	 * @return array with contents of country exclusion file/credentials database read
	 */
	public List<String[]> readFile(String file) {
		List<String[]> fileDatabase = new ArrayList<>();
		//String [][] databaseArray = new String [21][2];
		int lineCount = 0;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String readLine = reader.readLine();
			while (readLine != null) {
				fileDatabase.add(readLine.split(","));
				//databaseArray[lineCount] = readLine.split(";");
				lineCount++;
				readLine = reader.readLine();
			}
			reader.close();
	  	    return fileDatabase;
	    }
		catch (IOException e) {}
		// new exception class to handle IOException?

		return null;
	  }
}
