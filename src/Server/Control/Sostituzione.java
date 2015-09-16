package Server.Control;

import java.util.Calendar;

public class Sostituzione implements Server.RMIInterface.Sostituzione {

	private Calendar data;
	private Calendar ora;
	private String nomeStazione;
	private String indirizzoStazione;
	private int IDBatteria;

	public int getGiorno() {
		return this.data.get(Calendar.DATE);
	}

	public int getMese() {
		return this.data.get(Calendar.MONTH);
	}

	public int getAnno() {
		return this.data.get(Calendar.YEAR);
	}

	public int getOra() {
		return this.ora.get(Calendar.HOUR_OF_DAY);
	}

	public int getMinuti() {
		return this.ora.get(Calendar.MINUTE);
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
	public void setSostituzione(Server.BusinessLogic.Sostituzione sostituzione) {
		this.data = sostituzione.getData();
		this.ora = sostituzione.getOra();
		this.nomeStazione = sostituzione.getNomeStazione();
		this.indirizzoStazione = sostituzione.getIndirizzoStazione();
		this.IDBatteria = sostituzione.getIDBatteria();
	}

}