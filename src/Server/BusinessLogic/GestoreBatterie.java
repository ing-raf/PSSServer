package Server.BusinessLogic;

import java.util.ArrayList;

public class GestoreBatterie {

	/**
	 * 
	 * @param IDstazione
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxcicliricarica
	 * @param modello
	 */
	public boolean addBatteria(int IDstazione, int IDbatteria, float costosostituzione, int maxcicliricarica, Autovettura modello) {
		return false;
		// TODO - implement GestoreBatterie.addBatteria
	}

	/**
	 * 
	 * @param IDstazione
	 */
	public ArrayList<Batteria> retrieveBatterieQuasiEsauste(int IDstazione) {
		return null;
		// TODO - implement GestoreBatterie.retrieveBatterieQuasiEsauste
	}

	/**
	 * 
	 * @param batteria
	 */
	public boolean verifyRicarica(Batteria batteria) {
		return false;
		// TODO - implement GestoreBatterie.verifyRicarica
	}

}