package Server.BusinessLogic;

public class Batteria {

	private Server.Entity.Batteria batteria;
	
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
	public void setBatteria(Server.Entity.Batteria batteria) {
		this.batteria = batteria;
	}
	
	public Server.Entity.Batteria getBatteria(){
		return this.batteria;
	}

}