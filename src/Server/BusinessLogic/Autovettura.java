package Server.BusinessLogic;

import Server.Entity.ModelloAutovettura;

public class Autovettura implements Server.RMIInterface.Autovettura {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8035145982586201550L;
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