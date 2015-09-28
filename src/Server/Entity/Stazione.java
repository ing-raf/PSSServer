package Server.Entity;
import javax.persistence.*;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Entity
public class Stazione {

	@Id
	private int ID;	
	@Column
	private String nome;
	@Column
	private String indirizzo;
	@OneToMany (fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn (name ="idStazione")
	private List<Batteria> disponibili;
	
	public Stazione () {
		this.disponibili = new ArrayList<Batteria>();
	}

	public void insertBatteria(Batteria nuova) {
		this.disponibili.add(nuova);
		this.update();
	}
	
	public void removeBatteria(Batteria vecchia) {
		int i = this.findIndex(vecchia);
		this.disponibili.remove(i);
		this.update();
	}
	
	public List<Batteria> getBatterieDisp (){
		return this.disponibili;
	}
	
	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	
	public int getID(){
		return this.ID;
	}
	
	void setID(int id){
		this.ID = id;
	}
	
	void setNome(String nome){
		this.nome = nome;
	}
	
	void setIndirizzo(String indirizzo){
		this.indirizzo = indirizzo;
	}
	
	public void deleteBatteria(Batteria batteria) {
		batteria.elimina(batteria);
	}
		
	public Stazione getStazione (int cod){
		
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		Stazione trovato = null;
		
		session.beginTransaction();

		trovato = (Stazione) session.get(Stazione.class, cod) ; 
					
		session.getTransaction().commit();	
		session.close();
		
		
		if (trovato != null){
			this.ID = trovato.getID();
			this.nome = trovato.getNome();
			this.indirizzo = trovato.getIndirizzo();
			this.disponibili = trovato.getBatterieDisp();
			}
		
		return trovato;
					
		}
	
	Stazione update() {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		session.update(this);
		
		session.getTransaction().commit();	
		session.close();
	
		return this;
	}
	
	Stazione salva(){
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		session.beginTransaction();

		session.save(this);
		
		session.getTransaction().commit();	
		session.close();
		
		return this;
	}	
	
	public boolean equals (Object obj) {
		Stazione staz = (Stazione) obj;
		if ((this.nome.equals(staz.getNome())) && (this.indirizzo.equals(staz.getIndirizzo())) && (this.ID == staz.getID()))
			return true;
		else
			return false;
	}
	
	private int findIndex (Batteria vecchia){
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
	
	
}