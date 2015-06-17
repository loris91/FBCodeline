package main;


import firstPhase.ExtractPattern;
import firstPhase.ExtractLocation;
import bingQuery.Query;
import bingQuery.RowTable;
import locationIndex.IndexMaker;
import secondPhase.LocationVerify;

public class Main {
	
	public static void main(String[] args){
		RowTable table = new RowTable();
		Query query = new Query();
		IndexMaker indexMaker = new IndexMaker();
		ExtractLocation extractLocation = new ExtractLocation();
		ExtractPattern extractPattern = new ExtractPattern();
		LocationVerify locationVerify = new LocationVerify();
		
		//viene creata e popolata la tabella
		//table.createRow();		
		
		//vengono eseguite le query e scritti i file con le 50 URL recuperate
		try {
			//query.executeQuery(0, 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Crea l'indice delle località
		//indexMaker.createIndex();
		
		//vengono estratte le locazioni dalle URL
		//extractLocation.esegui();		
		
		//extractPattern.esegui();
		
		//verifica le location e genera le triple person+location+relation
		locationVerify.esegui();
	}

}
