package Server.DAO;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
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

	public ModelloAutovetturaDAO getModelloAuto (int cod){
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				ModelloAutovetturaDAO b = (ModelloAutovetturaDAO) session.get(ModelloAutovetturaDAO.class, cod) ; 
				
				session.getTransaction().commit();		
				session.close();
				
				if (b != null){
					this.setID(b.getID());
					this.modello = b.getModello();
					this.fornitore = b.getFornitore();
				}
				
				return b;		
				
	}
	
	ModelloAutovetturaDAO update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	ModelloAutovetturaDAO salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	public boolean equals (Object obj) {
		ModelloAutovetturaDAO mod = (ModelloAutovetturaDAO) obj;
		if ((this.fornitore.equals(mod.getFornitore())) && (this.modello.equals(mod.getModello())) && (this.getID() == mod.getID()))
			return true;
		else
			return false;
	}
}