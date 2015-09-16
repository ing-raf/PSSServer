package Server.Control;

public class Batteria implements Server.RMIInterface.Batteria {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863854381073115870L;
	private float costo;

	public float getCosto() {
		return this.costo;
	}

	/**
	 * 
	 * @param batteria
	 */
	public void setBatteria(Server.BusinessLogic.Batteria batteria) {
		this.costo = batteria.getCosto();
	}

}