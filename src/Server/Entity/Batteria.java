package Server.Entity;


import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class Batteria {
	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name = "modello_autovettura") private ModelloAutovettura modello_compatibile;
	//@ManyToOne 
	//@JoinColumn(name = "disp_batterie") private Stazione stazione_disp;
	
	public Batteria (){
	}
	
	
	
	public Batteria(int id, float costosostituzione, int maxcicliricarica, ModelloAutovettura mod) {		
		this.ID = id;
		this.costoSostituzione = costosostituzione;
		this.cicliRicaricaRimanenti = maxcicliricarica;
		this.modello_compatibile = mod;
		this.salva();
	}
	
	
	/*public void setStazione (Stazione s){
		this.stazione_disp = s;
	}*/
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


	
	
	Batteria update() {
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
	
	Batteria salva(){
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

	public void getBatteria (int cod){
		//apro la sessione e la transazione
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Batteria b = (Batteria) session.get(Batteria.class, cod) ; 
				
				//chiudo la transazione e la sessione
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

		//salvo il cliente
		session.delete(b);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
	}
	

	

}