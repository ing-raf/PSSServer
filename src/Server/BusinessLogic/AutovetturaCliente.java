package Server.BusinessLogic;

import Server.DAO.AutovetturaCompatibileDAO;

public class AutovetturaCliente extends Autovettura {

	private AutovetturaCompatibileDAO autovettura;
	
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
	public void setAutovettura(AutovetturaCompatibileDAO autovettura) {
		this.autovettura = autovettura;
	}
	
	public AutovetturaCompatibileDAO getAutovetturaCliente(){
		return this.autovettura;
	}
	
	public Autovettura getModelloAutovettura(){
		Autovettura a = new Autovettura();
		a.setAutovettura(this.autovettura.getModello());
		return a;
	}

}