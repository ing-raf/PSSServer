package Server.Control;

import Server.RMIInterface.*;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;

public class CoordinatoreClienteRegistrato implements ServiziCliente {
	
	private Stato stato;

	public AutovetturaCliente[] retrieveAutovetture() {
		return this.stato.retrieveAutovetture();
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.RMIInterface.Batteria[] elencoBatterie, Server.RMIInterface.Stazione[] elencoStazioni) {
		return this.stato.retrieveBatterieCompatibili(indiceAutovettura, elencoBatterie, elencoStazioni);
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(int indiceBatteria) {
		return this.stato.startInstallazione(indiceBatteria);
	}

	public boolean verificaEsitoValidazione() {
		return this.stato.verificaEsitoValidazione();
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(int codice) {
		this.stato.startValidazione(codice);
	}


}