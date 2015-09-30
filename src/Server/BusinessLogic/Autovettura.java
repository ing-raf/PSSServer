package Server.BusinessLogic;

import Server.DAO.ModelloAutovetturaDAO;

public class Autovettura {

	private ModelloAutovetturaDAO autovettura;
	
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
	public void setAutovettura(ModelloAutovetturaDAO autovettura) {
		this.autovettura = autovettura;
	}

	
	public ModelloAutovetturaDAO getAutovettura(){
		return this.autovettura;
		
	}
	

}