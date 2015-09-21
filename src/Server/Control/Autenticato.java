package Server.Control;

import java.rmi.ConnectIOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.transaction.InvalidTransactionException;

import Server.BusinessLogic.GestoreAutovetture;
import Server.BusinessLogic.GestoreDisponibilità;
import Server.BusinessLogic.GestoreSostituzioni;
import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.AutovetturaCliente;
import Server.RMIInterface.Batteria;
import Server.RMIInterface.Stazione;
import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;

public class Autenticato extends Stato {
	
	private ValidazioneBadge badgeAutenticato;
	private ArrayList<? extends AutovetturaCliente> lastElenco;
	private int indiceAutovettura;
	private ArrayList<? extends Batteria> availableBatterie;
	private ServizidiSostituzione sistemaSostituzione;

	public Autenticato(ValidazioneBadge badgeAutenticato) {
		sistemaSostituzione = null;
		this.badgeAutenticato = badgeAutenticato;
		sistemaSostituzione = null;
	}

	@Override
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
/*	public boolean retrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura, ArrayList<? extends Batteria> elencoBatterie, ArrayList<? extends Stazione> elencoStazioni) {
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
		
	} */
	
	@Override
	public ArrayList<? extends Batteria> retrieveBatterieCompatibili(int IDStazione, int indiceAutovettura) {		
		this.availableBatterie = GestoreDisponibilità.retrieveBatterieCompatibili( ((Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura)).getModelloAutovettura(), IDStazione ); 
		return new ArrayList<Batteria>(this.availableBatterie);			
	}
	
	@Override
	public ArrayList<? extends Stazione> remoteRetrieveBatterieCompatibili(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {
		coordinatore.setStato( new NonAutenticato() );
		return GestoreDisponibilità.remoteRetrieveBatterieCompatibili( (Server.BusinessLogic.AutovetturaCliente) this.lastElenco.get(indiceAutovettura), coordinatore.getIDStazione());
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
		if (GestoreDisponibilità.removeBatteria( (Server.BusinessLogic.Batteria) this.availableBatterie.get(indiceBatteria), coordinatore.getIDStazione() ) == false ) throw new InvalidTransactionException("Il server non è riuscito a rimuovere");
		
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
