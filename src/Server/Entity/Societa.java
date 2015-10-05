package Server.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.HibernateUtil;
import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;

public class Societa{
	
	private Map<Integer, Badge> badgeList;
	private Map<Integer, Stazione> stationList;
	private static Societa theSociety;
	
	private Societa() {
		theSociety.badgeList = new HashMap<Integer, Badge>();
	}
	
	public static Societa getSociety() {
		if (theSociety == null) theSociety = new Societa();
		
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

	@SuppressWarnings("unchecked")
	public static ArrayList<ModelloAutovettura> getModelList() {
		List<ModelloAutovetturaDAO> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from ModelloAutovetturaDAO");
		
		trovate = (List<ModelloAutovetturaDAO>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		
		ArrayList<ModelloAutovettura> ritorno = new ArrayList<ModelloAutovettura>( trovate.size() );
		
		for (ModelloAutovetturaDAO m : trovate) ritorno.add(new ModelloAutovettura(m));
		
		return ritorno;
	}

	public static boolean findBadge(int codice) {
		Badge temp = Badge.getBadge(codice);
		if (temp == null)
			return false;
		else{
			theSociety.badgeList.put(codice, temp);
			return true;
		}
	}

	public static boolean findStation(int ID) {
		Stazione temp = Stazione.getStation(ID);
		if (temp == null)
			return false;
		else{
			theSociety.stationList.put(ID, temp);
			return true;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Stazione> getStationList() {
		List<StazioneDAO> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from StazioneDAO");
		
		trovate = (List<StazioneDAO>)query.list();
				
		session.getTransaction().commit();		
		session.close();


		ArrayList<Stazione> ritorno = new ArrayList<Stazione>( trovate.size() );
		
		for (StazioneDAO m : trovate) ritorno.add(new Stazione(m));
		
		return ritorno;
	}

}