package Server.Entity;

import javax.persistence.*;
import javax.transaction.Transaction;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.metamodel.source.MappingException;



@Entity
public class Batteria {

	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name = "idModello") private ModelloAutovettura modello_compatibile;
	
	public Batteria (){
	}
	
	
	
	public Batteria(int id, float costosostituzione, int maxcicliricarica, ModelloAutovettura mod) throws Exception {		
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

	void setID(int id) {
		this.ID = id;
	}
	
	void setCostoSostituzione(float costoSostituzione) {
		this.costoSostituzione = costoSostituzione;
	}



	public void setCicliRicarica(int cicli) {
		this.cicliRicaricaRimanenti = cicli;
	}
	
	
	void setModello(ModelloAutovettura modello_compatibile) {
		this.modello_compatibile = modello_compatibile;
	}



	Batteria update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			session.beginTransaction();

			session.update(this);
		
			session.getTransaction().commit();	
		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		} finally {
			session.close();
		}

		
		return this;
	}
	
	Batteria salva() throws Exception{
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
	
		try {
			session.beginTransaction();
			session.save(this);
			session.getTransaction().commit();		
			session.close();
		}catch (Exception ex) {
	        session.getTransaction().rollback();
	        session.close();
	 		System.err.println("exc nell'entity");
	 		throw ex;			
		}
		
		return this;
	}

	public Batteria getBatteria (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		Batteria b = (Batteria) session.get(Batteria.class, cod) ; 
				
		session.getTransaction().commit();		
		session.close();
		if (b != null)	{
			this.ID = b.getID();
			this.costoSostituzione = b.getCostoSostituzione();
			this.cicliRicaricaRimanenti = b.getCicliRicarica();
			this.modello_compatibile = b.getModello();
		}
		
		return b;
				
	}
	
	void elimina (Batteria b){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			session.beginTransaction();

			session.delete(b);
			
			session.getTransaction().commit();	
		} catch (Exception ceccis) {
			session.getTransaction().rollback();
			throw ceccis;
		} finally {	
			session.close();
			
		}
		
	}
	
	

	

}