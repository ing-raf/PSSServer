package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziGestore extends Remote {

	Autovettura[] retrieveListaModelli();

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	void addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura);

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Batteria> elencobatterie);

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 */
	AutovetturaCliente[] retrieveAutovettureCliente(int codicebadge);

	/**
	 * 
	 * @param modello
	 */
	Stazione[] remoteRetrieveBatterieCompatibili(int modello);

	Sostituzione retrieveUltimaSostituzione();

}