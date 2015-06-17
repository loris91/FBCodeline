package fileTSVManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Classe per la gestione del file location.tsv
 * restituisce una mappa con chiave la località e come valore il suo codice in freeBase
 */
public class Location {
	
	public Location() {
		super();
	}
	
	public Map<String, String> getLocation2Code() {
		Map<String, String> mapOut = new HashMap<String, String>();
		try {
			BufferedReader TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream("target/input/location.tsv"),
					"UTF-8"));
			String dataRow = TSVFile.readLine();
			while (dataRow != null) {
				String[] linea = dataRow.split("\t", 2);
				mapOut.put(linea[1], linea[0]);
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapOut;
	}

}
