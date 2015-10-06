package Server.Control;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;

import Server.BusinessLogic.AutovetturaBL;
import Server.BusinessLogic.AutovetturaClienteBL;
import Server.BusinessLogic.BatteriaBL;
import Server.BusinessLogic.GestoreBadge;
import Server.BusinessLogic.GestoreSocieta;
import Server.BusinessLogic.GestoreStazione;
import Server.BusinessLogic.StazioneBL;
import Server.BusinessLogic.UltimaSostituzioneBL;
import Server.RMIInterface.*;

public class CoordinatoreGestoreAutenticato extends UnicastRemoteObject implements ServiziGestore, ServiziGestoreAndroid {
	
	private static final long serialVersionUID = -51837280579457780L;
	private static final int soglia = 5;
	private int IDStazione;
	private ArrayList<? extends AutovetturaBL> elencoModelli;
	private int codiceBadge;
	
	public CoordinatoreGestoreAutenticato (int IDStazione) throws Exception {
		super();
		this.IDStazione = IDStazione;
	}

	@Override
	public ArrayList<? extends Autovettura> retrieveModelList() throws Exception {
		GestoreSocieta gs = new GestoreSocieta();
		
		this.elencoModelli = gs.retrieveModelList();		
		
		ArrayList<Autovettura> elencoAutovetture = new ArrayList<Autovettura>( this.elencoModelli.size() );
		
		for (AutovetturaBL autovettura: this.elencoModelli) {
			elencoAutovetture.add( new AutovetturaC(autovettura.getModel(), autovettura.getBrand()) );
		}
				
		return elencoAutovetture;
	}

	@Override
	public boolean addBattery(int IDbatteria, float costosostituzione, int maxcicliricarica, int modelloautovettura) throws Exception {
		@SuppressWarnings("static-access")
		GestoreStazione gs = new GestoreStazione (this.IDStazione, this.soglia);
		return gs.insertBattery( new BatteriaBL(IDbatteria, costosostituzione, maxcicliricarica, 
				this.elencoModelli.get(modelloautovettura).getModel(), this.elencoModelli.get(modelloautovettura).getBrand()) );

	}

	@Override
	public ArrayList<? extends Batteria> retrieveNearlyExhaustedBatteries() throws Exception {
		@SuppressWarnings("static-access")
		GestoreStazione gs = new GestoreStazione (this.IDStazione, this.soglia);
			ArrayList<Batteria> elencoBatterie = new ArrayList<Batteria>();
			
			for (BatteriaBL batteria: gs.retrieveNearlyExhaustedBatteries() ) {
				elencoBatterie.add( new BatteriaC (batteria.getID(), batteria.getCostSubstitution() ) );
			}
			
			return elencoBatterie;

	}

	@Override
	public ArrayList<? extends AutovetturaCliente> retrieveCompatibleCars(int codicebadge) throws Exception {
		
		GestoreBadge gb = null;
		
		try {
			
			gb = new GestoreBadge(codicebadge);
			
			this.codiceBadge = codicebadge;
			
		} catch (NullPointerException npe) {
			return null;
		}
	
		this.elencoModelli = gb.retrieveCarList();
		
		ArrayList<AutovetturaCliente> elencoAutovetture = new ArrayList<AutovetturaCliente>( this.elencoModelli.size() );			
			
		for (AutovetturaBL autovettura: this.elencoModelli) {
			AutovetturaClienteBL ac = (AutovetturaClienteBL) autovettura;
			elencoAutovetture.add( new AutovetturaClienteC(ac.getBrand(), ac.getModel(), ac.getNumberPlate() ) );
		}
					
		return elencoAutovetture;
		
	}

	@Override
	public ArrayList<? extends Stazione> remoteRetrieveCompatibleBatteries(int modello) throws Exception {
		
		@SuppressWarnings("static-access")
		GestoreStazione gs = new GestoreStazione (this.IDStazione, this.soglia);
				
		ArrayList<Stazione> elencoStazioni = new ArrayList<Stazione> ();
		
		for (StazioneBL stazione : gs.remoteRetrieveCompatibleBatteries( this.elencoModelli.get(modello) )) {
			elencoStazioni.add( new StazioneC(stazione.getName(), stazione.getAddress()) );
		}
		
		return elencoStazioni;
	}

	@Override
	public UltimaSostituzione retrieveLastSubstitution(int autovettura) throws Exception {	
		
		GestoreBadge gb = null;
		
		try {
			
			gb = new GestoreBadge(this.codiceBadge);
			
		} catch (NullPointerException npe) {
			return null;
		}
		
		UltimaSostituzioneBL sostituzione = gb.findLastSubstitution( ( (AutovetturaClienteBL)this.elencoModelli.get(autovettura) ).getNumberPlate() );

		return new UltimaSostituzioneC(
				sostituzione.getDateHour().get(Calendar.DAY_OF_MONTH),
				sostituzione.getDateHour().get(Calendar.MONTH),
				sostituzione.getDateHour().get(Calendar.YEAR),
				sostituzione.getDateHour().get(Calendar.HOUR),
				sostituzione.getDateHour().get(Calendar.MINUTE),
				sostituzione.getStationName(),
				sostituzione.getStationAddress(),
				sostituzione.getBatteryID());
	}

}