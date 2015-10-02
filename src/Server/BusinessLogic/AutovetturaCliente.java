package Server.BusinessLogic;

import Server.Entity.AutovetturaCompatibile;

public class AutovetturaCliente extends Autovettura {

	private String numeroTarga;
	
	public AutovetturaCliente(){
		super();
	}
	
	public AutovetturaCliente(String fornitore, String modello, String numeroTarga) {
		super(fornitore, modello);
		this.setNumberPlate(numeroTarga);
	}
	
	public AutovetturaCliente(AutovetturaCompatibile autovettura) {
		super( autovettura.getModel() );
		this.setNumberPlate( autovettura.getNumberPlate() );
	}
	
	public String getNumberPlate() {
		return this.numeroTarga;
	}
	
	public void setNumberPlate(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}

}