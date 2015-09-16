package Server.Entity;

import java.util.*;

public class Stazione {

	ArrayList<Batteria> disponibilità;
	private string nome;
	private string indirizzo;
	private int ID;

	/**
	 * 
	 * @param IDstazione
	 * @param nuova
	 */
	public void insertBatteria(int IDstazione, Batteria nuova) {
		// TODO - implement Stazione.insertBatteria
	}

	/**
	 * 
	 * @param cicliRicaricaRimanenti
	 */
	public Batteria[] getListaBatterie(int cicliRicaricaRimanenti) {
		// TODO - implement Stazione.getListaBatterie
	}

	public string getIndirizzo() {
		return this.indirizzo;
	}

	public string getNome() {
		return this.nome;
	}

	/**
	 * 
	 * @param batteria
	 */
	public void removeBatteria(Batteria batteria) {
		// TODO - implement Stazione.removeBatteria
	}

}