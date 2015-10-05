package Server.Entity;

import Server.DAO.ModelloAutovetturaDAO;

public class ModelloAutovettura {

	private String fornitore;
	private String modello;
	
	public ModelloAutovettura(){
		
	}

	ModelloAutovettura(ModelloAutovetturaDAO dao) {
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
	
	public ModelloAutovetturaDAO prepareDAO() {
		ModelloAutovetturaDAO dao = new ModelloAutovetturaDAO();
		dao.setBrand(this.fornitore);
		dao.setModel(this.modello);
		dao.setID();
		return dao;
	}
	
	public boolean equals (Object obj){
		ModelloAutovettura b = (ModelloAutovettura) obj;  
		if ((b.getBrand().equals(this.fornitore)) && 
				(b.getModel().equals(this.modello)))
			return true;
		else
			return false;
	}
	
}
