package secondPhase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * Classe di supporto per la gestione della lista delle località
 * prende in input una lista di stringhe che rappresentano localita'
 * e ritorna la Stringa che ha una maggiore frequenza nella collezione
 */
public class ListManager {
	
	public ListManager() {
		super();
	}

	public String mostCommonElement(List<String> list) {	     
	    Map<String, Integer> map = new HashMap<String, Integer>();
	     
	    for(int i=0; i< list.size(); i++) {	         
	        Integer frequency = map.get(list.get(i));
	        if(frequency == null) {
	            map.put(list.get(i), 1);
	        } else {
	            map.put(list.get(i), frequency+1);
	        }
	    }
	     
	    String mostCommonKey = null;
	    int maxValue = -1;
	    for(Map.Entry<String, Integer> entry: map.entrySet()) {	         
	        if(entry.getValue() > maxValue) {
	            mostCommonKey = entry.getKey();
	            maxValue = entry.getValue();
	        }
	    }	     
	    return mostCommonKey;
	}
}
