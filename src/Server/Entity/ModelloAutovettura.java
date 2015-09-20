package Server.Entity;



import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class ModelloAutovettura implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3330338838905026475L;
	@Id
	private int ID;
	@Column
	private String fornitore;
	@Column 
	private String modello;

	
	public ModelloAutovettura(){
		
	}
	
	public int getId () {
		return this.ID;
	}
	public String getModello() {
		return this.modello;
	}

	public String getFornitore() {
		return this.fornitore;
	}
	
	public void setFornitore (String forn){
		this.fornitore = forn;
	}

	public void setModello (String model){
		this.modello=model;
	}
	
	
	public void getModelloAuto (int cod){
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				ModelloAutovettura b = (ModelloAutovettura) session.get(ModelloAutovettura.class, cod) ; 
				
				session.getTransaction().commit();		
				session.close();
				this.ID=b.getId();
				this.modello = b.getModello();
				this.fornitore = b.getFornitore();
			
				
				
	}
	
	ModelloAutovettura update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	ModelloAutovettura salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
}