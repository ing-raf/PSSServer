package Server.BusinessLogic;

public class GestoreBatterie {

	/**
	 * 
	 * @param IDstazione
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxcicliricarica
	 * @param modello
	 */
	public boolean addBatteria(int IDstazione, int IDbatteria, float costosostituzione, int maxcicliricarica, ModelloAutovettura[] modello) {
		return false;
		// TODO - implement GestoreBatterie.addBatteria
	}

	/**
	 * 
	 * @param IDstazione
	 */
	public Batteria[] retrieveBatterieQuasiEsauste(int IDstazione) {
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