package Server.Control;

import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreBatterie;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato implements ServiziGestore {
	
	private int IDStazione;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) {
		this.IDStazione = IDStazione;
	}

	public ArrayList<Server.RMIInterface.Autovettura> retrieveListaModelli() {
		GestoreAutovetture gestoreAutovetture = new GestoreAutovetture();
		ArrayList<Server.BusinessLogic.ModelloAutovettura> listaAutovetture = gestoreAutovetture.retrieveListaModelli();
		ArrayList<Autovettura> elencoAutovetture = new ArrayList<Autovettura> ( listaAutovetture.size() );
		
		for (Server.BusinessLogic.ModelloAutovettura autovettura: listaAutovetture) {
			Autovettura nuova = new Autovettura();
			nuova.setModelloAutovettura(autovettura);
			elencoAutovetture.add(nuova);
		}
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) {
		GestoreBatterie gestoreBatterie = new GestoreBatterie();
		return gestoreBatterie.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, modelloautovettura);
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Server.RMIInterface.Batteria> elencobatterie) {
		GestoreBatterie gestoreBatterie = new GestoreBatterie();
		ArrayList<Server.BusinessLogic.Batteria> listaBatterie = gestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
		
		for (Server.BusinessLogic.Batteria batteria: listaBatterie) {
			Batteria nuova = new Batteria();
			nuova.setBatteria(batteria);
			elencobatterie.add(nuova);
		}
		
	}

	/**
	 * 
	 * @param codicebadge
	 */
	public AutovetturaCliente[] retrieveAutovettureCliente(int codicebadge) {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveAutovettureCliente
	}

	/**
	 * 
	 * @param modello
	 */
	public Stazione[] remoteRetrieveBatterieCompatibili(int modello) {
		// TODO - implement CoordinatoreGestoreAutenticato.remoteRetrieveBatterieCompatibili
	}

	public Server.RMIInterface.Sostituzione retrieveUltimaSostituzione() {
		// TODO - implement CoordinatoreGestoreAutenticato.retrieveUltimaSostituzione
	}

}