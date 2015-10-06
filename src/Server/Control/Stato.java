package Server.Control;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.RMIInterface.Install_Outcome;

public abstract class Stato {

	public ArrayList<AutovetturaClienteC> retrieveCompatibleCars(CoordinatoreClienteRegistrato coordinatore) {
		throw new UnsupportedOperationException();
	}

	public ArrayList<?> retrieveCompatibleBatteries(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {
		throw new UnsupportedOperationException();
	}


	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	public Install_Outcome startInstallation(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		throw new UnsupportedOperationException();
	}

	public boolean verifyValidationOutcome() {
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidation(CoordinatoreClienteRegistrato coordinatore, int codice) {		
		throw new UnsupportedOperationException();
	}
	
	public void logOut(CoordinatoreClienteRegistrato coordinatore) {
		throw new UnsupportedOperationException();
	}

}