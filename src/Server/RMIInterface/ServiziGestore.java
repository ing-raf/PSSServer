package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziGestore extends Remote {

	ArrayList<? extends Autovettura> retrieveListaModelli() throws RemoteException;

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
	ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws RemoteException;

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 */
	boolean retrieveAutovettureCliente(int codicebadge, ArrayList<? extends AutovetturaCliente> elencoAutovetture) throws RemoteException;

	/**
	 * 
	 * @param modello
	 */
	ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws RemoteException;

	Sostituzione retrieveUltimaSostituzione(int autovettura) throws RemoteException;

}