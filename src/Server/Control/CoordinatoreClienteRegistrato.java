package Server.Control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Server.RMIInterface.*;

public class CoordinatoreClienteRegistrato extends UnicastRemoteObject implements ServiziCliente {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3976477806196171091L;
	private Stato stato;
	private final int IDstazione;
	
	public CoordinatoreClienteRegistrato(int IDstazione) throws RemoteException {
			super();
			this.stato = new NonAutenticato();
			this.IDstazione = IDstazione;
	}

	public ArrayList<AutovetturaCliente> retrieveAutovetture() {
		return this.stato.retrieveAutovetture();
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, ArrayList<Batteria> elencoBatterie, ArrayList<Stazione> elencoStazioni) {
		return this.stato.retrieveBatterieCompatibili(this, indiceAutovettura, elencoBatterie, elencoStazioni);
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(int indiceBatteria) {
		return this.stato.startInstallazione(indiceBatteria);
	}

	public boolean verificaEsitoValidazione() {
		return this.stato.verificaEsitoValidazione();
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(int codice) {
		this.stato.startValidazione(this, codice);
	}

	void setStato (Stato stato) {
		this.stato = stato;
	}

}