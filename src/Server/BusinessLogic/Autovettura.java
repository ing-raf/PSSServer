package Server.BusinessLogic;

public class Autovettura implements Server.RMIInterface.Autovettura {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8035145982586201550L;
	private Autovettura autovettura;
	
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
	public void setAutovettura(Autovettura autovettura) {
		this.autovettura = autovettura;
	}

}