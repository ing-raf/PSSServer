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
public class UltimaSostituzioneDAO {

	@Id
	//@GeneratedValue
	private int ID;
	@Column 
	private Calendar dataOra;
	@ManyToOne  (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name = "idStazioneSostituzione")
	private StazioneDAO staz_sostituz;
	@OneToOne
	@JoinColumn (name = "idBatteriaInserita")
	private BatteriaDAO batteria;
	@OneToOne (mappedBy="sostituzione")
	@JoinColumn (name = "idAutovettura") 
	private AutovetturaCompatibileDAO autovettura;
	
	public UltimaSostituzioneDAO (){
	}
	
	public Calendar getDateHour() {
		return this.dataOra;
	}

	public int getID (){
		return this.ID;
	}
	public StazioneDAO getStation() {
		return this.staz_sostituz;
	}
	
	public BatteriaDAO getBattery () {
		return this.batteria;
	}
	
	public void setDateHour(Calendar dataora) {
		this.dataOra = dataora;
		
	}
	
	void setID (int cod){
		this.ID = cod;
	}
	
	public void setID() {
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(this.autovettura.getNumberPlate());
		this.ID = dao.getID();
	}

	public void setBattery(BatteriaDAO batteria) {
		this.batteria = batteria;
	}
	
	public void setStation(StazioneDAO staz_sostituz) {
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

	public static UltimaSostituzioneDAO findSubstitution(String targa){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("select Sost from UltimaSostituzioneDAO as Sost inner join Sost.autovettura as a where a.numeroTarga = :auto");
		query.setParameter("auto",targa);
		ArrayList<UltimaSostituzioneDAO> result = (ArrayList<UltimaSostituzioneDAO>) query.list();
		
		session.getTransaction().commit();
		session.close();
		
		if (result.isEmpty() == true)
			return null;
		else
			return result.get(0) ;
	}

}