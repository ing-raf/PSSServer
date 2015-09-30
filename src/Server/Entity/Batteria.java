package Server.Entity;

import Server.DAO.BatteriaDAO;
import Server.DAO.ModelloAutovetturaDAO;

public class Batteria {
	
	private int ID;
	private float costoSostituzione;
	private int cicliRicaricaRimanenti;
	private ModelloAutovettura modello;
	
	public Batteria(int id){
		BatteriaDAO batteria = new BatteriaDAO();
		batteria = BatteriaDAO.findBatteria(id);
		
		this.ID = batteria.getID();
		this.costoSostituzione = batteria.getCostSubstitution();
		this.cicliRicaricaRimanenti = batteria.getCyclesRecharge();
		this.modello.setModello(batteria.getModel().getModel());
		this.modello.setBrand(batteria.getModel().getBrand());
	}
	
	public Batteria(int id, float costo, int cicli, ModelloAutovettura modello){
		BatteriaDAO batteria = new BatteriaDAO();
		batteria.setID(id);
		batteria.setCostSubstitution(costo);
		batteria.setCyclesRecharge(cicli);
		ModelloAutovetturaDAO modelloDAO = new ModelloAutovetturaDAO();
		batteria.setModel(modelloDAO);
	}
	
	public int getID(){
		return this.ID;
	}
	
	public float getCostSubstitution(){
		return this.costoSostituzione;
	}
	
	public int getCyclesRecharge(){
		return this.cicliRicaricaRimanenti;
	}
	
	public ModelloAutovettura getModel(){
		return this.modello;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public void setCostSubstitution(float costo){
		this.costoSostituzione = costo;
	}
	
	public void setCyclesRecharge(int cicli){
		this.cicliRicaricaRimanenti = cicli;
	}
	
	public void setModel(ModelloAutovettura modello){
		this.modello = modello;
	}
}
