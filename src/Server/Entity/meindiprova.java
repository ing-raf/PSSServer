package Server.Entity;

import java.util.Calendar;
import java.util.List;

import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;

public class meindiprova {

	public static void main(String[] args) throws Exception {
		PopulateTestDatabase.populate();
		
		UltimaSostituzione change = UltimaSostituzione.getLastSubstitution("ED 190 ES");
		Batteria old = change.getBattery();
		change.setBattery( Batteria.getBattery(9) );
		Stazione locale = Stazione.getStation(2);
		change.setSubstitutionStation( locale );
		change.setDateHour( Calendar.getInstance() );
		
		System.err.println( change.update() );
		locale.setAvailableBatteries(old);
		System.err.println( locale.update() );
		
		PopulateTestDatabase.populate();
		
		System.err.println("Ho ripopolato");
		
	}

}
