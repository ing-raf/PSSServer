package Server.Control;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;

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
	ArrayList<? extends Batteria> retrieveBatterieCompatibili(int IDStazione, int indiceAutovettura) {
		throw new UnsupportedOperationException();
	}
	
	ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	boolean startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
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