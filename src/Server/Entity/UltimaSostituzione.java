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
		return dao;
	}
	
	public boolean update() {
		this.staz_sostituz.removeBattery(this.batteria);
		UltimaSostituzioneDAO dao = this.prepareDAO();
		return dao.update();
	}
	
	public boolean delete() {
		UltimaSostituzioneDAO dao = this.prepareDAO();
		return dao.delete();
	}
	
	public boolean equals (Object obj) {
		UltimaSostituzione sost = (UltimaSostituzione) obj;
		if ((this.batteria.equals(sost.getBattery())) && 
				(this.getSubstitutionStation().equals(sost.getSubstitutionStation())) && 
				(this.dataOra.equals(sost.getDateHour())))
			return true;
		else
			return false;
	}
	
	
}
