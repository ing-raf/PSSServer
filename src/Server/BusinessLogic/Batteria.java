package Server.BusinessLogic;

public class Batteria {

	private Server.DAO.BatteriaDAO batteria;
	
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
	public void setBatteria(Server.DAO.BatteriaDAO batteria) {
		this.batteria = batteria;
	}
	
	public Server.DAO.BatteriaDAO getBatteria(){
		return this.batteria;
	}

}