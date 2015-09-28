package Test.Simple;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Presentation.TerminaleCliente.BadgeClientRMI;
import Presentation.TerminaleCliente.ClienteRegistratoClientRMI;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;

public class UC01SostituzioneBatteria {
	
	private static final int IDSTAZIONE = 3;
	private static final int CODICEBADGE = 5;

	public static void main(String[] args) throws Exception {
		
		BadgeClientRMI clientBadge = null;
		ClienteRegistratoClientRMI client = null;
		
		try {
			 clientBadge = new BadgeClientRMI(IDSTAZIONE, "localhost");
			 client = new ClienteRegistratoClientRMI(IDSTAZIONE, "localhost");
		} catch (RemoteException e) {
			System.err.println("Il server non risponde... È la Fasolino per caso?");
			e.printStackTrace();
			System.exit(0);
		}

		System.out.println("Client tutt appost tutt appost");
		
		try {
			clientBadge.startValidazione(CODICEBADGE);
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio VII.1.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		try {
			
			if (client.verificaEsitoValidazione() == false) {
				System.out.println("Questo codice non corrisponde ad alcun badge");	
				System.exit(0);
			}
			
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio VII.1.2a.1");
			e.printStackTrace();
			System.exit(0);
		}
		
		ArrayList<? extends AutovetturaCliente> autovetture = null;
		
		try {
			autovetture = client.retrieveAutovetture();
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio I.2.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( autovetture.isEmpty() ) {
			System.out.println("Nessuna autovettura compatibile trovata");
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
		
		ArrayList<?> output = null;
		
		try {
			output = client.retrieveBatterieCompatibili(indice);
		} catch (RemoteException e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio I.3.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( output.isEmpty() ) {
			
			System.out.println("Batteria non presente in alcuna stazione");
			
		} else {
			
			if ( output.get(0) instanceof Batteria) {
				
				System.out.println("Quale batteria inserire?");
				System.out.println("Nº\tID\tCosto");
				System.out.println("---\t----\t----");		
				
				for (int i = 0; i < output.size(); i++) {
					Batteria b = (Batteria) output.get(i);
					System.out.println(i+"\t"+ b.getID() + "\t" + b.getCosto() );
				}
				
				System.out.println("Specificare il numero:");
				
				int indiceBatteria = Integer.parseInt( in.readLine() );
				
				if (indiceBatteria < 0 || indiceBatteria >= output.size() ) {
					System.out.println("STRUNZ!!! Devi scegliere una delle autovetture presenti!");
					System.exit(0);
				}
			
				try {
					if (client.startInstallazione(indiceBatteria) == false)
						throw new RemoteException("Installazione non avvenuta");
				} catch (RemoteException e) {
					System.err.println("Eccezione durante l'esecuzione del messaggio I.4.2");
					e.printStackTrace();
					System.exit(0);
				}
				
			} else if ( output.get(0) instanceof Stazione) {
				
				System.out.println("Non trovate batterie compatibili in questa stazione");
				System.out.println("Batterie compatibili sono presenti nelle stazioni seguenti:");
				
				System.out.println("Stazione\tIndirizzo");
				System.out.println("----\t\t----");
				
				for (Object o : output) {
					Stazione s = (Stazione) o;
					System.out.println( s.getNome() + "\t" + s.getIndirizzo() );
				}
							
			} else {
				System.err.println("Eccezione nella determinazione a run - time del tipo");
				System.exit(0);
			}
							
		}
		
		System.out.println ("BANANAAAAAAAAAAAA");
	}

}
