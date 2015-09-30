package Server.DAO;


import javax.persistence.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;

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

	

	public ClienteDAO getCliente() {
		return this.possessore;
	}
	
	public int getCodice (){
		return this.codice;
	}
	
	public float getCredito (){
		return this.creditoResiduo;
	}
	
	
	void setCodice(int cod){
		this.codice = cod;
	}
	
	public void setCredito(float cred){
		this.creditoResiduo = cred;
		this.update();
	}
	
	void setCliente (ClienteDAO p){
		this.possessore=p;
	}
	
	public BadgeDAO () {
		
	}
	
	public BadgeDAO (int codice, float creditoResiduo, ClienteDAO possessore) {
		this.codice = codice;
		this.creditoResiduo = creditoResiduo;
		this.possessore = possessore;
		this.salva();
	}


	public BadgeDAO getBadge (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		BadgeDAO trovato = (BadgeDAO) session.get(BadgeDAO.class, cod);
				
		session.getTransaction().commit();		
		session.close();
			
			if (trovato != null){
				this.codice = trovato.getCodice();
				this.creditoResiduo = trovato.getCredito();
				this.possessore = trovato.getCliente();
				}
		return trovato;
	}
	
	 BadgeDAO update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	BadgeDAO salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}	
}