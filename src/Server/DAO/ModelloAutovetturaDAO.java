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
	//@GeneratedValue
	private int ID;
	@Column
	private String fornitore;
	@Column 
	private String modello;

	
	public ModelloAutovetturaDAO(){
		
	}
	
	int getID () {
		return this.ID;
	}
	public String getModel() {
		return this.modello;
	}

	public String getBrand() {
		return this.fornitore;
	}
	
	public void setBrand (String forn){
		this.fornitore = forn;
	}

	public void setModel (String model){
		this.modello=model;
	}
	
	
	 void setID(int ID) {
		this.ID = ID;
	}
	
	public void setID () {
		ModelloAutovetturaDAO mod = ModelloAutovetturaDAO.findModelloAuto(this.modello, this.fornitore);
		this.ID = mod.getID();
	}

	@SuppressWarnings("unchecked")
	public static ModelloAutovetturaDAO findModelloAuto (String mod, String forni){
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Query query = session.createQuery("from ModelloAutovetturaDAO as m where m.modello = :model and m.fornitore = :prod");
				query.setParameter("model",mod);
				query.setParameter("prod",forni);
				
				ArrayList<ModelloAutovetturaDAO> result = (ArrayList<ModelloAutovetturaDAO>)query.list();
				
				session.getTransaction().commit();		
				session.close();
				
				if (result.isEmpty() == true)
					return null;
				else
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
		if ((this.fornitore.equals(mod.getBrand())) && (this.modello.equals(mod.getModel())) && (this.getID() == mod.getID()))
			return true;
		else
			return false;
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<ModelloAutovetturaDAO> retriveModelList (){
		ArrayList<ModelloAutovetturaDAO> trovate;
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from ModelloAutovetturaDAO");
		
		trovate = (ArrayList<ModelloAutovetturaDAO>)query.list();
				
		session.getTransaction().commit();		
		session.close();
		
		return trovate;
	}
	
	
}