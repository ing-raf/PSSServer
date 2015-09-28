package Server.Control;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.RMIInterface.Install_Outcome;

public abstract class Stato {

	ArrayList<? extends AutovetturaCliente> retrieveAutovetture(CoordinatoreClienteRegistrato coordinatore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	ArrayList<?> retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	Install_Outcome startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		return Install_Outcome.NO_VALIDATE;
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