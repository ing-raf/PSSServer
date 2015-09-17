package Server.Control;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class ServerMain {
	
	private static int PORT_OFFSET = 1024;
	private static int NUM_STAZIONI = 3;

	public static void main(String[] args) {
		ArrayList<Integer> elencoIDstazioni = new ArrayList<Integer>(NUM_STAZIONI);
		
		cablatedID(elencoIDstazioni);
		
		if ( elencoIDstazioni.size() != NUM_STAZIONI ) {
			System.err.println("Farsi dare il progetto da Imma e Paolo");
			System.exit(0);
		}
		
		for (int i = 0; i < NUM_STAZIONI; i++) {
			
			try {
				Registry registry = LocateRegistry.createRegistry(PORT_OFFSET+elencoIDstazioni.get(i));
				
				CoordinatoreClienteRegistrato coordinatoreClienteRegistrato = 
						new CoordinatoreClienteRegistrato(); 
				
				CoordinatoreGestoreAutenticato coordinatoreGestoreAutenticato = 
						new CoordinatoreGestoreAutenticato(); 
				
				registry.rebind("ServiziCliente", coordinatoreClienteRegistrato);
				registry.rebind("ServiziGestore", coordinatoreGestoreAutenticato);
			} catch (RemoteException e) {
				System.err.println("Il server ha riscontrato un problema nell'apertura "
						+ "della connessione sul porto " + (PORT_OFFSET + i) );
				System.exit(0);
			}
		}
		
		System.out.println("Tutt appost tutt appost");

	}
	
	public static void cablatedID (ArrayList<Integer> listaID) {
		
		for (int i = 0; i < 3; i++)
			listaID.add(i, i);
		
	}

}

