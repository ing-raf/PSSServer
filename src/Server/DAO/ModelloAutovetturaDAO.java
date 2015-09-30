package Server.DAO;

import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.HibernateException;



@Entity
@Table (name = "ModelloAutovettura")
public class ModelloAutovetturaDAO {

	@Id
	private int ID;
	@Column
	private String fornitore;
	@Column 
	private String modello;

	
	public ModelloAutovetturaDAO(){
		
	}
	
	public int getID () {
		return this.ID;
	}
	public String getModello() {
		return this.modello;
	}

	public String getFornitore() {
		return this.fornitore;
	}
	
	void setFornitore (String forn){
		this.fornitore = forn;
	}

	void setModello (String model){
		this.modello=model;
	}
	
	
	void setID(int ID) {
		this.ID = ID;
	}

	public static ModelloAutovetturaDAO findModelloAuto (String mod, String forni){
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Query query = session.createQuery("from ModelloAutivetturaDAO as m where m.modello = :model && m.fornitore = :prod");
				query.setParameter("model",mod);
				query.setParameter("prod",forni);
				
				ArrayList<ModelloAutovetturaDAO> result = (ArrayList<ModelloAutovetturaDAO>)query.list();
				
				session.getTransaction().commit();		
				session.close();
				
				
				return result.get(0);		
				
	}
	
	public boolean update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		try {
			session.update(this);
		
			session.getTransaction().commit();
		}catch (HibernateException ex){
			session.getTransaction().rollback();
			return false;
			
		} finally {
			session.close();
		}
		
		return true;
	}
	
	public boolean save(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		try{
		session.save(this);
		
			session.getTransaction().commit();
		}catch (HibernateException ex){
			session.getTransaction().rollback();
			return false;
		
		} finally {
			session.close();
		}
	
		return true;
	}
	
	public boolean delete(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		try{
			
			session.delete(this);
			session.getTransaction().commit();
		} catch(HibernateException e){
			session.getTransaction().rollback();
			return false;
		
		} finally{
				session.close();
		}
		
		return true;
	}
	
	public boolean equals (Object obj) {
		ModelloAutovetturaDAO mod = (ModelloAutovetturaDAO) obj;
		if ((this.fornitore.equals(mod.getFornitore())) && (this.modello.equals(mod.getModello())) && (this.getID() == mod.getID()))
			return true;
		else
			return false;
	}
}