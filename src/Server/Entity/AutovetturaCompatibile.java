package Server.Entity;
import java.util.ArrayList;

import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class AutovetturaCompatibile {

	@Id
	private String numeroTarga;
	@ManyToOne
	@JoinColumn (name = "modello")  ModelloAutovettura modello;
	@OneToOne
	@JoinColumn (name = "Id_sostituzione") Sostituzione sostituzione;
	
	public AutovetturaCompatibile (){
	
	}
		
	AutovetturaCompatibile findAuto (String targa){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		AutovetturaCompatibile trovato = (AutovetturaCompatibile) session.get(AutovetturaCompatibile.class, targa) ; 
						
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
						
		return trovato;
			}
		
	
	
	public void setNumeroTarga(String nt){
		this.numeroTarga=nt;
	}
	
	public String getNumeroTarga (){
		return this.numeroTarga;
	}
	

	public ModelloAutovettura getModello() {
		return this.modello;
	}

	public Sostituzione getLastRicambio() {
		return this.sostituzione;
		
	}
	
	AutovetturaCompatibile salva(){
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