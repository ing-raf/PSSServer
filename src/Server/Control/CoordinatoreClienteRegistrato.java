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
	private final String hostname;
	private final int portSostituzione;
	
	public CoordinatoreClienteRegistrato(int IDstazione) throws RemoteException {
			super();
			this.stato = new NonAutenticato();
			this.IDstazione = IDstazione;
			this.hostname = "localhost";
			this.portSostituzione = 1099;
	}
	
	public CoordinatoreClienteRegistrato(int IDstazione, String hostname) throws RemoteException {
		super();
		this.stato = new NonAutenticato();
		this.IDstazione = IDstazione;
		this.hostname = hostname;
		this.portSostituzione = 1099;
}

	public ArrayList<? extends AutovetturaCliente> retrieveAutovetture() {
		return this.stato.retrieveAutovetture(this);
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public ArrayList<?> retrieveBatterieCompatibili(int indiceAutovettura) {
		return this.stato.retrieveBatterieCompatibili(this, indiceAutovettura);
	}

	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	public Install_Outcome startInstallazione(int indiceBatteria) throws RemoteException {
		return this.stato.startInstallazione(this, indiceBatteria);
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
	
	@Override
	public void logOut() throws RemoteException {
		this.stato.logOut(this);
	}

	int getIDStazione() {
		return this.IDstazione;
	}
	
	String getHostname () {
		return this.hostname;
	}
	
	int getPortSostituzione() {
		return this.portSostituzione;
	}
	
	void setStato (Stato stato) {
		this.stato = stato;
	}

}