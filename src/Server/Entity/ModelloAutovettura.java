package Server.Entity;

import Server.DAO.ModelloAutovetturaDAO;

public class ModelloAutovettura {

	private String fornitore;
	private String modello;
	
	public ModelloAutovettura(){
		
	}

	public ModelloAutovettura(ModelloAutovetturaDAO dao) {
		this.fornitore = dao.getBrand();
		this.modello = dao.getModel();
	}
	
	public String getBrand() {
		return this.fornitore;
	}
	
	public void setBrand(String fornitore) {
		this.fornitore = fornitore;
	}
	
	public String getModel() {
		return this.modello;
	}
	
	public void setModel(String modello) {
		this.modello = modello;
	}
	
	
}
