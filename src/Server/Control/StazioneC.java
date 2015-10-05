package Server.Control;

public class StazioneC implements Server.RMIInterface.Stazione {
	
	private static final long serialVersionUID = -8069057008038377286L;
	private String nome;
	private String indirizzo;

	public StazioneC() {
		
	}
	
	public StazioneC(String nome, String indirizzo) {
		this.setName(nome);
		this.setAddress(indirizzo);
	}

	public String getName() {
		return this.nome;
	}
	
	public void setName(String nome) {
		this.nome = nome;
	}

	public String getAddress() {
		return this.indirizzo;
	}

	public void setAddress(String indirizzo) {
		this.indirizzo = indirizzo;
	} 

}