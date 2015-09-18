package Server.Control;

import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.AutovetturaCliente;

public class Autenticato extends Stato {
	
	private ValidazioneBadge badgeAutenticato;
	private ArrayList<? extends AutovetturaCliente> lastElenco;

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
	public boolean retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura, ArrayList<Batteria> elencoBatterie, ArrayList<Stazione> elencoStazioni) {
		// TODO - implement Autenticato.retrieveBatterieCompatibili
	}

	/**
	 * 
	 * @param indiceBatteria
	 */
	public boolean startInstallazione(int indiceBatteria) {
		// TODO - implement Autenticato.startInstallazione
	}

	public boolean verificaEsitoValidazione() {
		return true;
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 */
}