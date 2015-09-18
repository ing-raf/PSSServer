package Server.Control;

import java.util.ArrayList;

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
	private ArrayList<? extends Batteria> availableBatteria;

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
		AutovetturaCliente scelta = this.lastElenco.get(indiceAutovettura);
		this.availableBatteria = GestoreDisponibilità.retrieveBatterieCompatibili( coordinatore.getIDStazione(), AutovetturaCliente.getAutovettura() );
		
		if ( this.availableBatteria.isEmpty() ) {
			elencoStazioni = GestoreDisponibilità.remoteRetrieveBatterieCompatibili( coordinatore.getIDStazione(), this.lastElenco.get(indiceAutovettura). );
			coordinatore.setStato( new NonAutenticato() );
			return false;
			
		} else {
			elencoBatterie = new ArrayList<Batteria>(this.availableBatteria);
			this.lastElenco.clear();
			this.lastElenco.add(scelta);
			return true;
		}
		
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) {
		this.removeBatteria();
		this.installBatteria(indiceBatteria);
		GestoreSostituzioni.updateSostituzione(this.lastElenco.get(0), coordinatore.getIDStazione(), this.availableBatteria.get(indiceBatteria) );
		GestoreDisponibilità.removeBatteria( this.availableBatteria.get(indiceBatteria) );
		// start thread CoordinatoreRecupero
		coordinatore.setStato( new NonAutenticato() );
	}

	public boolean verificaEsitoValidazione() {
		return true;
	}
	
	private void removeBatteria() {
		// TODO Auto-generated method stub
		
	}
	
	private void installBatteria(int IDbatteria) {
		// TODO Auto-generated method stub
		
	}

}