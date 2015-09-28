package Server.Control;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.RMIInterface.Install_Outcome;

public abstract class Stato {

	public ArrayList<? extends AutovetturaCliente> retrieveAutovetture(CoordinatoreClienteRegistrato coordinatore) {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public ArrayList<?> retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	public Install_Outcome startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	public boolean verificaEsitoValidazione() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(CoordinatoreClienteRegistrato coordinatore, int codice) {		
		throw new UnsupportedOperationException();
	}
	
	public void logOut(CoordinatoreClienteRegistrato coordinatore) {
		throw new UnsupportedOperationException();
	}

}