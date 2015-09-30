package Server.Entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.Badge;
import Server.DAO.HibernateUtil;
import Server.DAO.ModelloAutovettura;
import Server.DAO.Stazione;

public class Societa{

	public  static List<ModelloAutovettura> getListaModelli() {
		List<ModelloAutovettura> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from ModelloAutovettura");
		
		trovate = (List<ModelloAutovettura>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}

	/**
	 * 
	 * @param badge
	 * @param codice
	 */
	public static boolean findBadge(Badge badge, int codice) {
		
		if (badge.getBadge(codice) == null)
			return false;
		else
			return true;
	}

	public static List<Stazione> getListaStazioni() {
		List<Stazione> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from Stazione");
		
		trovate = (List<Stazione>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}
	
	public static boolean findStazione (Stazione stazione, int id){
		
		if (stazione.getStazione(id) == null)
			return false;
		else
			return true;
	}

}