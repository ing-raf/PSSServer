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
	
	public boolean update(String targa, Batteria vecchia ) {
		
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		vecchia.setID(dao.getBattery().getID());
		vecchia.setCostSubstitution(dao.getBattery().getCostSubstitution());
		vecchia.setCyclesRecharge(dao.getBattery().getCyclesRecharge());
		ModelloAutovettura mode = new ModelloAutovettura ();
		mode.setBrand(dao.getBattery().getModel().getBrand());
		mode.setModel(dao.getBattery().getModel().getModel());
		vecchia.setModel(mode);
		
		StazioneDAO stazione = new StazioneDAO();
		stazione.setAddress(this.staz_sostituz.getAddress());
		stazione.setName(this.staz_sostituz.getName());
		stazione.setID(this.staz_sostituz.getID());
		
		for(int i=0; i<stazione.getAvailableBatteries().size(); i++){
			BatteriaDAO batt = new BatteriaDAO();
			batt.setID( stazione.getAvailableBatteries().get(i).getID() );
			batt.setCostSubstitution( stazione.getAvailableBatteries().get(i).getCostSubstitution() );
			batt.setCyclesRecharge( stazione.getAvailableBatteries().get(i).getCyclesRecharge() );
				ModelloAutovetturaDAO mod = new ModelloAutovetturaDAO();
				mod.setBrand( stazione.getAvailableBatteries().get(i).getModel().getBrand() );
				mod.setModel( stazione.getAvailableBatteries().get(i).getModel().getModel() );
			batt.setModel(mod);
			stazione.setAvailableBatteries(batt);
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
		
		if (!dao.getStation().update())
			return false;
		
		//UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution("ED 190 ES");
		
		return dao.update();
	}

}
