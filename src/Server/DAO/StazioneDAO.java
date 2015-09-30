package Server.DAO;
import javax.persistence.*;

import java.util.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
@Table(name = "Stazione")
public class StazioneDAO {

	@Id
	private int ID;	
	@Column
	private String nome;
	@Column
	private String indirizzo;
	@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name ="idStazione")
	private List<BatteriaDAO> disponibili;
	
	public StazioneDAO () {
		this.disponibili = new ArrayList<BatteriaDAO>();
	}
	
	public List<BatteriaDAO> getAvailableBatteries (){
		return this.disponibili;
	}
	
	public String getAddress() {
		return this.indirizzo;
	}

	public String getName() {
		return this.nome;
	}

	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public void setName(String nome){
		this.nome = nome;
	}
	
	public void setAddress(String indirizzo){
		this.indirizzo = indirizzo;
	}
	
		
	public static StazioneDAO findStation (int cod){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		StazioneDAO trovato = (StazioneDAO) session.get(StazioneDAO.class, cod) ; 
					
		session.getTransaction().commit();	
		session.close();
		
		return trovato;
					
		}
	
	public boolean save(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		try {
			session.save(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	
		return true;
	}	
	
	public boolean update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		try {
			session.update(this);
			session.getTransaction().commit();	
		} catch (HibernateException he) {
			session.getTransaction().rollback();
			return false;
		} finally {
			session.close();
		}
	
		return true;
	}
	
	public boolean delete(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

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
	
	public boolean equals (Object obj) {
		StazioneDAO stazione = (StazioneDAO) obj;
		if ((this.nome.equals(stazione.getName())) 
				&& (this.indirizzo.equals(stazione.getAddress())) 
				&& (this.ID == stazione.getID()))
			return true;
		else
			return false;
	}
	
/*	private int findIndex (BatteriaDAO vecchia){
		int index=0,k=0;
		boolean hit = false;
		while (k<this.disponibili.size() || hit != true){
			if (this.disponibili.get(k).getID() == vecchia.getID()){
				index = k;
				hit = true;
				}
			k++;
			
		}
		return index;
	}
*/	
	
}