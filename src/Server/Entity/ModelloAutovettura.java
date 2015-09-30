package Server.Entity;

public class ModelloAutovettura {

	private int ID;
	private String fornitore;
	private String modello;
	
	public ModelloAutovettura(){
		
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int iD) {
		this.ID = iD;
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
