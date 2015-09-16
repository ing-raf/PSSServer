package Server.Control;

import Server.BusinessLogic.*;

public class AutovetturaCliente extends Autovettura implements Server.RMIInterface.AutovetturaCliente {

	private string numeroTarga;

	public string getNumeroTarga() {
		return this.numeroTarga;
	}

	/**
	 * 
	 * @param autovetturaCliente
	 */
	public void setAutovetturaCliente(AutovetturaCompatibile autovetturaCliente) {
		// TODO - implement AutovetturaCliente.setAutovetturaCliente
	}

}