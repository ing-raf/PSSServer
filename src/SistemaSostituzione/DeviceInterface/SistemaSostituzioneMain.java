package SistemaSostituzione.DeviceInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;
import java.rmi.RemoteException;

public class SistemaSostituzioneMain {
	
	private static final int PORT = 1099;

	public static void main(String[] args) {
		
		try {
			Registry registry = LocateRegistry.createRegistry(PORT);
		
			ServizidiSostituzione servizio = (ServizidiSostituzione) new InterfacciaSistemadiSostituzione();
		
			registry.rebind("sostituzione", servizio);
		} catch (RemoteException e) {
			System.out.println ("Il device ha riscontrato un problema nell'apertura "
					+ "della connessione sul porto" + PORT);
			e.printStackTrace();
			System.exit(0);
		} 	
		
		System.out.println("Device tutt appost tutt appost");

	}

}
