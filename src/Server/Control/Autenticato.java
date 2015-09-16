package Server.Control;

public class Autenticato implements Stato {

	public Server.RMIInterface.AutovetturaCliente[] retrieveAutovetture() {
		// TODO - implement Autenticato.retrieveAutovetture
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.BusinessLogic.Batteria[] elencoBatterie, Server.BusinessLogic.Stazione[] elencoStazioni) {
		// TODO - implement Autenticato.retrieveBatterieCompatibili
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(int indiceBatteria) {
		// TODO - implement Autenticato.startInstallazione
	}

	public boolean verificaEsitoValidazione() {
		// TODO - implement Autenticato.verificaEsitoValidazione
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(int codice) {
		// TODO - implement Autenticato.startValidazione
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, Server.RMIInterface.Batteria elencoBatterie) {
		// TODO - implement Autenticato.retrieveBatterieCompatibili
	}

}