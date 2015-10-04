package Server.OLD;

import Server.DAO.*;
import Server.Entity.Societa;

public class ValidazioneBadge {

	BadgeDAO badgeValidato;

	public ClienteDAO getCliente() {
		return this.badgeValidato.getCliente();	
	}

	/**
	 * 
	 * @param codice
	 */
	public boolean findCodiceBadge(int codice) {

	   this.badgeValidato = new BadgeDAO ();
	  return Societa.findBadge(this.badgeValidato, codice);
	}
	
	public boolean verifyCredito (float costo) {
		if (this.badgeValidato.getCredito() < costo) return false;
		else return true;
	}
	
	public void debitBatteria (float costo) {
		this.badgeValidato.setCredito(this.badgeValidato.getCredito() - costo);
	}

}