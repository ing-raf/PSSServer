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
		return this.sostituzione.getDataOra().get(Calendar.DATE);
	}

	public int getMese() {
		return this.sostituzione.getDataOra().get(Calendar.MONTH);
	}

	public int getAnno() {
		return this.sostituzione.getDataOra().get(Calendar.YEAR);
	}

	public int getOra() {
		return this.sostituzione.getDataOra().get(Calendar.HOUR_OF_DAY);
	}

	public int getMinuti() {
		return this.sostituzione.getDataOra().get(Calendar.MINUTE);
	}

	public void setSostituzione(Server.Entity.Sostituzione sos) {
		this.sostituzione = sos;
	}


	public String getNomeStazione() {
		return this.sostituzione.getStazione().getNome();
	}

	public String getIndirizzoStazione() {
		return this.sostituzione.getStazione().getIndirizzo();
	}

	public int getIDBatteria() {
		return this.sostituzione.getBatteria().getID();
	}

	public Calendar getDataOra() {
		return this.sostituzione.getDataOra();
	}

}