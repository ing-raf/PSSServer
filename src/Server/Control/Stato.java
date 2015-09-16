package Server.Control;

import java.util.ArrayList;

public abstract class Stato {

	ArrayList<Server.RMIInterface.AutovetturaCliente> retrieveAutovetture() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.RMIInterface.Batteria[] elencoBatterie, Server.RMIInterface.Stazione[] elencoStazioni) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	boolean startInstallazione(int indiceBatteria) {
		throw new UnsupportedOperationException();
	}

	boolean verificaEsitoValidazione() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param codice
	 */
	void startValidazione(CoordinatoreClienteRegistrato coordinatore, int codice) {		
		throw new UnsupportedOperationException();
	}

}