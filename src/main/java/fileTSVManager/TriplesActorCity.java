package fileTSVManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


/*
 * Classe per la gestione del file triples_actor_city_200.tsv
 * restituisce una mappa con chiave il nome della persona e come valore
 * il suo luogo di nascita
 */
public class TriplesActorCity {
	
	public TriplesActorCity() {
		super();
	}
	
	public Map<String, String> getPerson2City() {
		Map<String, String> mapOut = new HashMap<String, String>();
		try {
			BufferedReader TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream("target/triples_actor_city_200.tsv"),
					"UTF-8"));
			String dataRow = TSVFile.readLine();
			while (dataRow != null) {
				String[] linea = dataRow.split("\t", 5);
				mapOut.put(linea[1], linea[3]);
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapOut;
	}
	

}
