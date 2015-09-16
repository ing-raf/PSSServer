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
	public void addBatteria(int IDstazione, int IDbatteria, int costosostituzione, int maxcicliricarica, ModelloAutovettura[] modello) {
		// TODO - implement GestoreBatterie.addBatteria
	}

	/**
	 * 
	 * @param IDstazione
	 */
	public ModelloAutovettura[] retrieveBatterieQuasiEsauste(int IDstazione) {
		// TODO - implement GestoreBatterie.retrieveBatterieQuasiEsauste
	}

	/**
	 * 
	 * @param batteria
	 */
	public boolean verifyRicarica(Batteria batteria) {
		// TODO - implement GestoreBatterie.verifyRicarica
	}

}