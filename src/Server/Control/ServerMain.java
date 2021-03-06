package Server.Control;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import lipermi.handler.CallHandler;
import lipermi.net.Server;

import Server.RMIInterface.ServiziGestoreAndroid;
import Server.BusinessLogic.GestoreStazioni;
import Server.Entity.PopulateTestDatabase;

public class ServerMain {
	
	private static int PORT_OFFSET = 3307;
	private static int NUM_STAZIONI = 3;
	private static String middleware = "LipeRMI";

	public static void main(String[] args) {
		
		try {
			PopulateTestDatabase.populate();
		} catch (Exception e) {
			System.out.println("Il database risulta inaccessibile");
			e.printStackTrace();
			System.exit(0);
		}
		
		ArrayList<Integer> elencoIDstazioni = GestoreStazioni.retriveListaId();
		
		if ( elencoIDstazioni.size() != NUM_STAZIONI ) {
			System.err.println("Farsi dare il progetto da Imma e Paolo");
			System.exit(0);
		}
		
		for (int i = 0; i < NUM_STAZIONI; i++) {
			
			try {
				Registry registry = LocateRegistry.createRegistry(PORT_OFFSET + 2*elencoIDstazioni.get(i));
				
				CoordinatoreClienteRegistrato coordinatoreClienteRegistrato = 
						new CoordinatoreClienteRegistrato( elencoIDstazioni.get(i) ); 
				CoordinatoreGestoreAutenticato coordinatoreGestoreAutenticato = 
						new CoordinatoreGestoreAutenticato( elencoIDstazioni.get(i) );
				
				System.out.println ("Cliente registrato sul porto " + ( PORT_OFFSET + 2*elencoIDstazioni.get(i) ) );
				
				registry.rebind("ServiziCliente", coordinatoreClienteRegistrato);
					
				if ( middleware.equalsIgnoreCase("JavaRMI") ) {
		
					registry.rebind("ServiziGestore", coordinatoreGestoreAutenticato);
					
				} else if ( middleware.equalsIgnoreCase("LipeRMI") ) {
					
					CallHandler callHandler = new CallHandler();
					Server server = new Server();
					
					callHandler.registerGlobal(ServiziGestoreAndroid.class, coordinatoreGestoreAutenticato);
					server.bind(PORT_OFFSET + 2*elencoIDstazioni.get(i) + 1, callHandler);
					
					System.out.println ("Gestore registrato sul porto " + (PORT_OFFSET + 2*elencoIDstazioni.get(i) + 1) );
					
				} else {
					throw new UnsupportedOperationException("Specificare uno dei middleware supportati");
				}
				
			} catch (Exception e) {
				System.err.println("Il server ha riscontrato un problema nell'apertura "
						+ "della connessione sul porto " + (PORT_OFFSET + i) );
				e.printStackTrace();
				System.exit(0);
			} 
		}
		
		System.out.println("Server pronto");

	}
	
	public static void cablatedID (ArrayList<Integer> listaID) {
		
		for (int i = 0; i < 3; i++)
			listaID.add(i, i + 1);
		
	}

}

