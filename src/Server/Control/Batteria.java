package Server.Control;

public class Batteria implements Server.RMIInterface.Batteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863854381073115870L;
	private int ID;
	private float costo;

	public int getID() {
		return this.ID;
	}
	
	public float getCosto() {
		return this.costo;
	}

	/**
	 * 
	 * @param batteria
	 */
	public void setBatteria(Server.BusinessLogic.Batteria batteria) {
		this.ID = batteria.getID();
		this.costo = batteria.getCosto();
	}

}