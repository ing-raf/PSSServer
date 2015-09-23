package Server.BusinessLogic;

import Server.Entity.*;

public class ValidazioneBadge {

	Badge badgeValidato;

	public Cliente getCliente() {
		return this.badgeValidato.getCliente();	
	}

	/**
	 * 
	 * @param codice
	 */
	public boolean findCodiceBadge(int codice) {

	   this.badgeValidato = new Badge ();
	  return Società.findBadge(this.badgeValidato, codice);
	}

}