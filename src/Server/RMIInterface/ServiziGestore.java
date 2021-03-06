package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziGestore extends Remote {

	ArrayList<? extends Autovettura> retrieveListaModelli() throws Exception;

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) throws Exception;

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws Exception;

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 */
	ArrayList<? extends AutovetturaCliente> retrieveAutovettureCliente(int codicebadge) throws Exception;

	/**
	 * 
	 * @param modello
	 */
	ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws Exception;

	Sostituzione retrieveUltimaSostituzione(int autovettura) throws Exception;

}