package Server.BusinessLogic;

public class Stazione {
	
	private Server.DAO.StazioneDAO stazione;

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
	public void setStazione(Server.DAO.StazioneDAO stazione) {
		this.stazione = stazione;
	}

}