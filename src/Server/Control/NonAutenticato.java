package Server.Control;

import Server.BusinessLogic.ValidazioneBadge;

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

}