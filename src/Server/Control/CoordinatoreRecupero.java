package Server.Control;

import java.rmi.ConnectIOException;

import Server.BusinessLogic.GestoreBatterie;
import Server.BusinessLogic.GestoreDisponibilità;
import SistemaSostituzione.RMIDeviceInterface.ServizidiSostituzione;

public class CoordinatoreRecupero implements Runnable {
	
	private final int idStazione;
	private final Server.BusinessLogic.Batteria batteria;
	private final ServizidiSostituzione stub;

	/**
	 * 
	 * @param batteria
	 * @param idStazione
	 */
	public CoordinatoreRecupero(Server.BusinessLogic.Batteria batteria, int idStazione, ServizidiSostituzione stub) {
		this.idStazione = idStazione;
		this.batteria = batteria;
		this.stub = stub;
	}

	public void run() {
		
		try {

			if ( GestoreBatterie.verifyRicarica(batteria) ) {
				
				if (this.stub.rechargeBatteria( this.batteria.getID() ) == false )
					throw new ConnectIOException("Riscontrato un problema durante la ricarica della batteria");
				
				GestoreDisponibilità.addBatteriaDisponibili(this.batteria, this.idStazione);
					
			} else {
				
				GestoreDisponibilità.removeBatteria(this.batteria, this.idStazione);
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