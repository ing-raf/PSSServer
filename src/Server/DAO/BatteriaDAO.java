package Server.DAO;

import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




@Entity
@Table (name = "Batteria")

public class BatteriaDAO {

	@Id
	private int ID;
	@Column
	private float costoSostituzione;
	@Column
	private int cicliRicaricaRimanenti;
	@ManyToOne
	@JoinColumn (name = "idModello") private ModelloAutovetturaDAO modello;
	
	public BatteriaDAO (){
	}
	
	public int getID() {
		return this.ID;
	}
	

	public float getCostSubstitution() {
		return this.costoSostituzione;
	}
	
	public ModelloAutovetturaDAO getModel() {
		return this.modello;
	}
	
	public int getCyclesRecharge() {
		return this.cicliRicaricaRimanenti;
	}

	public void setID(int id) {
		this.ID = id;
	}
	
	public void setCostSubstitution(float costoSostituzione) {
		this.costoSostituzione = costoSostituzione;
	}



	public void setCyclesRecharge(int cicli) {
		this.cicliRicaricaRimanenti = cicli;
	}
	
	
	public void setModel(ModelloAutovetturaDAO modello_compatibile) {
		this.modello = modello_compatibile;
	}



	public boolean update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		try{
			session.update(this);
			session.getTransaction().commit();
		}catch(HibernateException he){
			session.getTransaction().rollback();
			return false;
		}finally{
			session.close();
		}
		return true;
	}
	
	
	public boolean save() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		try{
			session.save(this);
			session.getTransaction().commit();
		}catch(HibernateException he){
			session.getTransaction().rollback();
			return false;
		}finally{
			session.close();
		}
		return true;
	}

	public static BatteriaDAO findBattery (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		BatteriaDAO trovato = (BatteriaDAO) session.get(BatteriaDAO.class, cod) ; 
				
		session.getTransaction().commit();		
		session.close();
		
		return trovato;
				
	}
	
	public boolean delete (){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		try {
			session.delete(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	
		return true;
		
	}
	
	public boolean equals (Object obj){
		BatteriaDAO b = (BatteriaDAO) obj;  
		if ((b.getID() == this.getID()) &&
				(Float.compare(b.getCostSubstitution(), this.getCostSubstitution()) == 0) && 
				(b.getCyclesRecharge() == this.getCyclesRecharge())) 
			return true;
		else
			return false;
	
	}
}