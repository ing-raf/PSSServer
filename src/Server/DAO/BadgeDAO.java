package Server.DAO;


import javax.persistence.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.HibernateUtil;
@Entity
public class BadgeDAO {
	@Id
	private int codice;
	@Column
	private float creditoResiduo;
	@OneToOne
	@JoinColumn(name="idCliente") ClienteDAO possessore;

	public BadgeDAO(){
		
	}

	public ClienteDAO getClient() {
		return this.possessore;
	}
	
	public int getCode (){
		return this.codice;
	}
	
	public float getCredit (){
		return this.creditoResiduo;
	}
	
	
	public void setCode(int cod){
		this.codice = cod;
	}
	
	public void setCredit(float cred){
		this.creditoResiduo = cred;
		this.update();
	}
	
	public void setClient (ClienteDAO p){
		this.possessore = p;
	}

	public static BadgeDAO findBadge (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		BadgeDAO trovato = (BadgeDAO) session.get(BadgeDAO.class, cod);
				
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