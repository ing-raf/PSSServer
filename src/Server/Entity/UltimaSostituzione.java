package Server.Entity;

import java.util.Calendar;

import Server.DAO.UltimaSostituzioneDAO;

public class UltimaSostituzione {
	
	private Calendar dataOra;
	private Stazione staz_sostituz;
	private Batteria batteria;
	private UltimaSostituzione autovettura;
	
	public UltimaSostituzione(String targa) {
		UltimaSostituzioneDAO dao = UltimaSostituzioneDAO.findSubstitution(targa);
		this.dataOra
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
	
	

}
