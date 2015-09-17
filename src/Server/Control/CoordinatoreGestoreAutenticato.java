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

	public ArrayList<Server.RMIInterface.Autovettura> retrieveListaModelli() {
		ArrayList<Server.BusinessLogic.Autovettura> listaAutovetture = GestoreAutovetture.retrieveListaModelli();
		this.lastElenco = new ArrayList<Autovettura>();
		
		for (Server.BusinessLogic.Autovettura autovettura: listaAutovetture) {
			Autovettura nuova = new Autovettura();
			nuova.setModelloAutovettura(autovettura);
			this.lastElenco.add(nuova);
		}
		
		return new ArrayList<Server.RMIInterface.Autovettura>(this.lastElenco);
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) {
		return GestoreBatterie.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, modelloautovettura);
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public boolean retrieveBatterieQuasiEsauste(int IDstazione, ArrayList<Server.RMIInterface.Batteria> elencobatterie) {
		ArrayList<Server.BusinessLogic.Batteria> listaBatterie = GestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
		elencoBatterie = new ArrayList<Server.RMIInterface.Batteria>();
		
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
	public boolean retrieveAutovettureCliente(int codicebadge, ArrayList<AutovetturaCliente> elencoAutovetture) {
		ValidazioneBadge badge = new ValidazioneBadge();
		
		if ( badge.findCodiceBadge(codicebadge) == false ) return false;
		else {
			ArrayList<Server.BusinessLogic.AutovetturaCliente> listaAutovetture = GestoreAutovetture.retrieveListaAutovetture(badge);
			elencoAutovetture = new ArrayList<AutovetturaCliente>();
			
			for (Server.BusinessLogic.AutovetturaCliente veicolo : listaAutovetture) {
				AutovetturaCliente nuova = new AutovetturaCliente();
				nuova.setAutovetturaCliente(veicolo);
				elencoAutovetture.add(nuova);
			}
			
			this.lastElenco = new ArrayList<Autovettura>( elencoAutovetture.size() );
			this.lastElenco.addAll(elencoAutovetture);
			
			return true;
		}
		
	}

	/**
	 * 
	 * @param modello
	 */
	public ArrayList<Stazione> remoteRetrieveBatterieCompatibili(int modello) {
		ArrayList<Server.BusinessLogic.Stazione> listaStazioni = GestoreSostituzioni.remoteRetrieveBatterieCompatibili( this.lastElenco.get(modello) );
		ArrayList<Stazione> elencoStazioni = new ArrayList<Stazione> (listaStazioni.size() );
		
		for (Server.BusinessLogic.Stazione stazione : listaStazioni) {
			Stazione nuova = new Stazione();
			nuova.setStazione(stazione);
			elencoStazioni.add(nuova);
		}
		
		return elencoStazioni;
	}

	public Sostituzione retrieveUltimaSostituzione(int autovettura) {	
		Server.BusinessLogic.UltimaSostituzione sostituzione = GestoreSostituzioni.findLastSostituzione( this.lastElenco.get(autovettura) );

		Sostituzione ultima = new Sostituzione();
		ultima.setSostituzione(sostituzione);
		
		return ultima;
	}

}