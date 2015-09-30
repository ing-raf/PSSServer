package Server.DAO;

import java.util.*;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class ClienteDAO {

	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private Calendar dataNascita;
	@Id
	private int Id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name="idProprietario") 
	private List<AutovetturaCompatibileDAO> autovetturePossedute;
	

	public int getID (){
		return this.Id;
	}
	
	 public ClienteDAO() {
		this.autovetturePossedute = new ArrayList<AutovetturaCompatibileDAO>();
	}

	public ClienteDAO getCliente (int cod){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		ClienteDAO trovato = (ClienteDAO) session.get(ClienteDAO.class, cod) ; 
					
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
	
	void setNome (String n){
		this.nome = n;
	}
	
	void setCognome (String c){
		this.cognome = c;
	}
	
	void setData (Calendar d){
		this.dataNascita = d;
	}
	
	public List<AutovetturaCompatibileDAO> getAutoPossedute() {
		return this.autovetturePossedute;
	}
	
	void insertAutoPossedute(AutovetturaCompatibileDAO nuova) {
		this.autovetturePossedute.add(nuova);
		this.update();
	}
	
	
	ClienteDAO update() {
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
	
	
	
	ClienteDAO salva(){
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