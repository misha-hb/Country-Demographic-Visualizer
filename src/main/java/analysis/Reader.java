package analysis;

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
					int size = jsonArray.size();
					int sizeOfResults = jsonArray.get(1).getAsJsonArray().size();
					List<Double> years = new ArrayList<Double>();
					
					for (int i = 0; i < sizeOfResults; i++) {
						years.add(jsonArray.get(1).getAsJsonArray().get(i).getAsJsonObject().get("date").getAsDouble());
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
			}
		
		return null;
	}
}
