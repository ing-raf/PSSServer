package Server.Control;

public class Sostituzione implements Server.RMIInterface.Sostituzione {

	private Calendar data;
	private Calendar ora;
	private string nomeStazione;
	private string indirizzoStazione;
	private int IDBatteria;

	public int getGiorno() {
		// TODO - implement Sostituzione.getGiorno
	}

	public int getMese() {
		// TODO - implement Sostituzione.getMese
	}

	public int getAnno() {
		// TODO - implement Sostituzione.getAnno
	}

	public int getOra() {
		// TODO - implement Sostituzione.getOra
	}

	public int getMinuti() {
		// TODO - implement Sostituzione.getMinuti
	}

	public string getNomeStazione() {
		return this.nomeStazione;
	}

	public string getIndirizzoStazione() {
		return this.indirizzoStazione;
	}

	public int getIDbatteria() {
		// TODO - implement Sostituzione.getIDbatteria
	}

	/**
	 * 
	 * @param sostituzione
	 */
	public void setSostituzione(Server.BusinessLogic.Sostituzione sostituzione) {
		// TODO - implement Sostituzione.setSostituzione
	}

}