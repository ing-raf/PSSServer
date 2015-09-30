package Server.DAO;


import javax.persistence.*;


import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class AutovetturaCompatibileDAO {

	@Id
	private String numeroTarga;
	@ManyToOne (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "modello")  
	private ModelloAutovetturaDAO modello;
	@OneToOne
	@JoinColumn (name = "idSostituzione") 
	private UltimaSostituzioneDAO sostituzione;
	
	public AutovetturaCompatibileDAO (){
	
	}
		
	public AutovetturaCompatibileDAO getAuto (String targa){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		AutovetturaCompatibileDAO trovato = (AutovetturaCompatibileDAO) session.get(AutovetturaCompatibileDAO.class, targa) ; 
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		if (trovato != null){
			this.numeroTarga = trovato.getNumeroTarga();
			this.modello = trovato.getModello();
			this.sostituzione = trovato.getLastRicambio();
		}
		
		return trovato;
		
			}
		
	
	public void setNumeroTarga(String nt){
		this.numeroTarga=nt;
	}
	
	public String getNumeroTarga (){
		return this.numeroTarga;
	}
	

	public ModelloAutovetturaDAO getModello() {
		return this.modello;
	}

	public void setModello(ModelloAutovetturaDAO modello) {
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