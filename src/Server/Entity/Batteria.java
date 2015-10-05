package Server.Entity;

import Server.DAO.BatteriaDAO;


public class Batteria {
	
	private int ID;
	private float costoSostituzione;
	private int cicliRicaricaRimanenti;
	private ModelloAutovettura modello;
	
	public Batteria(){
		
	}
	
	public Batteria(BatteriaDAO dao){
		this.ID = dao.getID();
		this.cicliRicaricaRimanenti = dao.getCyclesRecharge();
		this.costoSostituzione = dao.getCostSubstitution();
		this.modello = new ModelloAutovettura(dao.getModel());
	}
	
	public Batteria(int id, float costo, int cicli, ModelloAutovettura modello) {
		this.ID = id;
		this.costoSostituzione = costo;
		this.cicliRicaricaRimanenti = cicli;
		this.modello = modello;
		
		BatteriaDAO dao = this.prepareDAO();
		dao.save();
	/*	
		BatteriaDAO batteria = new BatteriaDAO();
		batteria.setID(id);
		batteria.setCostSubstitution(costo);
		batteria.setCyclesRecharge(cicli);
		
		ModelloAutovetturaDAO modelloDAO = new ModelloAutovetturaDAO();
		modelloDAO.setModel(modello.getModel());
		modelloDAO.setBrand(modello.getBrand());
		modelloDAO.setID();
		batteria.setModel(modelloDAO);
		
		if(!batteria.save())
			throw new Exception(); */
	}
	
	public int getID(){
		return this.ID;
	}
	
	public static Batteria getBattery(int id){
		BatteriaDAO dao = BatteriaDAO.findBattery(id);
		return new Batteria(dao);
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
	
	public BatteriaDAO prepareDAO(){
		BatteriaDAO dao = new BatteriaDAO();
		
		dao.setCostSubstitution(this.costoSostituzione);
		dao.setCyclesRecharge(this.cicliRicaricaRimanenti);
		dao.setID(this.ID);
		dao.setModel(this.modello.prepareDAO());
		
		return dao;
	}
	
	public boolean update(){
		BatteriaDAO dao = this.prepareDAO();
		return dao.update();
	}
	
	public boolean delete() {
		BatteriaDAO dao = this.prepareDAO();
		return dao.delete();
	}
	
	public boolean equals (Object obj){
		Batteria b = (Batteria) obj;  
		if ((b.getID() == this.getID()) &&
				(Float.compare(b.getCostSubstitution(), this.getCostSubstitution()) == 0) && 
				(b.getCyclesRecharge() == this.getCyclesRecharge())) 
			return true;
		else
			return false;
	
	}
}
