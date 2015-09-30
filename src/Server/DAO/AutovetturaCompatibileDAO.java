package Server.DAO;


import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
@Table(name = "AutovetturaCompatibile")
public class AutovetturaCompatibileDAO {

	@Id
	private String numeroTarga;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "modello")  
	private ModelloAutovetturaDAO modello;
	@OneToOne
	@JoinColumn (name = "idSostituzione") 
	private UltimaSostituzioneDAO sostituzione;
	
	public AutovetturaCompatibileDAO (){
	
	}
		
	
	public void setNumberPlate (String nt){
		this.numeroTarga=nt;
	}
	
	public String getNumberPlate (){
		return this.numeroTarga;
	}
	

	public ModelloAutovetturaDAO getModel() {
		return this.modello;
	}

	public void setModel(ModelloAutovetturaDAO modello) {
		this.modello = modello;
	}

	public UltimaSostituzioneDAO getLastSubstitution() {
		return this.sostituzione;
		
	}
	
	public void setLastRicambio(UltimaSostituzioneDAO sostituzione) {
		this.sostituzione = sostituzione;
	}
	
	public static AutovetturaCompatibileDAO findCar (String targa){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		AutovetturaCompatibileDAO trovato = (AutovetturaCompatibileDAO) session.get(AutovetturaCompatibileDAO.class, targa) ; 
		
		session.getTransaction().commit();		
		session.close();

		return trovato;
		
		}

	public boolean save(){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		try {
			session.save(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	
		return true;
		
	}
	
	public boolean update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		try {
			session.update(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
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

		try {
			session.delete(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	
		return true;
	}

}