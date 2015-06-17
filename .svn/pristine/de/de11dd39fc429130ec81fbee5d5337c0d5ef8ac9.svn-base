package fileTSVManager;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * Classe per la gestione dei file input_no_object_first50.tsv e input_no_object_last50.tsv
 * restituisce una mappa con chiave il nome della persona e come valore il suo codice
 * in freeBase
 */
public class InputNoObject {
	
	public InputNoObject() {
		super();
	}
	
	public Map<String, String> getPerson2Code() { 
		Map<String, String> mapOut = new HashMap<String, String>();
		try {
			BufferedReader TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream("target/input/input_no_object_first50.tsv"),
					"UTF-8"));
			String dataRow = TSVFile.readLine();
			while (dataRow != null) {
				String[] linea = dataRow.split("\t", 2);
				mapOut.put(linea[1], linea[0]);
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
			
			TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream("target/input/input_no_object_last50.tsv"),
					"UTF-8"));
			dataRow = TSVFile.readLine();
			while (dataRow != null) {
				String[] linea = dataRow.split("\t", 2);
				mapOut.put(linea[1], linea[0]);
				dataRow = TSVFile.readLine();
			}
			TSVFile.close();
			
			TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream("target/input/input_no_object_50-150.tsv"),
					"UTF-8"));
			dataRow = TSVFile.readLine();
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
