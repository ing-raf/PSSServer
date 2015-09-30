package Server.Entity;

import java.util.Calendar;

import Server.DAO.StazioneDAO;
import Server.DAO.UltimaSostituzioneDAO;

public class UltimaSostituzione {
	
	private Calendar dataOra;
	private Stazione staz_sostituz;
	private Batteria batteria;
	private UltimaSostituzione autovettura;
	
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

	public UltimaSostituzione getCar() {
		return autovettura;
	}

	public void setCar(UltimaSostituzione autovettura) {
		this.autovettura = autovettura;
	}
	
	public boolean update() {
		UltimaSostituzioneDAO dao = new UltimaSostituzioneDAO();
		
		StazioneDAO stazione = new StazioneDAO();
		stazione.setAddress(this.staz_sostituz.getAddress());
		stazione.setName(this.staz_sostituz.getName());
		stazione.setID(this.staz_sostituz.getID());
		stazione.setAvailableBatteries(this.staz_sostituz.getBatteries());
		dao.setStation(stazione);
		
		Batteria batteria = new Batteria();
		batteria.setCostSubstitution(this.batteria.getCostSubstitution());
		batteria.setCyclesRecharge(this.batteria.getCyclesRecharge());
		batteria.setID(this.batteria.getID());
		batteria.setModel(this.batteria.getModel());
		dao.setBattery(dao.getBattery());
		
		dao.setDateHour(this.dataOra);
		
		if(!dao.update()){
			return false;
		}else
			return true;
	}

}
