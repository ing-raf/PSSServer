package Test.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Autovettura;
import Server.RMIInterface.Stazione;

public class UC05DisponibilitaRemotaBatterie {

	private static final int IDSTAZIONE = 1;

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(IDSTAZIONE, "localhost");
		} catch (Exception e) {
			System.err.println("Il server non risponde... È la Fasolino per caso?");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Client tutt appost tutt appost");
		
		ArrayList<? extends Autovettura> modelli = new ArrayList<Autovettura>();
		
		try {
			modelli = client.retrieveModelList();
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio V.1.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( modelli.isEmpty() ) {
			System.out.println("Nessun modello trovato");
			System.exit(0);
		}
		
		System.out.println("Per quale modello vuoi effettuare la ricerca?");
		System.out.println("Nº\tFornitore\tModello");
		System.out.println("---\t----\t\t----");
			
		for (int i = 0; i < modelli.size(); i++) {
			System.out.println(i+"\t"+modelli.get(i).getBrand() + "\t" + modelli.get(i).getModel());
		}
		
		System.out.println("Specificare il numero:");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int indice = Integer.parseInt( in.readLine() );
		
		if (indice < 0 || indice >= modelli.size() ) {
			System.out.println("STRUNZ!!! Devi scegliere uno dei modelli presenti!");
		}
		
		ArrayList<Stazione> stazioni = new ArrayList<Stazione>();
		
		try {
			stazioni = (ArrayList<Stazione>) client.remoteRetrieveCompatibleBatteries(indice);
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio V.2.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( stazioni.isEmpty() ) {
			System.out.println("Nessuna stazione ha batterie compatibili");
			System.out.println("con il modello " + modelli.get(indice).getBrand() 
					+ " " + modelli.get(indice).getModel());
			System.exit(0);
		}
		
		System.out.println("Stazione\tIndirizzo");
		System.out.println("----\t\t----");
		
		for (int i = 0; i < stazioni.size(); i++)
			System.out.println(stazioni.get(i).getName() + "\t" + stazioni.get(i).getAddress());
		
		System.out.println ("BANANAAAAAAAAAAAA");
	}


}
