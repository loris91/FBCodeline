package firstPhase;

import fileTSVManager.TriplesActorCity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;


/*
 * Prende in input tutti i file della cartella "target/out" i cui file
 * contengono l'esito delle query person+pattern
 * Per ogni file verifica se la località estratta dalla query corrisponde
 * alla località di nascita della persona, in caso positivo scrive su un file 
 * il pattern che è stato utilizzato.
 * 
 * L'output di questa classe viene elaborato con Apache Pig per ricreare una
 * graduatoria dei pattern trovati 
 * 
 */
public class ExtractPattern {
	private TriplesActorCity tac;
	private final String directoryPath = "target/outputFirtPhase";
	private final String outputFileName = "target/positivePattern.txt";

	public void esegui() {
		try {			
			File folder = new File(directoryPath);
			File[] listOfFiles = folder.listFiles();
			
			File outputFile = new File(outputFileName);
			PrintWriter writer = new PrintWriter(outputFile);
			
			tac = new TriplesActorCity();
			Map<String, String> person2city = tac.getPerson2City();		

			for (File file : listOfFiles) {
				if (file.isFile()) {				
					verifica(person2city,file,writer);
				}
			}
			
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Terminato!");
	}

	private void verifica(Map<String, String> person2city, File file,
			PrintWriter writer) {
		
		try {
			Scanner scanner = new Scanner(file);
			
			System.out.println(file.getName());
			String person = file.getName().split("&", 2)[0];
			String relation = file.getName().split("&", 2)[1].replace(".txt", "");
			String location = person2city.get(person);

			while (scanner.hasNextLine()) {
				String current = scanner.nextLine();
				if (current.contains(location)) {
					writer.println(relation);
				}				 
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	
}

