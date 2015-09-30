package Server.DAO;


import javax.persistence.*;


import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import Server.DAO.HibernateUtil;
@Entity
public class Badge {
	@Id
	private int codice;
	@Column
	private float creditoResiduo;
	@OneToOne
	@JoinColumn(name="idCliente") Cliente possessore;

	

	public Cliente getCliente() {
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
	
	void setCliente (Cliente p){
		this.possessore=p;
	}
	
	public Badge () {
		
	}
	
	public Badge (int codice, float creditoResiduo, Cliente possessore) {
		this.codice = codice;
		this.creditoResiduo = creditoResiduo;
		this.possessore = possessore;
		this.salva();
	}


	public Badge getBadge (int cod){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		Badge trovato = (Badge) session.get(Badge.class, cod);
				
		session.getTransaction().commit();		
		session.close();
			
			if (trovato != null){
				this.codice = trovato.getCodice();
				this.creditoResiduo = trovato.getCredito();
				this.possessore = trovato.getCliente();
				}
		return trovato;
	}
	
	 Badge update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}
	
	Badge salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();		
		session.close();
		
		return this;
	}	
}