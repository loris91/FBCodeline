package firstPhase;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/*
 * Prende in input tutti i file di una cartella, ogni file contiene massimo 50 URL che sono
 * il risultato di una query Bing su Person+Pattern
 * Per ogni pagina WEB verifica la presenta della String "Person+Pattern" e in caso
 * positivo ritorna lo specchio di 50 caratteri succevvivo alla stringa
 */
public class ExtractLocation {

	private int Max_Page_Size = 10 * 1024 * 1024;
	private String directoryInputPath = "target/outputQuery/";
	private String directoryOutPath = "target/outputFirtPhase/";
	
	public ExtractLocation() {
		super();
	}

	
	/*
	 * Prende una cartella e analizza ogni file in esso contanuti
	 */
	public void esegui() {
		File folder = new File(directoryInputPath);
		File[] listOfFiles = folder.listFiles();

		int count = 0;
		for (File file : listOfFiles) {
			System.out.println("File #" + count++ + " :" + file.getPath());
			if (file.isFile()) {
				extract(file);
			}
		}
	}

	/*
	 * Da ogni file estrai gli url in esso contenuti e effettua una richiesta 
	 * jsoup alla pagina web e successivamente ne analizza il contenuto
	 */
	private void extract(File file) {
		try {
			File inputFile = new File(file.getPath());
			File outputFile = null;
			PrintWriter writer = null;
			Scanner scanner = new Scanner(inputFile);

			String person = file.getName().split("&", 2)[0];
			String relation = file.getName().split("&", 2)[1].replaceAll(".txt", "");

			while (scanner.hasNextLine()) {
				String current = scanner.nextLine();
				try {
					Document doc = Jsoup.connect(current).timeout(10*1000)
							.maxBodySize(Max_Page_Size).get();
					Element body = doc.body();
					String tbody = body.toString();
					String result = estraiLocation(tbody, person + " "
							+ relation);
					if (result != "") {
						if (outputFile==null) {
							outputFile = new File(directoryOutPath+ file.getName());
							writer = new PrintWriter(outputFile);
						}
						writer.println(result);
					}
				} catch (Exception ex) {
					System.out.println("Pagina non analizzata");
				}
			}
			scanner.close();
			if (writer!=null)
				writer.close();
		} catch (Exception e) {
			System.out.println("Attenzione errore su file");
			e.printStackTrace();
		}
	}

	
	/*
	 * Prende in input il campo body di una pagina html convertito in stringa
	 * verifica la presenza dell'intera query nel body e in caso positivo
	 * ritorna lo specchio di 50 caratteri succesivo alla query
	 */
	private static String estraiLocation(String tbody, String query) {
		String subString = "";
		while (tbody.contains(query)) {
			int inizio = tbody.indexOf(query);
			subString = subString.concat(tbody.substring(
					inizio + query.length(), inizio + query.length() + 50)
					+ "\n");
			tbody = tbody.substring(inizio + query.length() + 51);
		}
		subString = subString.replaceAll(
				"[\\\\\\|!\"�\\$%&/()='?^+\\[\\]{}#@;.,:_<>-]", " ");
		subString = subString.replaceAll("\n", "");
		return subString;

	}

}
