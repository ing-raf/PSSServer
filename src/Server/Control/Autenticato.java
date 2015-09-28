package Server.Control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreDisponibilita;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.Install_Outcome;
import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;

public class Autenticato extends Stato {
	
	private ValidazioneBadge badgeAutenticato;
	private ArrayList<? extends Server.BusinessLogic.AutovetturaCliente> lastElenco;
	private int indiceAutovettura;
	private ArrayList<? extends Server.BusinessLogic.Batteria> availableBatterie;
	private ServizidiSostituzione sistemaSostituzione;

	public Autenticato(ValidazioneBadge badgeAutenticato) {
		sistemaSostituzione = null;
		this.badgeAutenticato = badgeAutenticato;
		sistemaSostituzione = null;
	}

	@Override
	public ArrayList<? extends AutovetturaCliente> retrieveAutovetture(CoordinatoreClienteRegistrato coordinatore) {
		this.lastElenco = GestoreAutovetture.retrieveListaAutovetture(this.badgeAutenticato);
		
		ArrayList<AutovetturaCliente> elencoAutovetture = new ArrayList<AutovetturaCliente>( this.lastElenco.size() );			
		
		if ( this.lastElenco.isEmpty() ) {
			coordinatore.setStato( new NonAutenticato() );
		} else {
			
			for (Server.BusinessLogic.Autovettura autovettura: this.lastElenco) {
				AutovetturaCliente nuova = new AutovetturaCliente();
				nuova.setAutovetturaCliente( (Server.BusinessLogic.AutovetturaCliente) autovettura);
				elencoAutovetture.add(nuova);
			}
			
		}
				
		return elencoAutovetture;
	}

	/**
	 * 
	 * @param indiceAutovettura
	 * @param elencoBatterie
	 * @param elencoStazioni
	 */
	@Override
	public ArrayList<?> retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {		
		this.availableBatterie = GestoreDisponibilita.retrieveBatterieCompatibili( ((Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura)).getModelloAutovettura(), coordinatore.getIDStazione() ); 
		
		if ( this.availableBatterie.isEmpty() ) {
			
			ArrayList<Server.BusinessLogic.Stazione> listaStazioni = GestoreDisponibilita.remoteRetrieveBatterieCompatibili( ((Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura)).getModelloAutovettura(), coordinatore.getIDStazione());
			
			ArrayList<Stazione> elencoStazioni = new ArrayList<Stazione>( listaStazioni.size() );
			
			for (Server.BusinessLogic.Stazione stazione: listaStazioni) {
				Stazione nuova = new Stazione();
				nuova.setStazione(stazione);
				elencoStazioni.add(nuova);
			}
			
			coordinatore.setStato( new NonAutenticato() );

			return elencoStazioni;
			
		} else {
			ArrayList<Batteria> elencoBatterie = new ArrayList<Server.Control.Batteria>( this.availableBatterie.size() );
			
			for (Server.BusinessLogic.Batteria batteria: this.availableBatterie) {
				Batteria nuova = new Batteria();
				nuova.setBatteria(batteria);
				elencoBatterie.add(nuova);
			}
			
			return elencoBatterie;	
		}
		
	}
	

	/**
	 * 
	 * @param indiceBatteria
	 * @throws RemoteException 
	 */
	
	@Override
	public Install_Outcome startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		float costo = this.availableBatterie.get(indiceBatteria).getCosto();
		Install_Outcome outcome;
		
		if ( this.badgeAutenticato.verifyCredito(costo) ) {
			this.badgeAutenticato.debitBattery(costo);
		
			this.startDeviceConnection(coordinatore.getHostname(), coordinatore.getPortSostituzione()) ;
			if ( this.removeBatteria() == true) {

				if ( this.installBatteria(indiceBatteria) == true ) {
					Server.BusinessLogic.Batteria rimossa = GestoreSostituzioni.updateSostituzione( (Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(this.indiceAutovettura), coordinatore.getIDStazione(), (Server.BusinessLogic.Batteria) this.availableBatterie.get(indiceBatteria) );
				
					CoordinatoreRecupero threadRecupero = new CoordinatoreRecupero(rimossa, coordinatore.getIDStazione(), this.sistemaSostituzione);		
					ExecutorService threadExecutor = Executors.newFixedThreadPool(1);	
					threadExecutor.execute(threadRecupero);		
					threadExecutor.shutdown();
			
					outcome = Install_Outcome.OK;
					
				} else {
					outcome = Install_Outcome.SUBST_PROBLEM;
				}
				
			} else {
				outcome = Install_Outcome.SUBST_PROBLEM;
			}
			
		} else {	
			outcome = Install_Outcome.NO_MONEY;
		}
		
		coordinatore.setStato( new NonAutenticato() );
		
		return outcome;
		
			
	

	}

	@Override
	public boolean verificaEsitoValidazione() {
		return true;
	}
	
	@Override
	public void logOut(CoordinatoreClienteRegistrato coordinatore) {
		coordinatore.setStato( new NonAutenticato() );
	}
	
	private void startDeviceConnection(String hostname, int port) throws RemoteException {
		Registry registry = LocateRegistry.getRegistry(hostname, port);
		try {
			this.sistemaSostituzione = (ServizidiSostituzione) registry.lookup("sostituzione");
		} catch (NotBoundException e) {
			throw new RemoteException("Riscontrato un problema nella connessione con il sistema di sostituzione",e);
		}
		
	}
	
	private boolean removeBatteria() {
		try {
			return this.sistemaSostituzione.removeBatteria();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean installBatteria(int IDbatteria) {
		try {
			return this.sistemaSostituzione.installBatteria(IDbatteria);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
