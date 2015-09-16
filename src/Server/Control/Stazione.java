package Server.Control;

public class Stazione implements Server.RMIInterface.Stazione {

	private string nome;
	private string indirizzo;

	public string getNome() {
		return this.nome;
	}

	public string getIndirizzo() {
		return this.indirizzo;
	}

	/**
	 * 
	 * @param stazione
	 */
	public void setIndirizzo(Server.BusinessLogic.Stazione stazione) {
		// TODO - implement Stazione.setIndirizzo
	}

}