package Server.Control;

import java.util.Calendar;

public class UltimaSostituzione implements Server.RMIInterface.Sostituzione {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8677490410508960918L;
	int giorno;
	int mese;
	int anno;
	int ora;
	int minuti;
//	private Calendar dataOra;
	private String nomeStazione;
	private String indirizzoStazione;
	private int IDBatteria;
/*	
	public UltimaSostituzione(){
		this.dataOra = Calendar.getInstance();
		this.nomeStazione = "prova prova";
		this.indirizzoStazione = "si si";
		this.IDBatteria = 0;
	}
*/
	public int getGiorno() {
		return this.giorno;
	}

	public int getMese() {
		return this.mese;
	}

	public int getAnno() {
		return this.anno;
	}

	public int getOra() {
		return this.ora;
	}

	public int getMinuti() {
		return this.minuti;
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

	public void setSostituzione(Server.BusinessLogic.UltimaSostituzione sostituzione) {
		this.giorno = sostituzione.getDataOra().get(Calendar.DATE);
		this.mese = sostituzione.getDataOra().get(Calendar.MONTH);
		this.anno = sostituzione.getDataOra().get(Calendar.YEAR);
		this.ora = sostituzione.getDataOra().get(Calendar.HOUR_OF_DAY);
		this.minuti = sostituzione.getDataOra().get(Calendar.MINUTE);
		this.nomeStazione = sostituzione.getNomeStazione();
		this.indirizzoStazione = sostituzione.getIndirizzoStazione();
		this.IDBatteria = sostituzione.getIDBatteria();
	}

}