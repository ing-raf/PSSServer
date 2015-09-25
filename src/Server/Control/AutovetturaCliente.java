package Server.Control;

public class AutovetturaCliente extends Autovettura implements Server.RMIInterface.AutovetturaCliente {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6670811571001494844L;
	private String numeroTarga;

	public String getNumeroTarga() {
		return this.numeroTarga;
	}

	/**
	 * 
	 * @param autovetturaCliente
	 */
	public void setAutovetturaCliente(Server.BusinessLogic.AutovetturaCliente autovetturaCliente) {
		this.setModelloAutovettura(autovetturaCliente);
		this.numeroTarga = autovetturaCliente.getNumeroTarga();
	}

}