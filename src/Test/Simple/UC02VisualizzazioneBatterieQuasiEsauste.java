package Test.Simple;

import java.util.ArrayList;

import Presentation.TerminaleGestore.GestoreAutenticatoClientLipe;
import Presentation.TerminaleGestore.InterfacciaGestoreAutenticato;
import Server.RMIInterface.Batteria;

public class UC02VisualizzazioneBatterieQuasiEsauste {
	
	private static final int IDSTAZIONE = 2;

	public static void main(String[] args) {
		
		InterfacciaGestoreAutenticato client = null;
		
		try {
			client = (InterfacciaGestoreAutenticato) new GestoreAutenticatoClientLipe(IDSTAZIONE, "localhost");
		} catch (Exception e) {
			System.err.println("Il server non risponde... È la Fasolino per caso?");
			e.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Client tutt appost tutt appost");
		
		ArrayList<? extends Batteria> esauste = new ArrayList<Batteria>();
		
		try {
			esauste = client.retrieveNearlyExhaustedBatteries();
		} catch (Exception e) {
			System.err.println("Eccezione durante l'esecuzione del messaggio II.1.2");
			e.printStackTrace();
			System.exit(0);
		}
		
		if ( esauste.isEmpty() ) System.out.println("Nessuna batteria quasi esausta in questa stazione");
		else {
			System.out.println("ID\tCosto");
			System.out.println("----\t----");
			
			for (int i = 0; i < esauste.size(); i++) {
				System.out.println(esauste.get(i).getID() + "\t" + esauste.get(i).getCostSubstitution());
			}
		}
		
		System.out.println ("BANANAAAAAAAAAAAA");

	}

}
