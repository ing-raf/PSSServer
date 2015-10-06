package Server.Control;

import java.rmi.ConnectIOException;

import Server.BusinessLogic.BatteriaBL;
import Server.BusinessLogic.GestoreStazione;
import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;

public class CoordinatoreRecupero implements Runnable {
	
	private final int idStazione;
	private final BatteriaBL batteria;
	private final ServizidiSostituzione stub;

	/**
	 * 
	 * @param batteria
	 * @param idStazione
	 */
	public CoordinatoreRecupero(BatteriaBL batteria, int idStazione, ServizidiSostituzione stub) {
		this.idStazione = idStazione;
		this.batteria = batteria;
		this.stub = stub;
	}

	public void run() {
		
		GestoreStazione gs = new GestoreStazione(this.idStazione);
		
		try {

			if ( gs.verifyRecharge(batteria) ) {
				
				if (this.stub.rechargeBatteria( this.batteria.getID() ) == false )
					throw new ConnectIOException("Riscontrato un problema durante la ricarica della batteria");
				
				gs.addBattery(this.batteria);
					
			} else {
				
				gs.discardBattery(this.batteria);
				
				if (this.stub.discardBatteria( this.batteria.getID() ) == false)
					throw new ConnectIOException("Riscontrato un problema durante lo scarto della batteria");
				
			}
			
		} catch (Exception e) {
			System.err.println("Riscontrato un problema con il sistema di sostituzione");
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
}