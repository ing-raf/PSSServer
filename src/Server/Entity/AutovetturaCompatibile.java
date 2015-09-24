package Server.Entity;


import java.io.Serializable;

import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class AutovetturaCompatibile implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5386990241003066785L;
	@Id
	private String numeroTarga;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "modello")  
	private ModelloAutovettura modello;
	@OneToOne
	@JoinColumn (name = "idSostituzione") 
	private Sostituzione sostituzione;
	
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

	public void setModello(ModelloAutovettura modello) {
		this.modello = modello;
	}

	public Sostituzione getLastRicambio() {
		return this.sostituzione;
		
	}
	
	public void setLastRicambio(Sostituzione sostituzione) {
		this.sostituzione = sostituzione;
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