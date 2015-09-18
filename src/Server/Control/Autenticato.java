package Server.Control;

import java.rmi.ConnectIOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import javax.transaction.InvalidTransactionException;

import Server.BusinessLogic.Autovettura;
import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreDisponibilità;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;

public class Autenticato extends Stato {
	
	private ValidazioneBadge badgeAutenticato;
	private ArrayList<? extends AutovetturaCliente> lastElenco;
	private int indiceAutovettura;
	private ArrayList<? extends Batteria> availableBatterie;

	public Autenticato(ValidazioneBadge badgeAutenticato) {
		this.badgeAutenticato = badgeAutenticato;
	}

	public ArrayList<AutovetturaCliente> retrieveAutovetture() {
		this.lastElenco = GestoreAutovetture.retrieveListaAutovetture(this.badgeAutenticato);
		
		return new ArrayList<Server.RMIInterface.AutovetturaCliente>(this.lastElenco);
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura, ArrayList<? extends Batteria> elencoBatterie, ArrayList<? extends Stazione> elencoStazioni) {
		this.availableBatterie = GestoreDisponibilità.retrieveBatterieCompatibili( ((Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura)).getModelloAutovettura(), coordinatore.getIDStazione() );
		
		if ( this.availableBatterie.isEmpty() ) {
			elencoStazioni = GestoreDisponibilità.remoteRetrieveBatterieCompatibili( ((Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura)).getModelloAutovettura(), coordinatore.getIDStazione() );
			coordinatore.setStato( new NonAutenticato() );
			return false;
		} else {
			this.indiceAutovettura = indiceAutovettura;
			elencoBatterie = new ArrayList<Batteria>(this.availableBatterie);
			return true;
		}
		
	}

	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	public boolean startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		if ( this.removeBatteria() == false) throw new ConnectIOException("Riscontrato un errore durante la rimozione della vecchia batteria");
		if ( this.installBatteria(indiceBatteria) == false ) throw new ConnectIOException("Riscontrato un errore durante l'installazione della batteria");
		Batteria rimossa = GestoreSostituzioni.updateSostituzione( (Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(this.indiceAutovettura), coordinatore.getIDStazione(), (Server.BusinessLogic.Batteria) this.availableBatterie.get(indiceBatteria) );
		if (GestoreDisponibilità.removeBatteria( (Server.BusinessLogic.Batteria) this.availableBatterie.get(indiceBatteria), coordinatore.getIDStazione() ) == false ) throw new InvalidTransactionException("Il server non è riuscito a rimuovere");
		// start thread CoordinatoreRecupero
		coordinatore.setStato( new NonAutenticato() );
		return true;
	}

	public boolean verificaEsitoValidazione() {
		return true;
	}
	
	private boolean removeBatteria() {
		// TODO Auto-generated method stub
		return false;
		
	}
	
	private boolean installBatteria(int IDbatteria) {
		// TODO Auto-generated method stub
		return false;
	}

}