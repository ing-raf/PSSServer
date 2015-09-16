package Server.Control;

import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato implements ServiziGestore {

	public Autovettura[] retrieveListaModelli() {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveListaModelli
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public void addBatteria(int IDbatteria, float costosostituzione, int maxciclidiricarica, int modelloautovettura) {
		// TODO - implement CoordinatoreGestoreAutenticato.addBatteria
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public boolean retrieveBatterieQuasiEsauste(int IDstazione, Server.Entity.Batteria[] listabatterie) {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveBatterieQuasiEsauste
	}

	/**
	 * 
	 * @param codicebadge
	 */
	public AutovetturaCliente[] retrieveAutovettureCliente(int codicebadge) {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveAutovettureCliente
	}

	/**
	 * 
	 * @param modello
	 */
	public Stazione[] remoteRetrieveBatterieCompatibili(int modello) {
		// TODO - implement CoordinatoreGestoreAutenticato.remoteRetrieveBatterieCompatibili
	}

	public Server.Entity.Sostituzione retrieveUltimaSostituzione() {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveUltimaSostituzione
	}

}