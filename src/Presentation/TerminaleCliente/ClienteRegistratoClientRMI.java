package Presentation.TerminaleCliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Install_Outcome;
import Server.RMIInterface.ServiziCliente;

public class ClienteRegistratoClientRMI {
	
	private static int PORT_OFFSET = 1024;
	private Registry registry;
	private ServiziCliente stub;
	
	public ClienteRegistratoClientRMI (int IDstazione, String serverHostname) throws Exception {
		this.registry = LocateRegistry.getRegistry(serverHostname, PORT_OFFSET + 2 * IDstazione);
		this.stub = (ServiziCliente)registry.lookup("ServiziCliente");
	}
	
	public ArrayList<?> retrieveCompatibleBatteries(int indiceAutovettura) throws RemoteException{
		return this.stub.retrieveCompatibleBatteries(indiceAutovettura);
	}
	
	public ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars() throws RemoteException {
		return this.stub.retrieveCompatibleCars();
	}

	public Install_Outcome startInstallation(int indicebatteria) throws RemoteException {
		Install_Outcome outcome = this.stub.startInstallation(indicebatteria);
		return outcome;
		
	}

	public boolean verifyValidationOutcome() throws RemoteException {
		return this.stub.verifyValidationOutcome();
	}
	
	public void logOut() throws RemoteException {
		this.stub.logOut();
	}

}
