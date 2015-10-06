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
	private final String substitutionDeviceHostname;
	private final int substitutionDevicePort;
	
	public CoordinatoreClienteRegistrato(int IDstazione) throws RemoteException {
			super();
			this.stato = new NonAutenticato();
			this.IDstazione = IDstazione;
			this.substitutionDeviceHostname = "localhost";
			this.substitutionDevicePort = 1099;
	}
	
	public CoordinatoreClienteRegistrato(int IDstazione, String substitutionDeviceHostname) throws RemoteException {
		super();
		this.stato = new NonAutenticato();
		this.IDstazione = IDstazione;
		this.substitutionDeviceHostname = substitutionDeviceHostname;
		this.substitutionDevicePort = 1099;
}

	@Override
	public ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars() {
		return this.stato.retrieveCompatibleCars(this);
	}

	@Override
	public ArrayList<?> retrieveCompatibleBatteries(int indiceAutovettura) {
		return this.stato.retrieveCompatibleBatteries(this, indiceAutovettura);
	}

	@Override
	public Install_Outcome startInstallation(int indiceBatteria) throws RemoteException {
		return this.stato.startInstallation(this, indiceBatteria);
	}

	public boolean verifyValidationOutcome() {
		return this.stato.verifyValidationOutcome();
	}

	@Override
	public void startValidation(int codice) {
		this.stato.startValidation(this, codice);
	}
	
	@Override
	public void logOut() throws RemoteException {
		this.stato.logOut(this);
	}

	int getStationID() {
		return this.IDstazione;
	}
	
	String getSubstitutionDeviceHostname () {
		return this.substitutionDeviceHostname;
	}
	
	int getSubstitutionDevicePort() {
		return this.substitutionDevicePort;
	}
	
	void setState (Stato stato) {
		this.stato = stato;
	}

}