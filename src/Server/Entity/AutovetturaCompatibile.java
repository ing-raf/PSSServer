package Server.Entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "AutovetturaCompatibile")
public class AutovetturaCompatibile {
	@Column
	ModelloAutovettura modello;
	@Id
	private string numeroTarga;

	public ModelloAutovettura getModello() {
		return this.modello;
	}

	public Sostituzione getLastRicambio() {
		// TODO - implement AutovetturaCompatibile.getLastRicambio
	}

}