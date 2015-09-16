package Server.Control;

public interface Stato {

	Server.RMIInterface.AutovetturaCliente[] retrieveAutovetture();

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.BusinessLogic.Batteria[] elencoBatterie, Server.BusinessLogic.Stazione[] elencoStazioni);

	/**
	 * 
	 * @param indiceBatteria
	 */
	boolean startInstallazione(int indiceBatteria);

	boolean verificaEsitoValidazione();

	/**
	 * 
	 * @param codice
	 */
	void startValidazione(int codice);

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 */
	boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.RMIInterface.Batteria elencoBatterie);

}