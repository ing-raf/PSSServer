package Server.Entity;


import javax.persistence.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import Server.Entity.HibernateUtil;
@Entity
public class Badge {
	@Id
	private int codice;
	@Column
	private float creditoResiduo;
	@OneToOne
	@JoinColumn(name="Id_cliente") Cliente possessore;

	

	public Cliente getCliente() {
		return this.possessore;
	}
	
	public int getCodice (){
		return this.codice;
	}
	
	public float getCredito (){
		return this.creditoResiduo;
	}
	
	
	public void setCodice(int cod){
		this.codice = cod;
	}
	
	public void setCredito(float cred){
		this.creditoResiduo = cred;
	}
	
	public void setCliente (Cliente p){
		this.possessore=p;
	}
	
	public Badge () {
		
	}
	
	
	
	public void getBadge (int cod){
		//apro la sessione e la transazione
				SessionFactory sf = HibernateUtil.getSessionFactory();
				Session session = sf.openSession();
				session.beginTransaction();

				Badge trovato = (Badge) session.get(Badge.class, cod);
				
				this.codice = trovato.getCodice();
				this.creditoResiduo = trovato.getCredito();
				this.possessore = trovato.getCliente();
				
				//chiudo la transazione e la sessione
				session.getTransaction().commit();		
				session.close();

	}
	
	 Badge update() {
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	Badge salva(){
		//apro la sessione e la transazione
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		//chiudo la transazione e la sessione
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}	
}