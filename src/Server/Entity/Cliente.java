package Server.Entity;

import java.util.*;

public class Cliente {

	ArrayList<AutovetturaCompatibile> autovetturePossedute;
	private string nome;
	private string cognome;
	private Calendar dataNascita;

	public AutovetturaCompatibile[] getListaAutovetture() {
		// TODO - implement Cliente.getListaAutovetture
	}

	public string getNome() {
		return this.nome;
	}

	public string getCognome() {
		return this.cognome;
	}

	public Calendar getDataNascita() {
		return this.dataNascita;
	}

}