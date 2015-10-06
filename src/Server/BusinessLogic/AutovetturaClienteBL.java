package Server.BusinessLogic;

import Server.Entity.AutovetturaCompatibile;

public class AutovetturaClienteBL extends AutovetturaBL {

	private String numeroTarga;
	
	public AutovetturaClienteBL(){
		super();
	}
	
	public AutovetturaClienteBL(String fornitore, String modello, String numeroTarga) {
		super(modello, fornitore);
		this.setNumberPlate(numeroTarga);
	}
	
	public AutovetturaClienteBL(AutovetturaCompatibile autovettura) {
		super( autovettura.getModel() );
		this.setNumberPlate( autovettura.getNumberPlate() );
	}
	
	public String getNumberPlate() {
		return this.numeroTarga;
	}
	
	public void setNumberPlate(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}
	
	public boolean equals (Object obj){
		AutovetturaClienteBL a = (AutovetturaClienteBL) obj;  
		if ((a.getNumberPlate().equals(this.numeroTarga)) && 
				(a.getModel().equals(this.getModel())))
				
			return true;
		else
			return false;
	}

}