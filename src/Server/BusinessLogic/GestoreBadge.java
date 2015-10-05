package Server.BusinessLogic;

import java.util.ArrayList;

import Server.Entity.AutovetturaCompatibile;
import Server.Entity.Badge;
import Server.Entity.Cliente;
import Server.Entity.Societa;
import Server.Entity.UltimaSostituzione;

public class GestoreBadge {
	
	private int codice;
	
	public GestoreBadge (int codice) {
		
		Societa laSocieta = Societa.getSociety();
		if ( !laSocieta.findBadge(codice) )
			throw new NullPointerException("Badge non presente");
		
		this.codice = codice;
		
	}
	
	public boolean verifyCredit(float costo) {
		
		Societa laSocieta = Societa.getSociety();
		Badge badge = laSocieta.getBadge(this.codice);
		
		return (badge.getCredit() >= costo);
		
	}
	
	public void debit(float costo) {
		
		Societa laSocieta = Societa.getSociety();
		Badge badge = laSocieta.getBadge(this.codice);
		
		badge.setCredit( badge.getCredit() - costo);
		badge.update();
		
	}
	
	public ArrayList<AutovetturaClienteBL> retrieveCarList() {
		
		Societa laSocieta = Societa.getSociety();
		Badge badge = laSocieta.getBadge(this.codice);
		Cliente cliente = badge.getClient();
		
		ArrayList<AutovetturaClienteBL> elencoAutovetture = new ArrayList<AutovetturaClienteBL>();
		
		for (AutovetturaCompatibile ac : cliente.getOwnedCars())
			elencoAutovetture.add( new AutovetturaClienteBL ( ac.getModel().getBrand(), ac.getModel().getModel(), ac.getNumberPlate()) );
		
		return elencoAutovetture;
			
	}
	
	public UltimaSostituzioneBL findLastSubstitution(String targa) {
			UltimaSostituzione last = UltimaSostituzione.getLastSubstitution(targa);
			
			return new UltimaSostituzioneBL(last.getDateHour(), 
					last.getSubstitutionStation().getName(), 
					last.getSubstitutionStation().getAddress(),
					last.getBattery().getID() );
	}

}
