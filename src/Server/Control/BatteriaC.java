package Server.Control;

public class BatteriaC implements Server.RMIInterface.Batteria {

	private static final long serialVersionUID = -2863854381073115870L;
	private int ID;
	private float costoSostituzione;

	public BatteriaC() {
		
	}
	
	public BatteriaC (int ID, float costoSostituzione) {
		this.setID(ID);
		this.setCostSubstitution(costoSostituzione);
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int id){
		this.ID = id;
	}
	
	public float getCostSubstitution(){
		return this.costoSostituzione;
	}
	
	public void setCostSubstitution(float costo){
		this.costoSostituzione = costo;
	}

}