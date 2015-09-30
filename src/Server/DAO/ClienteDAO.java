package Server.DAO;

import java.util.*;
import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class ClienteDAO {

	@Column
	private String nome;
	@Column
	private String cognome;
	@Column
	private Calendar dataNascita;
	@Id
	private int Id;
	
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name="idProprietario") 
	private List<AutovetturaCompatibileDAO> autovetturePossedute;
	
	public ClienteDAO() {
		this.autovetturePossedute = new ArrayList<AutovetturaCompatibileDAO>();
	}
	
	public int getID (){
		return this.Id;
	}

	public String getName() {
		return this.nome;
	}	

	public String getSurname() {
		return this.cognome;
	}

	public Calendar getBirthDate() {
		return this.dataNascita;
	}
	
	public void setName (String n){
		this.nome = n;
	}
	
	public void setID (int cod){
		this.Id=cod;
	}
	
	public void setSurname (String c){
		this.cognome = c;
	}
	
	public void setDate (Calendar d){
		this.dataNascita = d;
	}
	
	public List<AutovetturaCompatibileDAO> getOwnedCars() {
		return this.autovetturePossedute;
	}
	
	public void setOwnedCars(AutovetturaCompatibileDAO auto) {
		this.autovetturePossedute.add(auto);
	}
	

	public static ClienteDAO findClient (int cod){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		ClienteDAO trovato = (ClienteDAO) session.get(ClienteDAO.class, cod) ; 
					
		session.getTransaction().commit();		
		session.close();
					
		return trovato;
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
}