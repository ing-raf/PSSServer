package Server.Entity;

import Server.DAO.AutovetturaCompatibileDAO;

public class AutovetturaCompatibile {

	private String numeroTarga;
	private ModelloAutovettura modello;
	private UltimaSostituzione sostituzione;
	
	public AutovetturaCompatibile() {
		
	}
	
	public AutovetturaCompatibile(AutovetturaCompatibileDAO dao) {
		
		this.numeroTarga = dao.getNumberPlate();
		this.modello = new ModelloAutovettura( dao.getModel() );
		this.sostituzione = new UltimaSostituzione (dao.getLastSubstitution() );
		
	}
	
	public static AutovetturaCompatibile getCar (String numeroTarga) {
		
		AutovetturaCompatibileDAO dao = AutovetturaCompatibileDAO.findCar(numeroTarga); 
		return new AutovetturaCompatibile(dao);

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
	
	public AutovetturaCompatibileDAO prepareDAO() {
		AutovetturaCompatibileDAO dao = new AutovetturaCompatibileDAO();
		
		dao.setNumberPlate(this.numeroTarga);
		dao.setModel( this.modello.prepareDAO() );
		dao.setLastRicambio( this.sostituzione.prepareDAO() );
		
		return dao;
	}
	

	public boolean equals (Object obj){
		AutovetturaCompatibile a = (AutovetturaCompatibile) obj;  
		if ((a.getNumberPlate().equals(this.numeroTarga)) && 
				(a.getModel().equals(this.modello)) &&
				(a.getLastSubstitution().equals(this.sostituzione)))
			return true;
		else
			return false;
	}
	
}
