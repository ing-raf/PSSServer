package Server.DAO;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;

import java.util.ArrayList;
import java.util.Calendar;

@Entity
@Table(name = "Sostituzione")
public class SostituzioneDAO {

	@Id
	private int ID;
	@Column 
	private Calendar dataOra;
	@ManyToOne  (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "idStazioneSostituzione")
	private StazioneDAO staz_sostituz;
	@OneToOne
	@JoinColumn (name = "idBatteriaInserita")
	private BatteriaDAO batteria;
	@OneToOne
	@JoinColumn (name = "idAutovetturaCompatibile") 
	private SostituzioneDAO autovettura;
	
	public SostituzioneDAO (){
	}
	
	public Calendar getDataOra() {
		return this.dataOra;
	}

	public int getID (){
		return this.ID;
	}
	public StazioneDAO getStazione() {
		return this.staz_sostituz;
	}
	
	public BatteriaDAO getBatteria () {
		return this.batteria;
	}
	
	public void setDataOra(Calendar dataora) {
		this.dataOra = dataora;
		
	}
	
	public void setID (int cod){
		this.ID = cod;
	}

	public void setBatteria(BatteriaDAO batteria) {
		this.batteria = batteria;
	}
	
	public void setStazione(StazioneDAO staz_sostituz) {
		this.staz_sostituz = staz_sostituz;
	}

	public boolean update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		try{
			
			session.update(this);
			session.getTransaction().commit();	
		} catch(HibernateException e){
			session.getTransaction().rollback();
			return false;
		
		} finally{
				session.close();
		}
		
		return true;
		
	}
	
	
	
	public boolean save(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		try{
			
			session.save(this);
			session.getTransaction().commit();	
		} catch(HibernateException e){
			session.getTransaction().rollback();
			return false;
		
		} finally{
				session.close();
		}
		
		return true;
		
	}
	
	public boolean delete(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		try{
			
			session.delete(this);
			session.getTransaction().commit();
		} catch(HibernateException e){
			session.getTransaction().rollback();
			return false;
		
		} finally{
				session.close();
		}
		
		return true;
	}

	public static SostituzioneDAO findSubstitution(String targa, int id){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from SostituzioneDAO as Sost where Sost.batteria = :batt && Sost.autovettura = :auto");
		query.setParameter("batt",id);
		query.setParameter("auto",targa);
		
		ArrayList<SostituzioneDAO> result = (ArrayList<SostituzioneDAO>)query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return result.get(0);
	}

}