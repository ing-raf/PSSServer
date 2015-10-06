package Test.Simple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.UltimaSostituzione;

public class UC04VisualizzazioneUltimoRicambio {
	
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
		
		System.out.println("Di quale cliente vuoi visualizzare l'ultimo ricambio?");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int badge = Integer.parseInt( in.readLine() );
		
		ArrayList<? extends AutovetturaCliente> autovetture = new ArrayList<AutovetturaCliente>();
		
		try {
			
			autovetture = client.retrieveCompatibleCars(badge);
			
			if ( autovetture == null ) {
				System.out.println("Questo codice non corrisponde ad alcun badge");				System.exit(0);
			}
			
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio IV.2.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( autovetture.isEmpty() ) {
			System.out.println("Nessun modello trovato");
			System.exit(0);
		}
		
		System.out.println("Di quale autovettura vuoi visualizzare i dati?");
		System.out.println("Nº\tFornitore\tModello\t\tTarga");
		System.out.println("---\t----\t\t----\t\t----");
			
		for (int i = 0; i < autovetture.size(); i++) {
			System.out.println(i+"\t"+autovetture.get(i).getBrand() + "\t" + autovetture.get(i).getModel() + "\t" + autovetture.get(i).getNumberPlate());
		}
		
		System.out.println("Specificare il numero:");
		
		int indice = Integer.parseInt( in.readLine() );
		
		if (indice < 0 || indice >= autovetture.size() ) {
			System.out.println("STRUNZ!!! Devi scegliere una delle autovetture presenti!");
			System.exit(0);
		}
		
		UltimaSostituzione ultima = null;
		
		try {
			ultima = client.retrieveLastSubstitution(indice);
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio IV.3.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( ultima == null ) {
			System.out.println("Nessuna sostituzione trovata");
			System.exit(0);
		}
		
		System.out.println("Data\t\tOra\tIDBatteria\tStazione\tIndirizzo");
		System.out.println("----\t\t----\t----\t\t----\t\t----");
		System.out.println(ultima.getDay() + "/" + ultima.getMonth() + "/" + ultima.getYear() +
				"\t" + ultima.getHour() + ":" + ultima.getMinutes() + "\t" + ultima.getBatteryID() +
				"\t\t" + ultima.getStationName() + "\t" + ultima.getStationAddress());
		
		System.out.println ("BANANAAAAAAAAAAAA");
	}

}
