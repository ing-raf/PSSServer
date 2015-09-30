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
	public static boolean findBadge(BadgeDAO badge, int codice) {
		
		if (badge.getBadge(codice) == null)
			return false;
		else
			return true;
	}

	public static List<StazioneDAO> getListaStazioni() {
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
	
	public static boolean findStazione (StazioneDAO stazione, int id){
		
		if (stazione.getStazione(id) == null)
			return false;
		else
			return true;
	}

}