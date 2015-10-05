package Server.BusinessLogic;

import java.util.Calendar;

import Server.Entity.UltimaSostituzione;

public class UltimaSostituzioneBL {
	
	private Calendar dataOra;
	private String nomeStazione;
	private String indirizzoStazione;
	private int IDBatteria;

	public UltimaSostituzioneBL() {
		
	}
	
	public UltimaSostituzioneBL(Calendar dataOra, String nomeStazione, String indirizzoStazione, int IDBatteria) {
		this.setDateHour(dataOra);
		this.setStationName(nomeStazione);
		this.setStationAddress(indirizzoStazione);
		this.setBatteryID(IDBatteria);
	}
	
	public Calendar getDateHour() {
		return this.dataOra;
	}
	
	public void setDateHour(Calendar dataOra) {
		this.dataOra = dataOra;
	}

	public String getStationName() {
		return this.nomeStazione;
	}
	
	public void setStationName(String nomeStazione) {
		this.nomeStazione = nomeStazione;
	}

	public String getStationAddress() {
		return this.indirizzoStazione;
	}
	
	public void setStationAddress(String indirizzoStazione) {
		this.indirizzoStazione = indirizzoStazione;
	}

	public int getBatteryID() {
		return this.IDBatteria;
	}
	
	public void setBatteryID(int IDBatteria) {
		this.IDBatteria = IDBatteria;
	}
	
	public boolean equals (Object obj) {
		UltimaSostituzioneBL sost = (UltimaSostituzioneBL) obj;
		if ((this.IDBatteria == sost.getBatteryID()) && 
				(this.indirizzoStazione.equals(sost.getStationAddress())) && 
				(this.dataOra.equals(sost.getDateHour())) &&
				(this.nomeStazione.equals(sost.getStationName())))
			return true;
		else
			return false;
	}

}