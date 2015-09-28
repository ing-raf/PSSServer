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
	ArrayList<?> retrieveBatterieCompatibili(int indiceAutovettura) throws RemoteException;
	
	ArrayList<? extends AutovetturaCliente> retrieveAutovetture() throws RemoteException;

	/**
	 * 
	 * @param indicebatteria
	 */
	Install_Outcome startInstallazione(int indicebatteria) throws RemoteException;

	boolean verificaEsitoValidazione() throws RemoteException;

	/**
	 * 
	 * @param codice
	 */
	void startValidazione(int codice) throws RemoteException;
	
	void logOut() throws RemoteException;

}