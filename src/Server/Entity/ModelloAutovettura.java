package Server.Entity;



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
		//apro la sessione e la transazione
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				ModelloAutovettura b = (ModelloAutovettura) session.get(ModelloAutovettura.class, cod) ; 
				
				//chiudo la transazione e la sessione
				session.getTransaction().commit();		
				session.close();
				this.ID=b.getId();
				this.modello = b.getModello();
				this.fornitore = b.getFornitore();
			
				
				
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