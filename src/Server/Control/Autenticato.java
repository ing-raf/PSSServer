package Server.Control;

import java.util.ArrayList;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.ValidazioneBadge;

public class Autenticato extends Stato {
	
	private ValidazioneBadge badgeAutenticato;
	private ArrayList<AutovetturaCliente> lastElenco;

	public Autenticato(ValidazioneBadge badgeAutenticato) {
		this.badgeAutenticato = badgeAutenticato;
	}

	public ArrayList<Server.RMIInterface.AutovetturaCliente> retrieveAutovetture() {
		GestoreAutovetture gestoreAutovetture = new GestoreAutovetture();
		ArrayList<Server.BusinessLogic.AutovetturaCompatibile> listaAutovetture = gestoreAutovetture.retrieveListaAutovetture(this.badgeAutenticato);
		this.lastElenco = new ArrayList<AutovetturaCliente>();
		
		for (Server.BusinessLogic.AutovetturaCompatibile veicolo : listaAutovetture) {
			AutovetturaCliente nuova = new AutovetturaCliente();
			nuova.setAutovetturaCliente(veicolo);
			this.lastElenco.add(nuova);
		}
		
		return new ArrayList<Server.RMIInterface.AutovetturaCliente>(this.lastElenco);
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	public boolean retrieveBatterieCompatibili(int indiceAutovettura, ArrayList<Server.RMIInterface.Batteria> elencoBatterie, ArrayList<Server.RMIInterface.Stazione> elencoStazioni) {
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