package Server.Control;

public class UltimaSostituzioneC implements Server.RMIInterface.UltimaSostituzione {

	private static final long serialVersionUID = 8677490410508960918L;
	private int giorno;
	private int mese;
	private int anno;
	private int ora;
	private int minuti;
	private String nomeStazione;
	private String indirizzoStazione;
	private int IDBatteria;
	
	public UltimaSostituzioneC(){
		
	}
	
	public UltimaSostituzioneC(int giorno, int mese, int anno, int ora, int minuti, String nomeStazione, String indirizzoStazione, int IDBatteria) {
		this.setDay(giorno);
		this.setMonth(mese);
		this.setYear(anno);
		this.setHour(ora);
		this.setMinutes(minuti);
		this.setStationName(nomeStazione);
		this.setStationAddress(indirizzoStazione);
		this.setBatteryID(IDBatteria);
	}

	public int getDay() {
		return this.giorno;
	}
	
	public void setDay(int giorno) {
		this.giorno = giorno;
	}

	public int getMonth() {
		return this.mese;
	}
	
	public void setMonth(int mese) {
		this.mese = mese;
	}

	public int getYear() {
		return this.anno;
	}
	
	public void setYear(int anno) {
		this.anno = anno;
	}

	public int getHour() {
		return this.ora;
	}
	
	public void setHour(int ora) {
		this.ora = ora;
	}

	public int getMinutes() {
		return this.minuti;
	}
	
	public void setMinutes(int minuti) {
		this.minuti = minuti;
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
}