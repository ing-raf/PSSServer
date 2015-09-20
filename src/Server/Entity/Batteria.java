package Server.Entity;


import java.io.Serializable;

import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class Batteria implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -980961376913777720L;
	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name = "modello_autovettura") private ModelloAutovettura modello_compatibile;
	
	public Batteria (){
	}
	
	
	
	public Batteria(int id, float costosostituzione, int maxcicliricarica, ModelloAutovettura mod) {		
		this.ID = id;
		this.costoSostituzione = costosostituzione;
		this.cicliRicaricaRimanenti = maxcicliricarica;
		this.modello_compatibile = mod;
		this.salva();
	}
	
	public int getID() {
		return this.ID;
	}
	

	public float getCostoSostituzione() {
		return this.costoSostituzione;
	}
	
	public ModelloAutovettura getModello() {
		return this.modello_compatibile;
	}
	
	public int getCicliRicarica() {
		return this.cicliRicaricaRimanenti;
	}

	public void setCicliRicarica(int cicli) {
		this.cicliRicaricaRimanenti = cicli;
	}
	
	
	Batteria update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	Batteria salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}

	public void getBatteria (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Batteria b = (Batteria) session.get(Batteria.class, cod) ; 
				
		session.getTransaction().commit();		
		session.close();
				
		this.ID = b.getID();
		this.costoSostituzione = b.getCostoSostituzione();
		this.cicliRicaricaRimanenti = b.getCicliRicarica();
		this.modello_compatibile = b.getModello();
				
				
	}
	
	void elimina (Batteria b){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.delete(b);
		
		session.getTransaction().commit();		
		session.close();
		
	}
	

	

}