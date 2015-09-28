package Server.Control;

import java.rmi.RemoteException;

import Server.BusinessLogic.ValidazioneBadge;
import Server.RMIInterface.Install_Outcome;

public class NonAutenticato extends Stato {

	public boolean verificaEsitoValidazione() {
		return false;
	}

	/**
	 * 
	 * @param codice
	 */
	public void startValidazione(CoordinatoreClienteRegistrato coordinatore, int codice) {
		ValidazioneBadge cercaBadge = new ValidazioneBadge();
		
		if ( cercaBadge.findCodiceBadge(codice) == true)
			coordinatore.setStato( new Autenticato (cercaBadge) );
			
	}
	
	public Install_Outcome startInstallazione(CoordinatoreClienteRegistrato coordinatore, int indiceBatteria) {
		return Install_Outcome.NO_VALIDATE;
	}

}