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
	
	public UltimaSostituzione() {
		
	}
	
	public static UltimaSostituzione getLastSubstitution (String targa) {
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		return new UltimaSostituzione(dao);
	}
	
	public UltimaSostituzione(UltimaSostituzioneDAO dao) {
		this.dataOra = dao.getDateHour();
		this.staz_sostituz = new Stazione ( dao.getStation() );
		this.batteria = new Batteria ( dao.getBattery() ); 
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
	
	public UltimaSostituzioneDAO prepareDAO() {
		UltimaSostituzioneDAO dao = new UltimaSostituzioneDAO();
		dao.setDateHour(this.dataOra);
		dao.setBattery( this.batteria.prepareDAO() );
		dao.setStation( this.staz_sostituz.prepareDAO() );
		dao.setID();
		return dao;
	}
	
	public boolean update() {
		this.staz_sostituz.removeBattery(this.batteria);
		UltimaSostituzioneDAO dao = this.prepareDAO();
		return dao.update();
	}
	
/*	public boolean update(String targa ) {
		UltimaSostituzioneDAO dao = new UltimaSostituzioneDAO();
//		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		
		dao.setID(this.sporcata);
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
		
		return dao.update();
	} */

}
