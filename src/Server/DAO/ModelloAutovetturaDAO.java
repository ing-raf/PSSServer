package Server.DAO;

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

	public ModelloAutovettura getModelloAuto (int cod){
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				ModelloAutovettura b = (ModelloAutovettura) session.get(ModelloAutovettura.class, cod) ; 
				
				session.getTransaction().commit();		
				session.close();
				
				if (b != null){
					this.setID(b.getID());
					this.modello = b.getModello();
					this.fornitore = b.getFornitore();
				}
				
				return b;		
				
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
	
	public boolean equals (Object obj) {
		ModelloAutovettura mod = (ModelloAutovettura) obj;
		if ((this.fornitore.equals(mod.getFornitore())) && (this.modello.equals(mod.getModello())) && (this.getID() == mod.getID()))
			return true;
		else
			return false;
	}
}