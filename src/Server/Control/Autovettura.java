package Server.Control;

import Server.BusinessLogic.*;

public class Autovettura implements Server.RMIInterface.Autovettura {

	private String modello;
	private String fornitore;

	public String getModello() {
		return this.modello;
	}

	public String getFornitore() {
		return this.fornitore;
	}

	/**
	 * 
	 * @param modello
	 */
	public void setModelloAutovettura(ModelloAutovettura modello) {
		// TODO - implement Autovettura.setModelloAutovettura
	}

}