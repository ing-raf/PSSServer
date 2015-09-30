package Server.Entity;

import Server.DAO.AutovetturaCompatibileDAO;

public class AutovetturaCompatibile {

	private String numeroTarga;
	private ModelloAutovettura modello;
	private UltimaSostituzione sostituzione;
	
	public AutovetturaCompatibile(String numeroTarga) {
		
		AutovetturaCompatibileDAO dao = AutovetturaCompatibileDAO.findCar(numeroTarga);
		this.numeroTarga = dao.getNumberPlate();
		this.modello = new ModelloAutovettura();
			this.modello.setModel( dao.getModel().getModel() );
			this.modello.setBrand( dao.getModel().getBrand() );
		this.sostituzione = new UltimaSostituzione();
			this.sostituzione.setDateHour ( dao.getLastSubstitution().getDateHour() );
			this.sostituzione.
		
	}
	
	public String getNumberPlate() {
		return numeroTarga;
	}
	
	public void setNumberPlate(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}
	
	public ModelloAutovettura getModel() {
		return modello;
	}
	
	public void setModel(ModelloAutovettura modello) {
		this.modello = modello;
	}
	
	public UltimaSostituzione getLastSubstitution() {
		return sostituzione;
	}
	
	public void setLastSubstitution(UltimaSostituzione sostituzione) {
		this.sostituzione = sostituzione;
	}
}
