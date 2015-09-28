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
	
	public ArrayList<?> retrieveBatterieCompatibili(int indiceAutovettura) throws RemoteException{
		return this.stub.retrieveBatterieCompatibili(indiceAutovettura);
	}
	
	public ArrayList<? extends AutovetturaCliente> retrieveAutovetture() throws RemoteException {
		return this.stub.retrieveAutovetture();
	}

	public Install_Outcome startInstallazione(int indicebatteria) throws RemoteException {
		return this.stub.startInstallazione(indicebatteria);
	}

	public boolean verificaEsitoValidazione() throws RemoteException {
		return this.stub.verificaEsitoValidazione();
	}
	
	public void logOut() throws RemoteException {
		this.stub.logOut();
	}

}
