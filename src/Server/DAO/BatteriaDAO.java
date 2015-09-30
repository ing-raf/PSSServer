package Server.DAO;

import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class BatteriaDAO {

	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name = "idModello") private ModelloAutovetturaDAO modello_compatibile;
	
	public BatteriaDAO (){
	}
	
	
	
	public BatteriaDAO(int id, float costosostituzione, int maxcicliricarica, ModelloAutovetturaDAO mod) throws Exception {		
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
	
	public ModelloAutovetturaDAO getModello() {
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
	
	
	void setModello(ModelloAutovetturaDAO modello_compatibile) {
		this.modello_compatibile = modello_compatibile;
	}



	BatteriaDAO update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();	
		session.close();
	
		return this;
	}
	
	BatteriaDAO salva() throws Exception{
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

	public BatteriaDAO getBatteria (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		BatteriaDAO b = (BatteriaDAO) session.get(BatteriaDAO.class, cod) ; 
				
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
	
	void elimina (BatteriaDAO b){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		session.delete(b);
			
		session.getTransaction().commit();	
		session.close();
		
	}
	
	

	

}