package Server.Control;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreBatterie;
import Server.BusinessLogic.GestoreDisponibilità;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato extends UnicastRemoteObject implements ServiziGestore {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -51837280579457780L;
	private int IDStazione;
	private ArrayList<? extends Autovettura> lastElenco;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) throws RemoteException {
		super();
		this.IDStazione = IDStazione;
	}

	public ArrayList<? extends Autovettura> retrieveListaModelli() {
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
	public boolean addBatteria(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) {
		return GestoreDisponibilità.addBatteria(IDStazione, IDbatteria, costosostituzione, maxcicliricarica, (Server.BusinessLogic.Autovettura) lastElenco.get(modelloautovettura) );
	}

	/**
	 * 
	 * @param IDstazione
	 * @param listabatterie
	 */
	public ArrayList<? extends Batteria> retrieveBatterieQuasiEsauste(int IDstazione) {
		return GestoreBatterie.retrieveBatterieQuasiEsauste(IDstazione);
	}

	/**
	 * 
	 * @param codicebadge
	 */
	public boolean retrieveAutovettureCliente(int codicebadge, ArrayList<AutovetturaCliente> elencoAutovetture) {
		
		if ( elencoAutovetture.isEmpty() == false ) throw new IllegalArgumentException("Non empty input array");
			
		ValidazioneBadge badge = new ValidazioneBadge();
		
		if ( badge.findCodiceBadge(codicebadge) == false ) return false;
		else {
//			elencoAutovetture = GestoreAutovetture.retrieveListaAutovetture(badge);
//			this.lastElenco = new ArrayList<AutovetturaCliente>(elencoAutovetture);
//			return true;
			this.lastElenco = GestoreAutovetture.retrieveListaAutovetture(badge);

			for (int i = 0; i < this.lastElenco.size(); i++)
				elencoAutovetture.add( (AutovetturaCliente)this.lastElenco.get(i) );
			
			System.err.println(elencoAutovetture.size());
			
			for (int i = 0; i < elencoAutovetture.size(); i++) {
				System.err.println(elencoAutovetture.get(i).getFornitore() + "\t" + elencoAutovetture.get(i).getModello() + elencoAutovetture.get(i).getNumeroTarga());
			}
			
			return true;
		}
		
	}

	/**
	 * 
	 * @param modello
	 */
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(int modello) {
		return GestoreDisponibilità.remoteRetrieveBatterieCompatibili( (Server.BusinessLogic.Autovettura) this.lastElenco.get(modello),  this.IDStazione);
	}

	public Sostituzione retrieveUltimaSostituzione(int autovettura) {	
		return GestoreSostituzioni.findLastSostituzione( (Server.BusinessLogic.AutovetturaCliente)this.lastElenco.get(autovettura) );
	}

}