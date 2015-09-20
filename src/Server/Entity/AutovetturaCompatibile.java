package Server.Entity;


import java.io.Serializable;

import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class AutovetturaCompatibile implements Serializable {

	@Id
	private String numeroTarga;
	@ManyToOne
	@JoinColumn (name = "modello")  ModelloAutovettura modello;
	@OneToOne
	@JoinColumn (name = "Id_sostituzione") Sostituzione sostituzione;
	
	public AutovetturaCompatibile (){
	
	}
		
	public void getAuto (String targa){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		AutovetturaCompatibile trovato = (AutovetturaCompatibile) session.get(AutovetturaCompatibile.class, targa) ; 
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		this.numeroTarga = trovato.getNumeroTarga();
		this.modello = trovato.getModello();
		this.sostituzione = trovato.getLastRicambio();
						
		
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
	
	void salva(){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		//salvo l'autovettura compatibile
		session.save(this);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		
	}

}