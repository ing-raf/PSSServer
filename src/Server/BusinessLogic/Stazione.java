package Server.BusinessLogic;

public class Stazione implements Server.RMIInterface.Stazione {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5577133457889115283L;
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