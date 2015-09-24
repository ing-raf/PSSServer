package Server.Entity;

import java.util.*;
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
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name="idProprietario") private List<AutovetturaCompatibile> autovetturePossedute;
	

	public int getID (){
		return this.Id;
	}
	
	 public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente getCliente (int cod){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Cliente trovato = (Cliente) session.get(Cliente.class, cod) ; 
					
		session.getTransaction().commit();		
		session.close();
					
		return trovato;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setId (int cod){
		this.Id=cod;
	}

	public String getCognome() {
		return this.cognome;
	}

	public Calendar getDataNascita() {
		return this.dataNascita;
	}
	
	public void setNome (String n){
		this.nome = n;
	}
	
	public void setcognome (String c){
		this.cognome = c;
	}
	
	public void setData (Calendar d){
		this.dataNascita = d;
	}
	
	public List<AutovetturaCompatibile> getAutoPossedute() {
		return this.autovetturePossedute;
	}
	
	
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