package Server.Entity;

import java.util.Calendar;
import java.util.List;

import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.PopulateTestDatabase;
import Server.DAO.StazioneDAO;

public class meindiprova {

	public static void main(String[] args) throws Exception {
		PopulateTestDatabase.populate();
		
		
		UltimaSostituzione change = new UltimaSostituzione("ED 190 ES");
		System.out.println(change.getSubstitutionStation());
		Batteria old = change.getBattery();
		change.setBattery( new Batteria(9) );
		change.setSubstitutionStation( new Stazione(2) );
		change.setDateHour(Calendar.getInstance());

		System.out.println( change.update("ED 190 ES"));
		Stazione troia  = new Stazione (change.getSubstitutionStation().getID());
		System.out.println(old.getID());
//		change.getSubstitutionStation().setAvailableBatteries(old);
//		change.getSubstitutionStation().getAvailableBatteries().size();
		troia.setAvailableBatteries(old);
		System.out.println("" +troia.getAvailableBatteries().get(2).getID());
		System.out.println("" +troia.getAvailableBatteries().get(0).getID());
//		Stazione troia  = new Stazione (3);
		System.out.println(troia.update());
		
		
		
	}

}
