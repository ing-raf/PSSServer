package Server.Entity;
import javax.persistence.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



@Entity
public class Batteria {
	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name="modello_autovettura") private ModelloAutovettura modello_compatibile;
	@ManyToOne
	@JoinColumn (name="Id_Stazione") private Stazione stazione_associata;
	/*@OneToOne 
	@JoinColumn (name="Id_Sostituzione") private Sostituzione sostituzione_batteria;*/
	
	public Batteria (){
	}
	
	public Batteria (int id){
		Batteria b = this.findBatteria(id);
		this.costoSostituzione = b.getCostoSostituzione();
		this.cicliRicaricaRimanenti = b.getCicliRicarica();
		this.modello_compatibile = b.getModelloAutovettura();
		this.stazione_associata = b.getStazione();
	}
	
	public Stazione getStazione () {
		return this.stazione_associata;
	}
	
	public Batteria(int id, float costosostituzione, int maxcicliricarica, ModelloAutovettura mod) {		
		this.ID = id;
		this.costoSostituzione = costosostituzione;
		this.cicliRicaricaRimanenti = maxcicliricarica;
		this.modello_compatibile=mod;
		this.salva();
	}
	
	void setStazione(Stazione staz){
		this.stazione_associata = staz;
	}
	
	public void setCicliRicarica (int num_cicli){
		this.cicliRicaricaRimanenti=num_cicli;
	}

	public int getID() {
		return this.ID;
	}

	public float getCostoSostituzione() {
		return this.costoSostituzione;
	}

	public int getCicliRicarica() {
		return this.cicliRicaricaRimanenti;
	}

	public ModelloAutovettura getModelloAutovettura() {
		return this.modello_compatibile;
		
	}
	
	
	Batteria update() {
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
	
	Batteria salva(){
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

	 Batteria findBatteria (int cod){
		//apro la sessione e la transazione
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Batteria trovato = (Batteria) session.get(Batteria.class, cod) ; 
				
				//chiudo la transazione e la sessione
				session.getTransaction().commit();		
				session.close();
				
				return trovato;
	}
	Batteria elimina (int id){
		Batteria b = this.findBatteria(id);
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		//salvo il cliente
		session.delete(b);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		return b;
	}

}