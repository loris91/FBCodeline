package locationIndex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

/*
 * Classe per la creazione dell'indice delle localit�
 * legge il file location.tsv e crea l'indice
 */
public class IndexMaker {

	private final static String elencoLocationPath = "target/location.tsv";
	private final static String invertedIndexPath = "target/invertedIndex";
	
	public IndexMaker() {
		super();
	}

	public void createIndex(){

		try {
			Directory index = FSDirectory.open(new File(invertedIndexPath));
			Stopper stop = new Stopper();
			StopAnalyzer analyzer = new StopAnalyzer(Version.LUCENE_47,
					stop.giveStopWords());
			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_47,
					analyzer);
			config.setOpenMode(OpenMode.CREATE_OR_APPEND);
			IndexWriter indexWriter = new IndexWriter(index, config);

			BufferedReader TSVFile = new BufferedReader(new InputStreamReader(
					new FileInputStream(elencoLocationPath), "UTF-8"));

			String dataRow = TSVFile.readLine();

			while (dataRow != null) {
				String linea = dataRow.split("\t", 2)[1];
				Document doc = new Document();
				Field location = new TextField("location", linea,
						Field.Store.YES);
				doc.add(location);
				indexWriter.addDocument(doc);
				dataRow = TSVFile.readLine();
			}

			TSVFile.close();
			indexWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
