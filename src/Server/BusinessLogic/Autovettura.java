package Server.BusinessLogic;

import Server.Entity.ModelloAutovettura;

public class Autovettura {

	private String modello;
	private String fornitore;
	
	public Autovettura() {
		
	}
	
	public Autovettura(String modello, String fornitore) {
		this.setBrand(fornitore);
		this.setModel(modello);
	}
	
	public Autovettura(ModelloAutovettura autovettura) {
		this.setBrand(autovettura.getBrand());
		this.setModel(autovettura.getModel());
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