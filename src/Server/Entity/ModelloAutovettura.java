package Server.Entity;

import java.util.Set;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class ModelloAutovettura {
	@Id
	private int ID;
	@Column
	private String fornitore;
	@Column 
	private String modello;

	
	
	
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
	
	
	
	ModelloAutovettura update() {
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	ModelloAutovettura salva(){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		//salvo il cliente
		session.save(this);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
}