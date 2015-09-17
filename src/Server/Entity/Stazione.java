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
	@OneToMany
	@JoinColumn (name ="disp_batterie") Set<Batteria> disponibii;
	@OneToMany
	@JoinColumn (name = "staz_sostituzione") Set<Sostituzione> sost_stazione;


	public void insertBatteria(Stazione stazione, Batteria nuova) {
		
		nuova.setStazione (stazione);
		nuova.salva();
	}

	
	public ArrayList<Batteria> getListaBatterie(int cicliRicaricaRimanenti) {
		return null;
		// TODO - implement Stazione.getListaBatterie
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param batteria
	 */
	
	public int getID(){
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public void removeBatteria(Batteria batteria) {
		// TODO - implement Stazione.removeBatteria
	}

}