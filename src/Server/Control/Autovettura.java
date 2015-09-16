package Server.Control;

import Server.BusinessLogic.*;

public class Autovettura implements Server.RMIInterface.Autovettura {

	private string modello;
	private string fornitore;

	public string getModello() {
		return this.modello;
	}

	public string getFornitore() {
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