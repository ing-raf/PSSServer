package Server.Entity;
import java.util.ArrayList;

import javax.persistence.*;

import org.hibernate.Query;
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
//	@ManyToOne
//	@JoinColumn (name = "modello_autovettura") private ModelloAutovettura modello_compatibile;
	@ManyToOne 
	@JoinColumn(name = "disp_batterie") private Stazione stazione_disp;
	
	public Batteria (){
	}
	
	public Batteria (int id){
		Batteria b = this.findBatteria(id);
		this.costoSostituzione = b.getCostoSostituzione();
		this.cicliRicaricaRimanenti = b.getCicliRicarica();
//		this.modello_compatibile = b.getModelloAutovettura();
	}
	
	
	
	public Batteria(int id, float costosostituzione, int maxcicliricarica, ModelloAutovettura mod) {		
		this.ID = id;
		this.costoSostituzione = costosostituzione;
		this.cicliRicaricaRimanenti = maxcicliricarica;
//		this.modello_compatibile=mod;
		this.salva();
	}
	
	
	public void setCicliRicarica (int num_cicli){
		this.cicliRicaricaRimanenti=num_cicli;
	}

	public int getID() {
		return this.ID;
	}

	public float getCostoSostituzione() {
		return this.costoSostituzione;
	}

	public int getCicliRicarica() {
		return this.cicliRicaricaRimanenti;
	}

//	public ModelloAutovettura getModelloAutovettura() {
//		return this.modello_compatibile;
		
//	}
	
	
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

	 Batteria findBatteria (int cod){
		//apro la sessione e la transazione
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Batteria trovato = (Batteria) session.get(Batteria.class, cod) ; 
				
				//chiudo la transazione e la sessione
				session.getTransaction().commit();		
				session.close();
				
				return trovato;
	}
	Batteria elimina (int id){
		Batteria b = this.findBatteria(id);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		//salvo il cliente
		session.delete(b);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		return b;
	}
	
	ArrayList<Batteria> findBatterie (){
		ArrayList<Batteria> trovate = new ArrayList<Batteria>();
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from Batteria as s where s.stazione_disp.ID = :cod ");
		query.setParameter("cod", 1);
		trovate = (ArrayList<Batteria>)query.list();
				
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}
	

}