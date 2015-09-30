package Server.BusinessLogic;

public class Batteria {

	private Server.DAO.Batteria batteria;
	
	public int getID() {
		return this.batteria.getID();
	}
	
	public float getCosto() {
		return this.batteria.getCostoSostituzione();
	}

	/**
	 * 
	 * @param batteria
	 */
	public void setBatteria(Server.DAO.Batteria batteria) {
		this.batteria = batteria;
	}
	
	public Server.DAO.Batteria getBatteria(){
		return this.batteria;
	}

}