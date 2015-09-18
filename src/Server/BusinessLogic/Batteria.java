package Server.BusinessLogic;

public class Batteria implements Server.RMIInterface.Batteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6370376348997524139L;
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