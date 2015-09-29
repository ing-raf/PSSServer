package Presentation.TerminaleCliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Server.RMIInterface.ServiziCliente;

public class BadgeClientRMI {
	
	private static int PORT_OFFSET = 3307;
	private Registry registry;
	private ServiziCliente stub;
	
	public BadgeClientRMI (int IDstazione, String serverHostname) throws Exception {
		this.registry = LocateRegistry.getRegistry(serverHostname, PORT_OFFSET + 2 * IDstazione);
		this.stub = (ServiziCliente)registry.lookup("ServiziCliente");
	}
	
	public void startValidazione(int codiceBadge) throws RemoteException {
		this.stub.startValidazione(codiceBadge);
	};
	
}
