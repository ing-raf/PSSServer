package Server.Entity;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.BadgeDAO;
import Server.DAO.HibernateUtil;
import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;

public class Societa{

	public  static ArrayList<ModelloAutovettura> getModelList() {
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

	/**
	 * 
	 * @param codice
	 */
	public static boolean findBadge(int codice) {
		
		if (BadgeDAO.findBadge(codice) == null)
			return false;
		else
			return true;
	}

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
	
	public static boolean findStation (int id){
		
		if (StazioneDAO.findStation(id) == null)
			return false;
		else
			return true;
	}

}