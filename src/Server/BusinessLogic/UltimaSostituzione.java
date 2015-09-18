package Server.BusinessLogic;

import java.util.Calendar;

import Server.Entity.Sostituzione;

public class UltimaSostituzione implements Server.RMIInterface.Sostituzione {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2017480700229004661L;
	private Sostituzione sostituzione;

	public int getGiorno() {
		return this.sostituzione.getData().get(Calendar.DATE);
	}

	public int getMese() {
		return this.sostituzione.getData().get(Calendar.MONTH);
	}

	public int getAnno() {
		return this.sostituzione.getData().get(Calendar.YEAR);
	}

	public int getOra() {
		return this.sostituzione.getOra().get(Calendar.HOUR_OF_DAY);
	}

	public int getMinuti() {
		return this.sostituzione.getOra().get(Calendar.MINUTE);
	}

	public Calendar setSostituzione() {
		// TODO - implement Sostituzione.setSostituzione
	}

	public string getNomeStazione() {
		// TODO - implement Sostituzione.getNomeStazione
	}

	public string getIndirizzoStazione() {
		// TODO - implement Sostituzione.getIndirizzoStazione
	}

	public String getNomeStazione() {
		return this.sostituzione.getBatteria().nomeStazione;
	}

	public String getIndirizzoStazione() {
		return this.sostituzione.getBatteria().indirizzoStazione;
	}

	public int getIDbatteria() {
		return this.sostituzione.getBatteria().IDBatteria;
	}

}