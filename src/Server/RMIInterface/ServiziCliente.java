package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziCliente extends Remote {

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	ArrayList<?> retrieveCompatibleBatteries(int indiceAutovettura) throws RemoteException;
	
	ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars() throws RemoteException;

	/**
	 * 
	 * @param indicebatteria
	 */
	Install_Outcome startInstallation(int indicebatteria) throws RemoteException;

	boolean verifyValidationOutcome() throws RemoteException;

	/**
	 * 
	 * @param codice
	 */
	void startValidation(int codice) throws RemoteException;
	
	void logOut() throws RemoteException;

}