package Server.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;



import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;

public class Societa{
	
	private Map<Integer, Badge> badgeList;
	private Map<Integer, Stazione> stationList;
	private ArrayList<ModelloAutovettura> modelList;
	private static Societa theSociety;
	
	private Societa() {
		
	}
	
	public static Societa getSociety() {
		if (theSociety == null) {
			theSociety = new Societa();
			theSociety.badgeList = new HashMap<Integer, Badge>();
			theSociety.stationList = new HashMap<Integer, Stazione>();
			theSociety.modelList = new ArrayList<ModelloAutovettura> ();
		}
		
		return theSociety;
	}
	
	public Badge getBadge(int cod) {
		if ( !theSociety.badgeList.containsKey(cod) ) 
			throw new UnsupportedOperationException();
		
		return theSociety.badgeList.get(cod);
	}
	
	public Stazione getStation(int ID) {
		if ( !theSociety.stationList.containsKey(ID) ) 
			throw new UnsupportedOperationException();
		
		return theSociety.stationList.get(ID);
	}

	
	public  ArrayList<ModelloAutovettura> getModelList() {
		if (theSociety.modelList.isEmpty()){
			ArrayList<ModelloAutovetturaDAO> trovate = ModelloAutovetturaDAO.retrieveModelList();
			for (ModelloAutovetturaDAO m : trovate) 
				theSociety.modelList.add(new ModelloAutovettura (m));
		}
		
		return theSociety.modelList;
	}

	public boolean findBadge(int codice) {
		if ( !theSociety.badgeList.containsKey(codice) ) {
			Badge temp = Badge.getBadge(codice);
			theSociety.badgeList.put(codice, temp);
		}
		
		if (theSociety.badgeList.get(codice) == null ) return false;
		else return true;
	}

	public boolean findStation(int ID) {
		if ( !theSociety.stationList.containsKey(ID) ) {
			Stazione temp = Stazione.getStation(ID);
			theSociety.stationList.put(ID, temp);
		}
		
		if (theSociety.stationList.get (ID) == null) return false;
		else return true;
	}
	
	
	public ArrayList<Stazione> getStationList() {
		if (theSociety.stationList.isEmpty()) {
			ArrayList<StazioneDAO> trovate = StazioneDAO.retrieveStationList();
			for (StazioneDAO m : trovate) 
				theSociety.stationList.put(m.getID(), new Stazione(m));
		}
		ArrayList<Stazione> result = new ArrayList<Stazione> (theSociety.stationList.values());
		
		while ( result.remove(null) );
		
		return result;
	}

}