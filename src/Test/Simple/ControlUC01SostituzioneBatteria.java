package Test.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Server.Control.CoordinatoreClienteRegistrato;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.ServiziCliente;
import Server.RMIInterface.Stazione;

public class ControlUC01SostituzioneBatteria {
	
	private static final int IDSTAZIONE = 1;
	private static final int CODICEBADGE = 4;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		ServiziCliente server = null;
		
		try {
			 server = new CoordinatoreClienteRegistrato(IDSTAZIONE);
		} catch (RemoteException e) {
			System.err.println("Il server non risponde... È la Fasolino per caso?");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Client tutt appost tutt appost");
		
		try {
			server.startValidazione(CODICEBADGE);
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio VII.1.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			
			if (server.verificaEsitoValidazione() == false) {
				System.out.println("Questo codice non corrisponde ad alcun badge");	
			}
			
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio VII.1.2a.1");
			e.printStackTrace();
			System.exit(0);
		}
		
		ArrayList<? extends AutovetturaCliente> autovetture = null;
		
		try {
			autovetture = server.retrieveAutovetture();
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio I.2.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( autovetture.isEmpty() ) {
			System.out.println("Nessun modello trovato");
			System.exit(0);
		}
		
		System.out.println("Su quale autovettura effettuare la sostituzione?");
		System.out.println("Nº\tFornitore\tModello\t\tTarga");
		System.out.println("---\t----\t\t----\t\t----");
			
		for (int i = 0; i < autovetture.size(); i++) {
			System.out.println(i+"\t"+autovetture.get(i).getFornitore() + "\t" + autovetture.get(i).getModello() + "\t" + autovetture.get(i).getNumeroTarga());
		}
		
		System.out.println("Specificare il numero:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int indice = Integer.parseInt( in.readLine() );
		
		if (indice < 0 || indice >= autovetture.size() ) {
			System.out.println("STRUNZ!!! Devi scegliere una delle autovetture presenti!");
			System.exit(0);
		}
		
		ArrayList<? extends Batteria> batterie = null;
		
		try {
			batterie = server.retrieveBatterieCompatibili(indice);
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio I.3.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( batterie.isEmpty() ) {
			
			System.out.println("Non trovate batterie compatibili in questa stazione");
			
			ArrayList<? extends Stazione> stazioni = null;
			
			try {
				stazioni = server.remoteRetrieveBatterieCompatibili(indice);
			} catch (RemoteException e) {
				System.err.println("Eccezione durante l'esecuzione del messaggio NOMODELED");
				e.printStackTrace();
				System.exit(0);
			}
			
			if ( stazioni.isEmpty() ) {
				System.out.println("Batteria non presente in alcuna stazione");
			} else {
				System.out.println("Batterie compatibili sono presenti nelle stazioni seguenti:");
				
				System.out.println("Stazione\tIndirizzo");
				System.out.println("----\t\t----");
				
				for (int i = 0; i < stazioni.size(); i++)
					System.out.println(stazioni.get(i).getNome() + "\t" + stazioni.get(i).getIndirizzo());
				
			}
			
		} else {
			
			System.out.println("Quale batteria inserire?");
			System.out.println("Nº\tID\tCosto");
			System.out.println("---\t----\t----");
			
			for (int i = 0; i < batterie.size(); i++) {
				System.out.println(i+"\t"+ batterie.get(i).getID() + "\t" + batterie.get(i).getCosto() );
			}
			
			System.out.println("Specificare il numero:");
		
		
			int indiceBatteria = Integer.parseInt( in.readLine() );
		
			if (indiceBatteria < 0 || indiceBatteria >= batterie.size() ) {
				System.out.println("STRUNZ!!! Devi scegliere una delle autovetture presenti!");
				System.exit(0);
			}
		
			try {
				if (server.startInstallazione(indiceBatteria) == false)
					throw new RemoteException("Installazione non avvenuta");
			} catch (RemoteException e) {
				System.err.println("Eccezione durante l'esecuzione del messaggio I.4.2");
				e.printStackTrace();
				System.exit(0);
			}
			
		}
		
		System.out.println ("BANANAAAAAAAAAAAA");
	}

}
