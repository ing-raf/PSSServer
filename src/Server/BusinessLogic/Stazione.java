package Server.BusinessLogic;

public class Stazione {
	
	private Server.Entity.Stazione stazione;

	public String getNome() {
		return this.stazione.getNome();
	}

	public String getIndirizzo() {
		return this.stazione.getIndirizzo();
	}

	/**
	 * 
	 * @param stazione
	 */
	public void setStazione(Server.Entity.Stazione stazione) {
		this.stazione = stazione;
	}

}