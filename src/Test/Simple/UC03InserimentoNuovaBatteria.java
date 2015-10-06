package Test.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Autovettura;

public class UC03InserimentoNuovaBatteria {
	
	private static final int IDSTAZIONE = 1;

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
			System.err.println("Eccezione durante l'esecuzione del messaggio III.1.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( modelli.isEmpty() ) {
			System.out.println("Nessun modello trovato");
			System.exit(0);
		}
		
		System.out.println("A quale modello è compatibile la batteria?");
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
		
		System.out.println("Inserire i dati della batteria compatibile");
		System.out.println("con il modello " + modelli.get(indice).getBrand() + " " + modelli.get(indice).getModel());
		System.out.println("ID:");
		
		int ID = Integer.parseInt( in.readLine() );
		
		System.out.println("Costo di sostituzione:");
		
		float costo =  Float.parseFloat( in.readLine() );
		
		System.out.println("Massimo numero di cicli di ricarica: ");
		
		int cicli = Integer.parseInt( in.readLine() );
		
		try {
			client.addBattery(ID, costo, cicli, indice);
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio III.3.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println ("BANANAAAAAAAAAAAA");
	}

}
