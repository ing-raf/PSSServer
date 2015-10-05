package Server.BusinessLogic;

import java.util.ArrayList;

import Server.Entity.ModelloAutovettura;
import Server.Entity.Societa;
import Server.Entity.Stazione;

public class GestoreSocieta {
	
	public GestoreSocieta() {
		
	}
	
	public ArrayList<AutovetturaBL> retrieveModelList() {
		Societa laSocieta = Societa.getSociety();
		ArrayList<AutovetturaBL> elencoModelli = new ArrayList<AutovetturaBL>();
		
		for (ModelloAutovettura m : laSocieta.getModelList()) {
			AutovetturaBL trovata = new AutovetturaBL(m.getModel(), m.getBrand());
			elencoModelli.add(trovata);
		}
		
		return elencoModelli;
	}
	
	public ArrayList<StazioneBL> retrieveStationList() {
		Societa laSocieta = Societa.getSociety();
		ArrayList<StazioneBL> elencoStazioni = new ArrayList<StazioneBL>();
		
		for (Stazione s : laSocieta.getStationList() ) {
			StazioneBL trovata = new StazioneBL( s.getID(), s.getName(), s.getAddress() );
			elencoStazioni.add(trovata);
		}
		
		return elencoStazioni;
	}

}
