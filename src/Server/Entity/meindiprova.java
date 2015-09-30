package Server.Entity;

import java.util.Calendar;
import java.util.List;

import Server.DAO.ModelloAutovetturaDAO;
import Server.DAO.PopulateTestDatabase;

public class meindiprova {

	public static void main(String[] args) throws Exception {
		PopulateTestDatabase.populate();
		
		Batteria batt = new Batteria(1);
		System.out.println( batt.getCostSubstitution() );
		System.out.println( batt.getModel().getBrand() );
		
//		Badge b = new Badge(-2);
//		System.out.println(b.getClient().getName());
		
		List<ModelloAutovetturaDAO> l = Societa.getListaModelli();
		
		System.out.println (l.get(0).getBrand());
		
		UltimaSostituzione change = new UltimaSostituzione("ED 190 ES");
		change.setBattery( new Batteria(9) );
		change.setSubstitutionStation( new Stazione(2) );
		change.setDateHour(Calendar.getInstance());
		System.out.println( change.update() );
	}

}
