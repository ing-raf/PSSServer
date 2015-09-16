package Server.Control;

import Server.RMIInterface.*;

public class CoordinatoreClienteRegistrato implements ServiziCliente {

	public AutovetturaCliente[] retrieveAutovetture() {
		// TODO - implement CoordinatoreClienteRegistrato.retrieveAutovetture
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.BusinessLogic.Batteria[] elencoBatterie, Server.BusinessLogic.Stazione[] elencoStazioni) {
		// TODO - implement CoordinatoreClienteRegistrato.retrieveBatterieCompatibili
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(int indiceBatteria) {
		// TODO - implement CoordinatoreClienteRegistrato.startInstallazione
	}

	public boolean verificaEsitoValidazione() {
		// TODO - implement CoordinatoreClienteRegistrato.verificaEsitoValidazione
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(int codice) {
		// TODO - implement CoordinatoreClienteRegistrato.startValidazione
	}

}