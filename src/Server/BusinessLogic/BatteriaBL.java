package Server.BusinessLogic;

import Server.Entity.ModelloAutovettura;

public class BatteriaBL {

	private int ID;
	private float costoSostituzione;
	private int cicliRicaricaRimanenti;
	private String modello;
	private String fornitore;
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public float getCostSubstitution(){
		return this.costoSostituzione;
	}
	
	public void setCostSubstitution(float costo){
		this.costoSostituzione = costo;
	}
	
	public int getCyclesRecharge(){
		return this.cicliRicaricaRimanenti;
	}
	
	public void setCyclesRecharge(int cicli){
		this.cicliRicaricaRimanenti = cicli;
	}
	
	public String getModel(){
		return this.modello;
	}
	
	public void setModel(String modello){
		this.modello = modello;
	}

	public String getBrand(){
		return this.fornitore;
	}
	
	public void setBrand(String fornitore){
		this.fornitore = fornitore;
	}

}