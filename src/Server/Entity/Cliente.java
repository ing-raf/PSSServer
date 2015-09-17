package Server.Entity;

import java.util.*;
import java.util.ArrayList;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class Cliente {
	//@Column
	//private ArrayList<AutovetturaCompatibile> autovetturePossedute;
	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private Calendar dataNascita;
	@Id
	private int Id;
	@OneToOne
	@JoinColumn (name="codice_badge") Badge badge_assegnato;
	@OneToMany
	@JoinColumn (name="autovetture") Set<AutovetturaCompatibile> autovetturePosseduta;

	public Set<AutovetturaCompatibile> getListaAutovetture() {
		return this.autovetturePosseduta;
	}

	public String getNome() {
		return this.nome;
	}

	public String getCognome() {
		return this.cognome;
	}

	public Calendar getDataNascita() {
		return this.dataNascita;
	}
	
	public int getId() {
		return this.Id;
	}
	
	public void setNome (String name){
		this.nome = name;
	}
	
	public void setCognome (String cogn){
		this.cognome = cogn;
	}
	
	public void setDataNascita (Calendar data){
		this.dataNascita = data;
	}
	
	public void setId (int id){
		this.Id = id;
	}

	/*public void setListaAutovetture (ArrayList<AutovetturaCompatibile> lista){
		
		int k, dim;
		
		dim = lista.size();
		
		for (k = 0; k <= dim; k++){
			this.autovetturePossedute.add(k,lista.get(k));
		}
	}*/
	Cliente update() {
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
	
	Cliente salva(){
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