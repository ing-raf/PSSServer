package Server.Control;

import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Server.RMIInterface.ServiziGestore;

import lipermi.exception.LipeRMIException;
import lipermi.handler.CallHandler;
import lipermi.net.Server;

public class ServerMain {
	
	private static int PORT_OFFSET = 1024;
	private static int NUM_STAZIONI = 3;
	private static String middleware = "LipeRMI";

	public static void main(String[] args) {
		ArrayList<Integer> elencoIDstazioni = new ArrayList<Integer>(NUM_STAZIONI);
		
		cablatedID(elencoIDstazioni);
		
		if ( elencoIDstazioni.size() != NUM_STAZIONI ) {
			System.err.println("Farsi dare il progetto da Imma e Paolo");
			System.exit(0);
		}
		
		for (int i = 0; i < NUM_STAZIONI; i = i + 2) {
			
			try {
				Registry registry = LocateRegistry.createRegistry(PORT_OFFSET + elencoIDstazioni.get(i));
				
				CoordinatoreClienteRegistrato coordinatoreClienteRegistrato = 
						new CoordinatoreClienteRegistrato( elencoIDstazioni.get(i) ); 
				CoordinatoreGestoreAutenticato coordinatoreGestoreAutenticato = 
						new CoordinatoreGestoreAutenticato( elencoIDstazioni.get(i) ); 
				
				registry.rebind("ServiziCliente", coordinatoreClienteRegistrato);
					
				if ( middleware.equalsIgnoreCase("JavaRMI") ) {
		
					registry.rebind("ServiziGestore", coordinatoreGestoreAutenticato);
					
				} else if ( middleware.equalsIgnoreCase("LipeRMI") ) {
					
					CallHandler callHandler = new CallHandler();
					Server server = new Server();
					
					callHandler.registerGlobal(ServiziGestore.class, coordinatoreGestoreAutenticato);
					server.bind(PORT_OFFSET + elencoIDstazioni.get(i) + 1, callHandler);
					
				} else {
					throw new UnsupportedOperationException("Specificare uno dei middleware supportati");
				}
				
			} catch (RemoteException e) {
				System.err.println("Il server JavaRMI ha riscontrato un problema nell'apertura "
						+ "della connessione sul porto " + (PORT_OFFSET + i) );
				e.printStackTrace();
				System.exit(0);
			} catch (LipeRMIException e) {
				System.err.println("Il server LipeRMI ha riscontrato un problema nell'apertura "
						+ "della connessione sul porto " + (PORT_OFFSET + i) );
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				System.err.println("Il server ha riscontrato un problema nell'apertura "
						+ "della connessione sul porto " + (PORT_OFFSET + i) );
				e.printStackTrace();
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

