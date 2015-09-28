package Server.Control;

import java.rmi.ConnectIOException;
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
	public ArrayList<? extends AutovetturaCliente> retrieveAutovetture() {
		this.lastElenco = GestoreAutovetture.retrieveListaAutovetture(this.badgeAutenticato);
		
		ArrayList<AutovetturaCliente> elencoAutovetture = new ArrayList<AutovetturaCliente>( this.lastElenco.size() );			
		
		for (Server.BusinessLogic.Autovettura autovettura: this.lastElenco) {
			AutovetturaCliente nuova = new AutovetturaCliente();
			nuova.setAutovetturaCliente( (Server.BusinessLogic.AutovetturaCliente) autovettura);
			elencoAutovetture.add(nuova);
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
	public boolean startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		this.startDeviceConnection(coordinatore.getHostname(), coordinatore.getPortSostituzione()) ;
		if ( this.removeBatteria() == false) throw new ConnectIOException("Riscontrato un problema durante la rimozione della vecchia batteria");
		if ( this.installBatteria(indiceBatteria) == false ) throw new ConnectIOException("Riscontrato un problema durante l'installazione della batteria");
		Server.BusinessLogic.Batteria rimossa = GestoreSostituzioni.updateSostituzione( (Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(this.indiceAutovettura), coordinatore.getIDStazione(), (Server.BusinessLogic.Batteria) this.availableBatterie.get(indiceBatteria) );
		
		CoordinatoreRecupero threadRecupero = new CoordinatoreRecupero(rimossa, coordinatore.getIDStazione(), this.sistemaSostituzione);		
		ExecutorService threadExecutor = Executors.newFixedThreadPool(1);	
		threadExecutor.execute(threadRecupero);		
		threadExecutor.shutdown();
		
		coordinatore.setStato( new NonAutenticato() );
		return true;
	}

	@Override
	public boolean verificaEsitoValidazione() {
		return true;
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
