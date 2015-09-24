package Server.Entity;
import javax.persistence.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.Calendar;
@Entity
public class Sostituzione implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3810346218832520036L;
	@Id
	private int ID;
	@Column 
	private Calendar dataOra;
	@ManyToOne  (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "idStazioneSostituzione") Stazione staz_sostittuz;
	@OneToOne
	@JoinColumn (name = "idBatteriaInserita") Batteria batteria;
	
	public Sostituzione (){
	}
	
	public Calendar getDataOra() {
		return this.dataOra;
	}

	
	public int getID (){
		return this.ID;
	}
	public Stazione getStazione() {
		return this.staz_sostittuz;
	}

	public void setDataOra(Calendar dataora) {
		this.dataOra = dataora;
		
	}
	
	public void setID (int cod){
		this.ID = cod;
	}

	public Batteria getBatteria () {
		return this.batteria;
	}
	
	public Batteria updateSostituzione (Stazione s, Batteria b){
		System.out.println("Sono in updateSostituzione");
		Batteria temp = this.batteria;
		this.batteria = b;
		this.staz_sostittuz = s;
		this.dataOra = Calendar.getInstance();
		this.update();
		return temp;
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
	

}