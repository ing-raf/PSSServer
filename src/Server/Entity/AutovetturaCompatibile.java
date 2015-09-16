package Server.Entity;
import javax.persistence.*;



@Entity
public class AutovetturaCompatibile {
	@Column
	ModelloAutovettura modello;
	@Id
	private String numeroTarga;

	public ModelloAutovettura getModello() {
		return this.modello;
	}

	public Sostituzione getLastRicambio() {
		return null;
		// TODO - implement AutovetturaCompatibile.getLastRicambio
	}

}