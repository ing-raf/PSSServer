package Server.Entity;
import javax.persistence.*;
import java.util.Calendar;
@Entity
public class Sostituzione {
	@Id
	private int ID;
	@Column 
	private Calendar dataOra;
	@ManyToOne 
	@JoinColumn (name = "stazione_sostituzione") Stazione staz_sostittuz;
	@OneToOne
	@JoinColumn (name = "batteria_sostituita") Batteria batteria;
	
	public Calendar getDataOra() {
		return this.dataOra;
	}

	
	public int getID (){
		return this.ID;
	}
	public Stazione getStazione() {
		// TODO - implement Sostituzione.getStazione
		return this.staz_sostittuz;
	}

	public void setDataOra(Calendar dataora) {
		this.dataOra = dataora;
		
	}
	
	public void setID (int cod){
		this.ID = cod;
	}

	public Batteria getBatteria () {
		return this.batteria;
	}
	

	/*public void setAutovettura() {
		// TODO - implement Sostituzione.setAutovettura
	}

	public void setStazione() {
		// TODO - implement Sostituzione.setStazione
	}

	public void setBatteria() {
		// TODO - implement Sostituzione.setBatteria
	}*/

}