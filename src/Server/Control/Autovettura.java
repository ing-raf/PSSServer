package Server.Control;

import Server.BusinessLogic.*;

public class Autovettura implements Server.RMIInterface.Autovettura {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7944836306144200648L;
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
		this.modello = modello.getFornitore();
		this.fornitore = modello.getModello();
	}

}