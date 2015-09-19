package Server.Entity;
import javax.persistence.*;
import java.util.*;

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
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Stazione trovato = (Stazione) session.get(Stazione.class, cod) ; 
					
		session.getTransaction().commit();		
		session.close();
		
		this.ID = trovato.getID();
		this.nome = trovato.getNome();
		this.indirizzo = trovato.getIndirizzo();
		this.disponibili = trovato.getBatterieDisp();
					
		
		}
	
	Stazione update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	Stazione salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}	
	
}