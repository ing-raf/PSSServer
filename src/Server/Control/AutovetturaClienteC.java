package Server.Control;

public class AutovetturaClienteC extends AutovetturaC implements Server.RMIInterface.AutovetturaCliente {

	private static final long serialVersionUID = 6670811571001494844L;
	private String numeroTarga;
	
	public AutovetturaClienteC(){
		super();
	}
	
	public AutovetturaClienteC(String fornitore, String modello, String numeroTarga) {
		super(modello, fornitore);
		this.setNumberPlate(numeroTarga);
	}
	
	
	public String getNumberPlate() {
		return this.numeroTarga;
	}
	
	public void setNumberPlate(String numeroTarga) {
		this.numeroTarga = numeroTarga;
	}

}