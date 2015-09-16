package Server.Control;

import java.util.ArrayList;

import Server.BusinessLogic.GestoreBatterie;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato implements ServiziGestore {

	public Autovettura[] retrieveListaModelli() {

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
	public boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Server.RMIInterface.Batteria> elencobatterie) {
		GestoreBatterie gestoreBatterie = new GestoreBatterie();
		ArrayList<Server.BusinessLogic.Batteria> listabatterie = gestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
		
		for (Server.BusinessLogic.Batteria batteria: listabatterie) {
			Batteria nuova = new Batteria();
			nuova.setBatteria(batteria);
			elencobatterie.add(nuova);
		}
		
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

	public Server.RMIInterface.Sostituzione retrieveUltimaSostituzione() {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveUltimaSostituzione
	}

}