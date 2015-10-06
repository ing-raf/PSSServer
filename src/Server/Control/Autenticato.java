package Server.Control;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Server.BusinessLogic.AutovetturaBL;
import Server.BusinessLogic.AutovetturaClienteBL;
import Server.BusinessLogic.BatteriaBL;
import Server.BusinessLogic.GestoreBadge;
import Server.BusinessLogic.GestoreStazione;
import Server.BusinessLogic.StazioneBL;
import Server.RMIInterface.Install_Outcome;
import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;

public class Autenticato extends Stato {

	private int codiceBadge;
	private ArrayList<? extends AutovetturaClienteBL> elencoAutovetture;
	private int indiceAutovettura;
	private ArrayList<? extends BatteriaBL> batterieDisponibili;
	private ServizidiSostituzione sistemaSostituzione;

	public Autenticato(int codiceBadge) {
		
		this.codiceBadge = codiceBadge;
		this.sistemaSostituzione = null;
		
	}

	@Override
	public ArrayList<AutovetturaClienteC> retrieveCompatibleCars(CoordinatoreClienteRegistrato coordinatore) {
		GestoreBadge gb = new GestoreBadge(this.codiceBadge);
		
		this.elencoAutovetture = gb.retrieveCarList();
		
		ArrayList<AutovetturaClienteC> elencoAutovetture = new ArrayList<AutovetturaClienteC>( this.elencoAutovetture.size() );			
		
		if ( this.elencoAutovetture.isEmpty() ) {
			coordinatore.setState( new NonAutenticato() );
		} else {
			
			for (AutovetturaClienteBL autovettura: this.elencoAutovetture)
				elencoAutovetture.add( new AutovetturaClienteC(autovettura.getBrand(), autovettura.getModel(), autovettura.getNumberPlate()) );
			
		}
				
		return elencoAutovetture;
	}

	@Override
	public ArrayList<?> retrieveCompatibleBatteries(CoordinatoreClienteRegistrato coordinatore, int indiceAutovettura) {		
		GestoreStazione gs = new GestoreStazione(coordinatore.getStationID());
				
		this.batterieDisponibili = gs.retrieveCompatibleBatteries( new AutovetturaBL(this.elencoAutovetture.get(indiceAutovettura).getModel(), this.elencoAutovetture.get(indiceAutovettura).getBrand()) );
		
		if ( this.batterieDisponibili.isEmpty() ) {
			
			ArrayList<StazioneC> elencoStazioni = new ArrayList<StazioneC>();
			
			for (StazioneBL stazione: gs.remoteRetrieveCompatibleBatteries(new AutovetturaBL(this.elencoAutovetture.get(indiceAutovettura).getModel(), this.elencoAutovetture.get(indiceAutovettura).getBrand())) ) 
				elencoStazioni.add( new StazioneC(stazione.getName(), stazione.getAddress()) );
			
			coordinatore.setState( new NonAutenticato() );
			
			return elencoStazioni;
			
		} else {
			
			ArrayList<BatteriaC> elencoBatterie = new ArrayList<BatteriaC> ( this.batterieDisponibili.size() );
			
			for (BatteriaBL batteria: this.batterieDisponibili) 
				elencoBatterie.add( new BatteriaC(batteria.getID(), batteria.getCostSubstitution()) );
			
			return elencoBatterie;	
		}
		
	}
	
	@Override
	public Install_Outcome startInstallation(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) throws RemoteException {
		float costo = this.batterieDisponibili.get(indiceBatteria).getCostSubstitution();
		Install_Outcome outcome;
		
		GestoreBadge gb = new GestoreBadge(this.codiceBadge);
		
		if ( gb.verifyCredit(costo) ) {
			gb.debit(costo);
		
			this.startDeviceConnection(coordinatore.getSubstitutionDeviceHostname(), coordinatore.getSubstitutionDevicePort()) ;
			if ( this.removeBattery() == true) {

				if ( this.installBattery(indiceBatteria) == true ) {
					GestoreStazione gs = new GestoreStazione(coordinatore.getStationID());
					
					BatteriaBL rimossa = new BatteriaBL();
					if ( gs.updateSubstitution( this.elencoAutovetture.get(this.indiceAutovettura), this.batterieDisponibili.get(indiceBatteria), rimossa) ) {
				
						CoordinatoreRecupero threadRecupero = new CoordinatoreRecupero(rimossa, coordinatore.getStationID(), this.sistemaSostituzione);		
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
				outcome = Install_Outcome.SUBST_PROBLEM;
			}
			
		} else {	
			outcome = Install_Outcome.NO_MONEY;
		}
		
		coordinatore.setState( new NonAutenticato() );
		
		return outcome;
		
			
	

	}

	@Override
	public boolean verifyValidationOutcome() {
		return true;
	}
	
	@Override
	public void logOut(CoordinatoreClienteRegistrato coordinatore) {
		coordinatore.setState( new NonAutenticato() );
	}
	
	private void startDeviceConnection(String hostname, int port) throws RemoteException {
		Registry registry = LocateRegistry.getRegistry(hostname, port);
		try {
			this.sistemaSostituzione = (ServizidiSostituzione) registry.lookup("sostituzione");
		} catch (NotBoundException e) {
			throw new RemoteException("Riscontrato un problema nella connessione con il sistema di sostituzione",e);
		}
		
	}
	
	private boolean removeBattery() {
		try {
			return this.sistemaSostituzione.removeBatteria();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean installBattery(int IDbatteria) {
		try {
			return this.sistemaSostituzione.installBatteria(IDbatteria);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
