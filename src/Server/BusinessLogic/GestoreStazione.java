package Server.BusinessLogic;

import java.util.ArrayList;
import java.util.Calendar;

import Server.Entity.AutovetturaCompatibile;
import Server.Entity.Batteria;
import Server.Entity.ModelloAutovettura;
import Server.Entity.Societa;
import Server.Entity.Stazione;
import Server.Entity.UltimaSostituzione;

public class GestoreStazione {
	
	private final static int DEFAULT_TRESHOLD = 5;
	private int ID;
	private int soglia;
	
	public GestoreStazione(int ID) {
		
		Societa laSocieta = Societa.getSociety();
		if ( !laSocieta.findStation(ID) )
			throw new NullPointerException("Stazione non presente");
		this.ID = ID;
		this.soglia = DEFAULT_TRESHOLD;
		
	}
	
	public GestoreStazione(int ID, int soglia) {
		
		Societa laSocieta = Societa.getSociety();
		if ( !laSocieta.findStation(ID) )
			throw new NullPointerException("Stazione non presente");
		this.ID = ID;
		this.soglia = soglia;
		
	}
	
	@SuppressWarnings("unused")
	public boolean insertBattery(BatteriaBL nuova) {
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		Batteria b = null;
		
		ModelloAutovettura modello = new ModelloAutovettura();
		modello.setBrand( nuova.getBrand() );
		modello.setModel( nuova.getModel() );
		try {
		b = new Batteria( nuova.getID(), nuova.getCostSubstitution(),
				nuova.getCyclesRecharge(), modello);
		
			return locale.update();
			}catch (NullPointerException ex) {
				return false;
			}
		
	}
	
	public boolean addBattery(BatteriaBL nuova) {
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		
		Batteria b = new Batteria();
		b.setID( nuova.getID() );
		b.setCostSubstitution( nuova.getCostSubstitution() );
		b.setCyclesRecharge( nuova.getCyclesRecharge() );
			ModelloAutovettura modello = new ModelloAutovettura();
			modello.setBrand( nuova.getBrand() );
			modello.setModel( nuova.getModel() );
		b.setModel(modello);
		
		locale.setAvailableBatteries(b);
		return locale.update();
	}
	
	public boolean verifyRecharge(BatteriaBL rimossa) {
		if (rimossa.getCyclesRecharge() > 0) return true;
		else return false;
	}
	
	public boolean discardBattery(BatteriaBL esausta) {
		
		Batteria exhausted = new Batteria();
		exhausted.setID( esausta.getID() );
		exhausted.setCostSubstitution( esausta.getCostSubstitution() );
		exhausted.setCyclesRecharge( esausta.getCyclesRecharge() );
			ModelloAutovettura model = new ModelloAutovettura();
			model.setModel( esausta.getModel() );
			model.setBrand( esausta.getBrand() );
		exhausted.setModel(model);
		return exhausted.delete();
		
	}
	
	public ArrayList<BatteriaBL> retrieveCompatibleBatteries (AutovetturaBL modello) {
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		
		ModelloAutovettura model = new ModelloAutovettura();
		model.setModel( modello.getModel() );
		model.setBrand( modello.getBrand() );
		
		ArrayList<BatteriaBL> elencoBatterie = new ArrayList<BatteriaBL>();
		
		for (Batteria b : locale.getAvailableBatteries()) {
			if ( b.getModel().equals(model) ) 
				elencoBatterie.add( new BatteriaBL(b.getID(), b.getCostSubstitution(), b.getCyclesRecharge(),
						b.getModel().getModel(), b.getModel().getBrand() ) );
			
		}
		
		return elencoBatterie;
		
	}
	
	public ArrayList<StazioneBL> remoteRetrieveCompatibleBatteries (AutovetturaBL modello) {
		
		ModelloAutovettura model = new ModelloAutovettura();
		model.setModel( modello.getModel() );
		model.setBrand( modello.getBrand() );
		
		Societa laSocieta = Societa.getSociety();
		
		ArrayList<StazioneBL> elencoStazioni = new ArrayList<StazioneBL>(); 
		
		for (Stazione s : laSocieta.getStationList() ) 
			if (!s.equals(laSocieta.getStation(this.ID))) {
				
				ArrayList<Batteria> listaBatterie = s.getAvailableBatteries();
				
				boolean hit = false;
				int k = 0;
				
				while (hit == false && k < listaBatterie.size()) {
					
					if ( listaBatterie.get(k).getModel().equals(model) ) {
						elencoStazioni.add( new StazioneBL (s.getID(), s.getName(), s.getAddress()));
						hit = true;
					}
					k++;
					
				}
				
			}
		
		return elencoStazioni;
	}
	
	public boolean updateSubstitution(AutovetturaClienteBL auto, BatteriaBL nuova, BatteriaBL vecchia) {
		AutovetturaCompatibile car = 
				AutovetturaCompatibile.getCar(auto.getNumberPlate());
		
		Batteria old = car.getLastSubstitution().getBattery();
		vecchia.setID(old.getID());
		vecchia.setCostSubstitution(old.getCostSubstitution());
		vecchia.setCyclesRecharge(old.getCyclesRecharge());
		vecchia.setBrand(old.getModel().getBrand());
		vecchia.setModel(old.getModel().getModel());
		
		Batteria fresh = new Batteria();
		fresh.setID( nuova.getID() );
		fresh.setCostSubstitution( nuova.getCostSubstitution() );
		fresh.setCyclesRecharge( nuova.getCyclesRecharge() );
			ModelloAutovettura modello = new ModelloAutovettura();
			modello.setBrand( nuova.getBrand() );
			modello.setModel( nuova.getModel() );
		fresh.setModel(modello);
		
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		
		UltimaSostituzione update = new UltimaSostituzione();
		
		update.setBattery(fresh);
		Calendar momentoSostituzione = Calendar.getInstance();
		momentoSostituzione.clear();
		momentoSostituzione.set(Calendar.getInstance().get(Calendar.YEAR),
				Calendar.getInstance().get(Calendar.MONTH), 
				Calendar.getInstance().get(Calendar.DAY_OF_MONTH),
				Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
				Calendar.getInstance().get(Calendar.MINUTE) );
		update.setDateHour( momentoSostituzione );
		update.setSubstitutionStation(locale);
		car.setLastSubstitution(update);
		
		return car.update();
	}
	
	public ArrayList<BatteriaBL> retrieveNearlyExhaustedBatteries() {
		
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		
		ArrayList<Batteria> listaBatterie = locale.getAvailableBatteries();
		ArrayList<BatteriaBL> elencoBatterie = new ArrayList<BatteriaBL>( listaBatterie.size() );
		
		for(Batteria b : listaBatterie) {
			if (b.getCyclesRecharge() < this.soglia) {
				elencoBatterie.add( new BatteriaBL(b.getID(), b.getCostSubstitution(), 
						b.getCyclesRecharge(), b.getModel().getModel(), b.getModel().getBrand()) );
			}
		}
		
		return elencoBatterie;
		
	}

}
