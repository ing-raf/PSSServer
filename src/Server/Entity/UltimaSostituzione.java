package Server.Entity;

import java.util.Calendar;

import Server.DAO.BatteriaDAO;
import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.StazioneDAO;
import Server.DAO.UltimaSostituzioneDAO;

public class UltimaSostituzione {
	
	private Calendar dataOra;
	private Stazione staz_sostituz;
	private Batteria batteria;
	//private AutovetturaCompatibile autovettura;
	
	public UltimaSostituzione() {
		
	}
	
	public UltimaSostituzione(String targa) {
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		this.dataOra = dao.getDateHour();
		this.batteria = new Batteria();
			this.batteria.setID( dao.getBattery().getID() );
			this.batteria.setCostSubstitution( dao.getBattery().getCostSubstitution() );
			this.batteria.setCyclesRecharge( dao.getBattery().getCyclesRecharge() );
				ModelloAutovettura modello = new ModelloAutovettura();
				modello.setBrand( dao.getBattery().getModel().getBrand() );
				modello.setModel( dao.getBattery().getModel().getModel() );
				this.batteria.setModel(modello);
				this.staz_sostituz = new Stazione ();
			this.staz_sostituz.setAddress(dao.getStation().getAddress());
			this.staz_sostituz.setName(dao.getStation().getName());
			this.staz_sostituz.setID(dao.getStation().getID());
			
			for (BatteriaDAO b: dao.getStation().getAvailableBatteries()){
				Batteria batt = new Batteria ();
				batt.setID(b.getID());
				batt.setCostSubstitution(b.getCostSubstitution());
				batt.setCyclesRecharge(b.getCyclesRecharge());
				ModelloAutovettura mod = new ModelloAutovettura ();
				mod.setBrand(b.getModel().getBrand());
				mod.setModel(b.getModel().getModel());
				batt.setModel(mod);
				
				this.staz_sostituz.setAvailableBatteries(batt);
			}

	}
	
	public Calendar getDateHour() {
		return dataOra;
	}
	
	public void setDateHour(Calendar dataOra) {
		this.dataOra = dataOra;
	}

	public Stazione getSubstitutionStation() {
		return staz_sostituz;
	}

	public void setSubstitutionStation(Stazione staz_sostituz) {
		this.staz_sostituz = staz_sostituz;
	}

	public Batteria getBattery() {
		return batteria;
	}

	public void setBattery(Batteria batteria) {
		this.batteria = batteria;
	}

	/*public AutovetturaCompatibile getCar() {
		return autovettura;
	}

	public void setCar(AutovetturaCompatibile autovettura) {
		this.autovettura = autovettura;
	}*/
	
	public boolean update(String targa ) {
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		
		StazioneDAO stazione = new StazioneDAO();
		stazione.setAddress(this.staz_sostituz.getAddress());
		stazione.setName(this.staz_sostituz.getName());
		stazione.setID(this.staz_sostituz.getID());
		
		for(Batteria b: this.getSubstitutionStation().getAvailableBatteries()){
			if (!this.getBattery().equals(b)){
				BatteriaDAO batt = new BatteriaDAO();
				batt.setID( b.getID() );
				batt.setCostSubstitution( b.getCostSubstitution() );
				batt.setCyclesRecharge( b.getCyclesRecharge() );
				ModelloAutovetturaDAO mod = new ModelloAutovetturaDAO();
				mod.setBrand( b.getModel().getBrand() );
				mod.setModel( b.getModel().getModel() );
				mod.setID();
				batt.setModel(mod);
				stazione.setAvailableBatteries(batt);
			}
		}
		
		
		dao.setStation(stazione);
		
		BatteriaDAO batteria = new BatteriaDAO();
		batteria.setCostSubstitution(this.batteria.getCostSubstitution());
		batteria.setCyclesRecharge(this.batteria.getCyclesRecharge());
		batteria.setID(this.batteria.getID());
		ModelloAutovetturaDAO mod = new ModelloAutovetturaDAO ();
		mod.setBrand(this.getBattery().getModel().getBrand());
		mod.setModel(this.getBattery().getModel().getModel());
		batteria.setModel(mod);
		dao.setBattery(batteria);
		dao.setDateHour(this.dataOra);
		
//		System.out.println("" +dao.getStation().getAvailableBatteries().size() + dao.getBattery().getModel().getID());
		
		//UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution("ED 190 ES");
	
		return dao.update();
	}

}
