package Server.Control;

public class Stazione implements Server.RMIInterface.Stazione {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8069057008038377286L;
	private String nome;
	private String indirizzo;

	public String getNome() {
		return this.nome;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	/**
	 * 
	 * @param stazione
	 */
	public void setStazione(Server.BusinessLogic.Stazione stazione) {
		this.nome = stazione.getNome();
		this.indirizzo = stazione.getIndirizzo();
	}

}