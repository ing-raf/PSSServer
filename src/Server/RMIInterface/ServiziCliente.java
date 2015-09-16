package Server.RMIInterface;

import java.rmi.*;
import java.util.ArrayList;

public interface ServiziCliente extends Remote {

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	boolean retrieveBatterieCompatibili(int indiceAutovettura, Batteria[] elencoBatterie, Stazione[] elencoStazioni);

	ArrayList<AutovetturaCliente> retrieveAutovetture();

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