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
	boolean retrieveBatterieCompatibili(int indiceAutovettura, ArrayList<Batteria> elencoBatterie, ArrayList<Stazione> elencoStazioni) throws RemoteException;

	ArrayList<AutovetturaCliente> retrieveAutovetture() throws RemoteException;

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