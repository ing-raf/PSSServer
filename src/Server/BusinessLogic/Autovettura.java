package Server.BusinessLogic;

import Server.Entity.ModelloAutovettura;

public class Autovettura {

	private ModelloAutovettura autovettura;
	
	public String getModello() {
		return this.autovettura.getModello();
	}

	public String getFornitore() {
		return this.autovettura.getFornitore();
	}

	/**
	 * 
	 * @param modelloAutovettura
	 */
	public void setAutovettura(ModelloAutovettura autovettura) {
		this.autovettura = autovettura;
	}

	
	public ModelloAutovettura getAutovettura(){
		return this.autovettura;
		
	}
	

}