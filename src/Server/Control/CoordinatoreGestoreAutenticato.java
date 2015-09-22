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
	private ArrayList<? extends Autovettura> lastElenco;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) throws Exception {
		super();
		this.IDStazione = IDStazione;
	}

	public ArrayList<? extends Autovettura> retrieveListaModelli() throws Exception {
		this.lastElenco = GestoreAutovetture.retrieveListaModelli();		
		return new ArrayList<Autovettura>(this.lastElenco);
	}

	/**
	 * 
	 * @param IDbatteria
	 * @param costosostituzione
	 * @param maxciclidiricarica
	 * @param modelloautovettura
	 */
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) throws Exception {
		return GestoreDisponibilità.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, (Server.BusinessLogic.Autovettura) lastElenco.get(modelloautovettura) );
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
			
			return new ArrayList<AutovetturaCliente>( (ArrayList<AutovetturaCliente>)this.lastElenco );
		}
		
	}

	/**
	 * 
	 * @param modello
	 */
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) throws Exception {
		return GestoreDisponibilità.remoteRetrieveBatterieCompatibili( (Server.BusinessLogic.Autovettura) this.lastElenco.get(modello),  this.IDStazione);
	}

	public Sostituzione retrieveUltimaSostituzione(int autovettura) throws Exception {	
		return GestoreSostituzioni.findLastSostituzione( (Server.BusinessLogic.AutovetturaCliente)this.lastElenco.get(autovettura) );
	}

}