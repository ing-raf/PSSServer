package Server.Entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.BadgeDAO;
import Server.DAO.HibernateUtil;
import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;

public class Societa{

	public  static List<ModelloAutovetturaDAO> getListaModelli() {
		List<ModelloAutovetturaDAO> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from ModelloAutovettura");
		
		trovate = (List<ModelloAutovetturaDAO>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}

	/**
	 * 
	 * @param badge
	 * @param codice
	 */
	public static boolean findBadge(int codice) {
		
		if (BadgeDAO.findBadge(codice) == null)
			return false;
		else
			return true;
	}

	public static List<StazioneDAO> getStationList() {
		List<StazioneDAO> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from Stazione");
		
		trovate = (List<StazioneDAO>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}
	
	public static boolean findStation (int id){
		
		if (StazioneDAO.findStation(id) == null)
			return false;
		else
			return true;
	}

}