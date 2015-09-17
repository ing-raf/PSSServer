package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziGestore extends Remote {

	ArrayList<Autovettura> retrieveListaModelli() throws RemoteException;

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) throws RemoteException;

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Batteria> elencobatterie) throws RemoteException;

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 */
	boolean retrieveAutovettureCliente(int codicebadge, ArrayList<AutovetturaCliente> elencoAutovetture) throws RemoteException;

	/**
	 * 
	 * @param modello
	 */
	ArrayList<Stazione> remoteRetrieveBatterieCompatibili(int modello) throws RemoteException;

	Sostituzione retrieveUltimaSostituzione(int autovettura) throws RemoteException;

}