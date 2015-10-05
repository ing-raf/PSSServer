package Server.Control;

public class AutovetturaC implements Server.RMIInterface.Autovettura {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7944836306144200648L;
	private String modello;
	private String fornitore;

	public AutovetturaC() {
		
	}
	
	public AutovetturaC(String modello, String fornitore) {
		this.setBrand(fornitore);
		this.setModel(modello);
	}
	
	public String getModel() {
		return this.modello;
	}

	public String getBrand() {
		return this.fornitore;
	}

	public void setModel(String modello) {
		this.modello = modello;
	}
	
	public void setBrand(String fornitore) {
		this.fornitore = fornitore;
	}

}