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
	ArrayList<? extends Batteria> retrieveBatterieCompatibili(int indiceAutovettura) throws RemoteException;
	
	ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int indiceAutovettura) throws RemoteException;

	ArrayList<? extends AutovetturaCliente> retrieveAutovetture() throws RemoteException;

	/**
	 * 
	 * @param indicebatteria
	 */
	boolean startInstallazione(int indicebatteria) throws RemoteException;

	boolean verificaEsitoValidazione() throws RemoteException;

	/**
	 * 
	 * @param codice
	 */
	void startValidazione(int codice) throws RemoteException;

}