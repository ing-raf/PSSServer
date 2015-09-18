package Server.Entity;
import javax.persistence.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




@Entity
public class Stazione {

	@Id
	private int ID;	
	@Column
	private String nome;
	@Column
	private String indirizzo;
	@OneToMany
	@JoinColumn (name ="disp_batterie") Set<Batteria> disponibii;
	

	public Stazione () {
		
	}
	public Stazione (int id){
		
		Stazione s = new Stazione ();
		this.nome = s.getNome();
		this.indirizzo = s.getIndirizzo();
		this.disponibii=s.getBatterieDisp();
	}
	public void insertBatteria(Batteria nuova) {
		
		nuova.update();
	}
	public Set<Batteria> getBatterieDisp (){
		return this.disponibii;
	}
	
	public ArrayList<Batteria> getListaBatterie() {
		return this.findBatterie();
	}

	
	public ArrayList<Batteria> findEsausta() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public void removeBatteria(Batteria batteria) {
		// TODO - implement Stazione.removeBatteria
	}
	
	ArrayList<Batteria> findBatterie (){
		ArrayList<Batteria> trovate = new ArrayList<Batteria>();
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
				
		Query query = session.createQuery("from Batteria as s where s.stazione_associata.ID = :cod");
		query.setParameter("cod", this.ID);
		trovate = (ArrayList<Batteria>)query.list();
				
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		return trovate;
	}
	
	 Stazione findStazione (int cod){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Stazione trovato = (Stazione) session.get(Stazione.class, cod) ; 
					
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
					
		return trovato;
		}
	
	Stazione update() {
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
	
	Stazione salva(){
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