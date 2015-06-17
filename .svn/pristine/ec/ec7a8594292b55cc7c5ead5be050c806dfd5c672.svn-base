package bingQuery;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RowTable {
	private final String personFile = "target/input/persone.txt";
	private final String patternFile = "target/input/pattern.txt";
	
	public RowTable() {
		super();
	}

	public void createRow() {
		DBManager db = new DBManager();
		db.createTable(); //fatto la prima volta per creare il database
		List<String> relations = find();
		int contatore =1;
		File file = new File(personFile);
		try {
			Scanner scanner = new Scanner(file);
			while(scanner.hasNextLine()){
				String current = scanner.nextLine();
				for(String s : relations){
					try {
						db.insertUser(contatore, current, s);
					} catch (Exception e) {
						e.printStackTrace();
					}
					contatore++;
				}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * inserisce in una lista tutte le relazioni del file :
	 * sara'  una lista di : was born, bith in, was born in ...
	 */
	public List<String> find(){
		File relation = new File(patternFile);
		List<String> relations = new ArrayList<String>();
		Scanner relationSc;
		try {
			relationSc = new Scanner(relation);
			while(relationSc.hasNextLine())
				relations.add(relationSc.nextLine());
			relationSc.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return relations;
	}
}