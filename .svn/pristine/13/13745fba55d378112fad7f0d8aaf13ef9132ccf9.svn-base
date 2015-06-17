package secondPhase;

import fileTSVManager.InputNoObject;
import fileTSVManager.Location;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import locationIndex.Stopper;

import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/*
 * Verifica se nella parte di testo estratta dalla query esiste una località
 * contenuta nell'indice
 * 
 */
public class LocationVerify {
	private ListManager gestore;
	private InputNoObject inputNoObject;
	private Location location;
	private Map<String, String> person2Code;
	private Map<String, String> location2Code;
	private Scanner scanner;
	
	private final static int maxHits = 50;
	private final static String invertedIndexPath = "target/invertedIndex";
	private String directoryInputPath = "target/outputSecondPhase";
	private final String outputFileName = "target/finalOut.txt";

	public LocationVerify() {
		this.inputNoObject = new InputNoObject();
		this.location = new Location();
		this.person2Code = inputNoObject.getPerson2Code();
		this.location2Code = location.getLocation2Code();
	}

	public void esegui() {
		try {
			
			File folder = new File(directoryInputPath);
			File[] listOfFiles = folder.listFiles();

			File outputFile = new File(outputFileName);
			PrintWriter writer = new PrintWriter(outputFile);

			for (File file : listOfFiles) {
				if (file.isFile()) {
					String row = analizzaFile(file, writer);
					if (row != "")
						writer.println(row);
				}
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Terminato!");
	}

	private String analizzaFile(File file, PrintWriter writer) {
		String tripla = "";
		try {
			ArrayList<String> list = new ArrayList<String>();
			scanner = new Scanner(file);
			String person = file.getName().replaceAll(".txt", "");

			while (scanner.hasNextLine()) {
				String current = scanner.nextLine();
				list.addAll(trovaLocation(current, writer));
			}

			gestore = new ListManager();
			String locationString = gestore.mostCommonElement(list);
			if (locationString != null) {
				String personCode = person2Code.get(person);
				String locationCode = location2Code.get(locationString);
				String relation = "people.person.place_of_birth";
				tripla = personCode + "\t" + person + "\t" + locationCode
						+ "\t" + locationString + "\t" + relation;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return tripla;
	}

	private ArrayList<String> trovaLocation(String query, PrintWriter writer) {
		ArrayList<String> locationList = new ArrayList<String>();
		try {
			Directory index = FSDirectory.open(new File(invertedIndexPath));

			IndexReader reader = DirectoryReader.open(index);
			IndexSearcher searcher = new IndexSearcher(reader);

			Stopper stop = new Stopper();
			StopAnalyzer analyzer = new StopAnalyzer(Version.LUCENE_47,
					stop.giveStopWords());

			QueryParser queryParser = new QueryParser(Version.LUCENE_47,
					"location", analyzer);

			TopScoreDocCollector collector = TopScoreDocCollector.create(
					maxHits, true);
			Query queryLocation = queryParser.parse(query);
			searcher.search(queryLocation, collector);

			ScoreDoc[] documents = collector.topDocs().scoreDocs;

			for (int i = 0; i < documents.length; i++) {

				int docId = documents[i].doc;
				Document d = searcher.doc(docId);
				locationList.add(d.get("location"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return locationList;
	}
}