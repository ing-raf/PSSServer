package Server.Entity;

import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.Calendar;

@Entity
public class Sostituzione {

	@Id
	private int ID;
	@Column 
	private Calendar dataOra;
	@ManyToOne  (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "idStazioneSostituzione")
	private Stazione staz_sostituz;
	@OneToOne
	@JoinColumn (name = "idBatteriaInserita")
	private Batteria batteria;
	
	public Sostituzione (){
	}
	
	public Calendar getDataOra() {
		return this.dataOra;
	}

	
	public int getID (){
		return this.ID;
	}
	public Stazione getStazione() {
		return this.staz_sostituz;
	}

	void setDataOra(Calendar dataora) {
		this.dataOra = dataora;
		
	}
	
	public void setID (int cod){
		this.ID = cod;
	}

	void setBatteria(Batteria batteria) {
		this.batteria = batteria;
	}

	public Batteria getBatteria () {
		return this.batteria;
	}
	
	public Batteria updateSostituzione (Stazione s, Batteria b){
		Batteria vecchia = this.getBatteria();
		this.batteria = b;
		this.staz_sostituz = s;
		this.dataOra = Calendar.getInstance();
		this.update();
		return vecchia;
	}
	

	void update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		
	}
	
	
	
	void salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		
	}

	void setStazione(Stazione staz_sostituz) {
		this.staz_sostituz = staz_sostituz;
	}
	

}