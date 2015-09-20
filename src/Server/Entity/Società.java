package Server.Entity;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Società {

	public  static List<ModelloAutovettura> getListaModelli() {
		List<ModelloAutovettura> trovate;
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from ModelloAutovettura");
		
		trovate = (List<ModelloAutovettura>)query.list();
				
		//chiudo la transazione e la sessione
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
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from Stazione");
		
		trovate = (List<Stazione>)query.list();
				
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}
	
	public static boolean findStazione (Stazione stazione, int id){
		stazione.getStazione(id);
		if (stazione == null)
			return false;
		else
			return true;
	}

}