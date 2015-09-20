package Server.BusinessLogic;

import Server.Entity.AutovetturaCompatibile;

public class AutovetturaCliente extends Autovettura implements Server.RMIInterface.AutovetturaCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6726985347038990778L;
	private AutovetturaCompatibile autovettura;
	
	public String getNumeroTarga() {
		return autovettura.getNumeroTarga();
	}
	
	public String getModello() {
		return this.autovettura.getModello().getModello();
	}

	public String getFornitore() {
		return this.autovettura.getModello().getFornitore();
	}

	/**
	 * 
	 * @param autovettura
	 */
	public void setAutovettura(AutovetturaCompatibile autovettura) {
		this.autovettura = autovettura;
	}
	
	public AutovetturaCompatibile getAutovetturaCliente(){
		return this.autovettura;
	}
	
	public Autovettura getModelloAutovettura(){
		Autovettura a = new Autovettura();
		a.setAutovettura(this.autovettura.getModello());
		return a;
	}

}