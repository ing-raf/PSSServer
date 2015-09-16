package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

import Server.Control.AutovetturaCliente;

public interface ServiziGestore extends Remote {

	ArrayList<Autovettura> retrieveListaModelli();

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	boolean addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura);

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
	boolean retrieveAutovettureCliente(int codicebadge, ArrayList<AutovetturaCliente> elencoAutovetture);

	/**
	 * 
	 * @param modello
	 */
	Stazione[] remoteRetrieveBatterieCompatibili(int modello);

	Sostituzione retrieveUltimaSostituzione(int autovettura);

}