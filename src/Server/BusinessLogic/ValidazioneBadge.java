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
		
		Societ� s = new Societ�();
		badgeValidato = new Badge();
	    
		return s.findBadge(badgeValidato, codice);
	}

}