package bingQuery; 

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.catalina.util.Base64;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Query {

	private String accountKey="xvWpJjA5ihsRckldXs708jumD2tn3mzsIsFhaKSIgsc";
	private String accountKeyBytes = Base64.encode((accountKey + ":" + accountKey).getBytes());
	private String accountKeyEnc = accountKeyBytes;
	private URL url;

	public void executeQuery(int start,int end) throws Exception{
		DBManager db = new DBManager();
		while(start <= end){
			String user = db.userExtractor(start);
			String predicato = db.PredicatoExtractor(start);

			String query ="\""+user+" "+predicato+"\"";
			System.out.println(start);
			String nomefile = "target/outputQuery/"+user+ "&"+predicato+".txt";
			query = query.replaceAll(" ", "%20");
			start++;

			try {
				url = new URL(
						"https://api.datamarket.azure.com/Bing/Search/Web?Query=%27" + query + "%27&$top=50&$format=json");
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Authorization", "Basic " + accountKeyEnc);
				conn.setRequestProperty("Accept", "application/json");
				BufferedReader br = new BufferedReader(new InputStreamReader(
						(conn.getInputStream())));
				String output=br.readLine();

				PrintWriter f = new PrintWriter(nomefile);
				try {
					writeOnFile(f,output);
				} catch (JSONException e) {
					e.printStackTrace();
				}
				conn.disconnect();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public void writeOnFile(PrintWriter f,String output){
		JSONObject jObject;
		jObject = new JSONObject(output);
		final JSONObject geodata = jObject.getJSONObject("d");
		final JSONArray pippo =geodata.getJSONArray("results");
		final int n = pippo.length();
		for (int i = 0; i < n; ++i) {
			final JSONObject person = pippo.getJSONObject(i);
			String  s =person.getString("Url");
			f.println(s);
		}
		f.close();
		
	}
	

}
