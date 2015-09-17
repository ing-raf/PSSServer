package Server.Control;

import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreBatterie;
import Server.BusinessLogic.GestoreDisponibilità;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato implements ServiziGestore {
	
	private int IDStazione;
	private ArrayList<Autovettura> lastElenco;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) {
		this.IDStazione = IDStazione;
	}

	public ArrayList<Autovettura> retrieveListaModelli() {
		ArrayList<Server.BusinessLogic.Autovettura> listaAutovetture = GestoreAutovetture.retrieveListaModelli();
		this.lastElenco = new ArrayList<Autovettura>(listaAutovetture);
		
		return new ArrayList<Autovettura>(this.lastElenco);
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) {
		return GestoreBatterie.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, lastElenco.get(modelloautovettura) );
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Batteria> elencobatterie) {
		ArrayList<Server.BusinessLogic.Batteria> listaBatterie = GestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
		elencobatterie = new ArrayList<Batteria>(listaBatterie);
		
	}

	/**
	 * 
	 * @param codicebadge
	 */
	public boolean retrieveAutovettureCliente(int codicebadge, ArrayList<AutovetturaCliente> elencoAutovetture) {
		ValidazioneBadge badge = new ValidazioneBadge();
		
		if ( badge.findCodiceBadge(codicebadge) == false ) return false;
		else {
			ArrayList<Server.BusinessLogic.AutovetturaCliente> listaAutovetture = GestoreAutovetture.retrieveListaAutovetture(badge);
			this.lastElenco = new ArrayList<Autovettura>( listaAutovetture);
			elencoAutovetture = new ArrayList<AutovetturaCliente>(listaAutovetture);
			
			return true;
		}
		
	}

	/**
	 * 
	 * @param modello
	 */
	public ArrayList<Stazione> remoteRetrieveBatterieCompatibili(int modello) {
		return GestoreDisponibilità.remoteRetrieveBatterieCompatibili( this.lastElenco.get(modello) );
	}

	public Sostituzione retrieveUltimaSostituzione(int autovettura) {	
		return GestoreSostituzioni.findLastSostituzione( (Server.BusinessLogic.AutovetturaCliente)this.lastElenco.get(autovettura) );
	}

}