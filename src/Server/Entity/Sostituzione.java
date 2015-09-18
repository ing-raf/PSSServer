package Server.Entity;
import javax.persistence.*;
import java.util.Calendar;
@Entity
public class Sostituzione {
	@Id
	private int ID;
	@Column 
	private Calendar data;
	@Column
	private Calendar ora;
	@ManyToOne 
	@JoinColumn (name = "stazione_sostituzione") Stazione staz_sostittuz;
	
	public Calendar getData() {
		return this.data;
	}

	public Calendar getOra() {
		return this.ora;
	}

	public Stazione getStazione() {
		// TODO - implement Sostituzione.getStazione
		return null;
	}

	public void setData() {
		// TODO - implement Sostituzione.setData
	}

	public void setOra() {
		// TODO - implement Sostituzione.setOra
	}

	public void setAutovettura() {
		// TODO - implement Sostituzione.setAutovettura
	}

	public void setStazione() {
		// TODO - implement Sostituzione.setStazione
	}

	public void setBatteria() {
		// TODO - implement Sostituzione.setBatteria
	}

}