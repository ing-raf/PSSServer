package Server.Entity;
import javax.persistence.*;
import java.util.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.engine.profile.Fetch;
//import org.hibernate.annotations.FetchMode;




@Entity
public class Stazione {

	@Id
	private int ID;	
	@Column
	private String nome;
	@Column
	private String indirizzo;
	@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name ="disp_batterie")
	private List<Batteria> disponibili;
	

	public Stazione () {
	}

	public void insertBatteria(Batteria nuova) {
		this.disponibili.add(nuova);
		this.update();
	}
	public List<Batteria> getBatterieDisp (){
		return this.disponibili;
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
		batteria.elimina(batteria);
	}
	
	
	
	public void getStazione (int cod){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Stazione trovato = (Stazione) session.get(Stazione.class, cod) ; 
					
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		this.ID = trovato.getID();
		this.nome = trovato.getNome();
		this.indirizzo = trovato.getIndirizzo();
		this.disponibili = trovato.getBatterieDisp();
					
		
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