package Server.DAO;

import java.util.*;
import javax.persistence.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.Entity.Cliente;

import org.hibernate.Query;

@Entity
@Table(name = "Cliente")
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
	

	public static ClienteDAO findClient (String n, String c, Calendar d){

		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from ClienteDAO as cl where cl.nome = :name and cl.cognome = :cogn and cl.dataNascita = :data");
		query.setParameter("name", n);
		query.setParameter("cogn", c);
		query.setParameter("data", d);
		
		ArrayList<ClienteDAO> result = (ArrayList<ClienteDAO>)query.list();
		
		session.getTransaction().commit();		
		session.close();
		
		if (result.isEmpty() == true)
			return null;
		else
			return result.get(0);
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
	
	public boolean equals (Object obj){
		ClienteDAO c = (ClienteDAO) obj;  

		if ((this.nome.equals(c.getName())) &&
				(this.cognome.equals(c.getSurname())) && 
				(this.dataNascita.equals(c.getBirthDate())) &&
				(this.autovetturePossedute.size() == c.getOwnedCars().size())) {
			for (int i = 0; i < this.autovetturePossedute.size(); i++){
				if (!(c.getOwnedCars().get(i).equals(this.autovetturePossedute.get(i))))
					return false;	
			}
			return true;
		}
			
		else{
			System.err.println("Errore size " + this.autovetturePossedute.size() + " " +c.getOwnedCars().size() );
			return false;}
	
	}
}