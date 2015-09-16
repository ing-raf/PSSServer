package Server.RMIInterface;

import java.rmi.*;

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
	boolean retrieveBatterieQuasiEsauste(int IDstazione, Batteria listabatterie);

	/**
	 * 
	 * @param nome
	 * @param cognome
	 * @param datanascita
	 */
	AutovetturaCliente[] retrieveAutovettureCliente(string nome, string cognome, Calendar datanascita);

	/**
	 * 
	 * @param modello
	 */
	Stazione[] remoteRetrieveBatterieCompatibili(int modello);

	Sostituzione retrieveUltimaSostituzione();

}