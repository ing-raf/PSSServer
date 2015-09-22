package Server.Control;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreBatterie;
import Server.BusinessLogic.GestoreDisponibilità;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato extends UnicastRemoteObject implements ServiziGestore, ServiziGestoreAndroid {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -51837280579457780L;
	private int IDStazione;
	private ArrayList<? extends Server.BusinessLogic.Autovettura> lastElenco;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) throws Exception {
		super();
		this.IDStazione = IDStazione;
	}

	public ArrayList<? extends Autovettura> retrieveListaModelli() throws Exception {
		this.lastElenco = GestoreAutovetture.retrieveListaModelli();		
		
		ArrayList<Autovettura> elencoAutovetture = new ArrayList<Autovettura>( this.lastElenco.size() );
		
		for (Server.BusinessLogic.Autovettura autovettura: this.lastElenco) {
			Autovettura nuova = new Autovettura();
			nuova.setModelloAutovettura(autovettura);
			elencoAutovetture.add(nuova);
		}
				
		return elencoAutovetture;
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) throws Exception {
		return GestoreDisponibilità.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, this.lastElenco.get(modelloautovettura) );
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) throws Exception {
			ArrayList<Server.BusinessLogic.Batteria> listaBatterie = GestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
			ArrayList<Batteria> elencoBatterie = new ArrayList<Server.Control.Batteria>(listaBatterie.size());
			
			for (Server.BusinessLogic.Batteria batteria: listaBatterie) {
				Batteria nuova = new Batteria();
				nuova.setBatteria(batteria);
				elencoBatterie.add(nuova);
			}
			
			return elencoBatterie;

	}

	/**
	 * 
	 * @param codicebadge
	 */
	public ArrayList<? extends AutovetturaCliente> retrieveAutovettureCliente(int codicebadge) throws Exception {
		
		ValidazioneBadge badge = new ValidazioneBadge();
		
		if ( badge.findCodiceBadge(codicebadge) == false ) {
			return new ArrayList<AutovetturaCliente>(0);
		}
		else {
			
			this.lastElenco = GestoreAutovetture.retrieveListaAutovetture(badge);
		
			ArrayList<AutovetturaCliente> elencoAutovetture = new ArrayList<AutovetturaCliente>( this.lastElenco.size() );			
			
			for (Server.BusinessLogic.Autovettura autovettura: this.lastElenco) {
				AutovetturaCliente nuova = new AutovetturaCliente();
				nuova.setAutovetturaCliente( (Server.BusinessLogic.AutovetturaCliente) autovettura);
				elencoAutovetture.add(nuova);
			}
					
			return elencoAutovetture;
		}
		
	}

	/**
	 * 
	 * @param modello
	 */
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws Exception {
		ArrayList<Server.BusinessLogic.Stazione> listaStazioni = GestoreDisponibilità.remoteRetrieveBatterieCompatibili( this.lastElenco.get(modello),  this.IDStazione);
		
		ArrayList<Stazione> elencoStazioni = new ArrayList<Stazione> (listaStazioni.size() );
		
		for (Server.BusinessLogic.Stazione stazione : listaStazioni) {
			Stazione nuova = new Stazione();
			nuova.setStazione(stazione);
			elencoStazioni.add(nuova);
		}
		
		return elencoStazioni;
	}

	public UltimaSostituzione retrieveUltimaSostituzione(int autovettura) throws Exception {	
		Server.BusinessLogic.UltimaSostituzione sostituzione = GestoreSostituzioni.findLastSostituzione( (Server.BusinessLogic.AutovetturaCliente)this.lastElenco.get(autovettura) );
		UltimaSostituzione ultima = new UltimaSostituzione();
		ultima.setSostituzione(sostituzione);
		
		return ultima;
	}

}