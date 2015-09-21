package Server.BusinessLogic;

import Server.Entity.*;

public class ValidazioneBadge {

	Badge badgeValidato;

	public Cliente getCliente() {
		return badgeValidato.getCliente();	
	}

	/**
	 * 
	 * @param codice
	 */
	public boolean findCodiceBadge(int codice) {
		
		badgeValidato = new Badge();
	    
		return Società.findBadge(badgeValidato, codice);
	}

}