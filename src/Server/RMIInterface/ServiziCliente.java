package Server.RMIInterface;

import java.rmi.*;

public interface ServiziCliente extends Remote {

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	boolean retrieveBatterieCompatibili(int indiceAutovettura, Batteria[] elencoBatterie, Stazione[] elencoStazioni);

	AutovetturaCliente[] retrieveAutovetture();

	/**
	 * 
	 * @param indicebatteria
	 */
	boolean startInstallazione(int indicebatteria);

	boolean verificaEsitoValidazione();

	/**
	 * 
	 * @param codice
	 */
	void startValidazione(int codice);

}