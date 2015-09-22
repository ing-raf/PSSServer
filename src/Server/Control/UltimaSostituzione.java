package Server.Control;

import java.util.Calendar;

public class UltimaSostituzione implements Server.RMIInterface.Sostituzione {

	private Calendar dataOra;
	private String nomeStazione;
	private String indirizzoStazione;
	private int IDBatteria;

	public int getGiorno() {
		return this.dataOra.get(Calendar.DATE);
	}

	public int getMese() {
		return this.dataOra.get(Calendar.MONTH);
	}

	public int getAnno() {
		return this.dataOra.get(Calendar.YEAR);
	}

	public int getOra() {
		return this.dataOra.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinuti() {
		return this.dataOra.get(Calendar.MINUTE);
	}

	public String getNomeStazione() {
		return this.nomeStazione;
	}

	public String getIndirizzoStazione() {
		return this.indirizzoStazione;
	}

	public int getIDBatteria() {
		return this.IDBatteria;
	}

	/**
	 * 
	 * @param sostituzione
	 */
	public void setSostituzione(Server.BusinessLogic.UltimaSostituzione sostituzione) {
		this.dataOra = sostituzione.getDataOra();
		this.nomeStazione = sostituzione.getNomeStazione();
		this.indirizzoStazione = sostituzione.getIndirizzoStazione();
		this.IDBatteria = sostituzione.getIDBatteria();
	}

}