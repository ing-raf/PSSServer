package Server.DAO;

import java.util.Calendar;
import java.util.List;

public class PopulateTestDatabase {
	
	public static void populate() throws Exception {		
		StazioneDAO[] st = new StazioneDAO[3];
		
		st[0] = new StazioneDAO();
		st[0].setID(1);
		st[0].setName("Stazione Centrale");
		st[0].setAddress("Piazzale Tecchio");
	
		st[1] = new StazioneDAO();
		st[1].setID(2);
		st[1].setName("Stazione Agnoli");
		st[1].setAddress("Via Nuova Agnano");
		
		st[2] = new StazioneDAO();
		st[2].setID(3);
		st[2].setName("Stazione Stadio");
		st[2].setAddress("Via Claudio");
		
		for (StazioneDAO s : st) s.save();
		
		ModelloAutovetturaDAO[] ma = new ModelloAutovetturaDAO[7];
		
		ma[0] = new ModelloAutovetturaDAO();
		ma[0].setID(1);
		ma[0].setBrand("Maserati");
		ma[0].setModel("Quattroporte");
	
		ma[1] = new ModelloAutovetturaDAO();
		ma[1].setID(2);
		ma[1].setBrand("Lamborghini");
		ma[1].setModel("Gallardo");
		
		ma[2] = new ModelloAutovetturaDAO();
		ma[2].setID(3);
		ma[2].setBrand("Mercedes");
		ma[2].setModel("SLK");
		
		ma[3] = new ModelloAutovetturaDAO();
		ma[3].setID(12);
		ma[3].setBrand("Alfa Romeo");
		ma[3].setModel("Giulietta");
		
		ma[4] = new ModelloAutovetturaDAO();
		ma[4].setID(13);
		ma[4].setBrand("Alfa Romeo");
		ma[4].setModel("Mito");
		
		ma[5] = new ModelloAutovetturaDAO();
		ma[5].setID(21);
		ma[5].setBrand("Peugeot");
		ma[5].setModel("207");
		
		ma[6] = new ModelloAutovetturaDAO();
		ma[6].setID(43);
		ma[6].setBrand("Fiat");
		ma[6].setModel("Panda");
		
		for (ModelloAutovetturaDAO m : ma) m.save();
		
		BatteriaDAO[] batt = new BatteriaDAO[15];
		
		batt[0] = new BatteriaDAO();
		batt[0].setID(1);
		batt[0].setCostSubstitution(610.21f);
		batt[0].setCyclesRecharge(121);
		batt[0].setModel(ma[1]);
	
		batt[1] = new BatteriaDAO();
		batt[1].setID(2);
		batt[1].setCostSubstitution(550.50f);
		batt[1].setCyclesRecharge(4);
		batt[1].setModel(ma[0]);
		
		batt[2] = new BatteriaDAO();
		batt[2].setID(3);
		batt[2].setCostSubstitution(490.25f);
		batt[2].setCyclesRecharge(79);
		batt[2].setModel(ma[0]);
		
		batt[3] = new BatteriaDAO();
		batt[3].setID(9);
		batt[3].setCostSubstitution(250.25f);
		batt[3].setCyclesRecharge(3);
		batt[3].setModel(ma[2]);
		
		batt[4] = new BatteriaDAO();
		batt[4].setID(10);
		batt[4].setCostSubstitution(20.25f);
		batt[4].setCyclesRecharge(2);
		batt[4].setModel(ma[5]);
		
		batt[5] = new BatteriaDAO();
		batt[5].setID(12);
		batt[5].setCostSubstitution(21.50f);
		batt[5].setCyclesRecharge(20);
		batt[5].setModel(ma[5]);
		
		batt[6] = new BatteriaDAO();
		batt[6].setID(21);
		batt[6].setCostSubstitution(11.50f);
		batt[6].setCyclesRecharge(24);
		batt[6].setModel(ma[6]);
		
		batt[7] = new BatteriaDAO();
		batt[7].setID(22);
		batt[7].setCostSubstitution(9.90f);
		batt[7].setCyclesRecharge(19);
		batt[7].setModel(ma[6]);
		
		batt[8] = new BatteriaDAO();
		batt[8].setID(31);
		batt[8].setCostSubstitution(40.55f);
		batt[8].setCyclesRecharge(6);
		batt[8].setModel(ma[3]);
		
		batt[9] = new BatteriaDAO();
		batt[9].setID(32);
		batt[9].setCostSubstitution(10.23f);
		batt[9].setCyclesRecharge(21);
		batt[9].setModel(ma[5]);
		
		batt[10] = new BatteriaDAO();
		batt[10].setID(33);
		batt[10].setCostSubstitution(550.55f);
		batt[10].setCyclesRecharge(78);
		batt[10].setModel(ma[1]);
		
		batt[11] = new BatteriaDAO();
		batt[11].setID(34);
		batt[11].setCostSubstitution(470.98f);
		batt[11].setCyclesRecharge(56);
		batt[11].setModel(ma[2]);
		
		batt[12] = new BatteriaDAO();
		batt[12].setID(35);
		batt[12].setCostSubstitution(450.99f);
		batt[12].setCyclesRecharge(70);
		batt[12].setModel(ma[2]);
		
		batt[13] = new BatteriaDAO();
		batt[13].setID(36);
		batt[13].setCostSubstitution(530.30f);
		batt[13].setCyclesRecharge(108);
		batt[13].setModel(ma[0]);
		
		batt[14] = new BatteriaDAO();
		batt[14].setID(37);
		batt[14].setCostSubstitution(25.30f);
		batt[14].setCyclesRecharge(20);
		batt[14].setModel(ma[4]);
		
		for (BatteriaDAO b : batt) b.save();
		
		st[2].setAvailableBatteries(batt[0]);
		st[0].setAvailableBatteries(batt[1]);
		st[0].setAvailableBatteries(batt[2]);
		st[1].setAvailableBatteries(batt[3]);
		st[1].setAvailableBatteries(batt[4]);
		st[2].setAvailableBatteries(batt[5]);
		st[1].setAvailableBatteries(batt[6]);
		st[0].setAvailableBatteries(batt[7]);
		
		ClienteDAO[] cl = new ClienteDAO[4];
		Calendar[] cal = new Calendar[4];
		
		cl[0] = new ClienteDAO();
		cl[0].setID(-2);
		cl[0].setName("Sun");
		cl[0].setSurname("Hu");
		cal[0] = Calendar.getInstance();
		cal[0].clear();
		cal[0].set(1990, 10, 21);
		cl[0].setDate(cal[0]);
		
		cl[1] = new ClienteDAO();
		cl[1].setID(0);
		cl[1].setName("Abbas");
		cl[1].setSurname("Aziz");
		cal[1] = Calendar.getInstance();
		cal[1].clear();
		cal[1].set(1996, 04, 13);
		cl[1].setDate(cal[1]);
		
		cl[2] = new ClienteDAO();
		cl[2].setID(1);
		cl[2].setName("Rossi");
		cl[2].setSurname("Mario");
		cal[2] = Calendar.getInstance();
		cal[2].clear();
		cal[2].set(1984, 07, 03);
		cl[2].setDate(cal[2]);
		
		cl[3] = new ClienteDAO();
		cl[3].setID(3);
		cl[3].setName("Brambilla");
		cl[3].setSurname("Paolo");
		cal[3] = Calendar.getInstance();
		cal[3].clear();
		cal[3].set(1965, 01, 30);
		cl[3].setDate(cal[3]);
		
		for (ClienteDAO c : cl) c.save();
		
		BadgeDAO[] bg = new BadgeDAO[4];
		
		bg[0] = new BadgeDAO();
		bg[0].setCode(-3);
		bg[0].setCredit(50.00f);
		bg[0].setClient(cl[2]);
		
		bg[1] = new BadgeDAO();	
		bg[1].setCode(0);
		bg[1].setCredit(18.21f);
		bg[1].setClient(cl[3]);
		
		bg[2] = new BadgeDAO();
		bg[2].setCode(1);
		bg[2].setCredit(10.00f);
		bg[2].setClient(cl[1]);
		
		bg[3] = new BadgeDAO();
		bg[3].setCode(5);
		bg[3].setCredit(1000.00f);
		bg[3].setClient(cl[0]);

		UltimaSostituzioneDAO[] sost = new UltimaSostituzioneDAO[7];
		Calendar[] scal = new Calendar[7];
		
		sost[0] = new UltimaSostituzioneDAO();
		sost[0].setID(1);
		scal[0] = Calendar.getInstance();
		scal[0].clear();
		scal[0].set(2015, Calendar.AUGUST, 29, 18, 32);
		sost[0].setDateHour(scal[0]);
		sost[0].setBattery(batt[8]);
		sost[0].setStation(st[1]);
		
		sost[1] = new UltimaSostituzioneDAO();
		sost[1].setID(3);
		scal[1] = Calendar.getInstance();
		scal[1].clear();
		scal[1].set(2015, Calendar.JULY, 20, 21, 12);
		sost[1].setDateHour(scal[1]);
		sost[1].setBattery(batt[9]);
		sost[1].setStation(st[0]);
		
		sost[2] = new UltimaSostituzioneDAO();
		sost[2].setID(5);
		scal[2] = Calendar.getInstance();
		scal[2].clear();
		scal[2].set(2015, Calendar.SEPTEMBER, 02, 10, 15);
		sost[2].setDateHour(scal[2]);
		sost[2].setBattery(batt[10]);
		sost[2].setStation(st[0]);
		
		sost[3] = new UltimaSostituzioneDAO();
		sost[3].setID(6);
		scal[3] = Calendar.getInstance();
		scal[3].clear();
		scal[3].set(2015, Calendar.SEPTEMBER, 01, 13, 30);
		sost[3].setDateHour(scal[3]);
		sost[3].setBattery(batt[11]);
		sost[3].setStation(st[2]);
		
		sost[4] = new UltimaSostituzioneDAO();
		sost[4].setID(7);
		scal[4] = Calendar.getInstance();
		scal[4].clear();
		scal[4].set(2015, Calendar.AUGUST, 20, 9, 20);
		sost[4].setDateHour(scal[4]);
		sost[4].setBattery(batt[12]);
		sost[4].setStation(st[1]);
		
		sost[5] = new UltimaSostituzioneDAO();
		sost[5].setID(10);
		scal[5] = Calendar.getInstance();
		scal[5].clear();
		scal[5].set(2015, Calendar.JULY, 15, 18, 45);
		sost[5].setDateHour(scal[5]);
		sost[5].setBattery(batt[13]);
		sost[5].setStation(st[1]);
		
		sost[6] = new UltimaSostituzioneDAO();
		sost[6].setID(11);
		scal[6] = Calendar.getInstance();
		scal[6].clear();
		scal[6].set(2015, Calendar.SEPTEMBER, 12, 15, 29);
		sost[6].setDateHour(scal[6]);
		sost[6].setBattery(batt[14]);
		sost[6].setStation(st[0]);
		
		for (UltimaSostituzioneDAO s : sost) s.save();
		
		AutovetturaCompatibileDAO[] ac = new AutovetturaCompatibileDAO[7];
		
		ac[0] = new AutovetturaCompatibileDAO();
		ac[0].setNumberPlate("AS 110 WA");
		ac[0].setModel(ma[3]);
		ac[0].setLastRicambio(sost[0]);
	
		ac[1] = new AutovetturaCompatibileDAO();
		ac[1].setNumberPlate("CB 739 HJ");
		ac[1].setModel(ma[5]);
		ac[1].setLastRicambio(sost[1]);
		
		ac[2] = new AutovetturaCompatibileDAO();
		ac[2].setNumberPlate("DZ 120 FP");
		ac[2].setModel(ma[1]);
		ac[2].setLastRicambio(sost[2]);
	
		ac[3] = new AutovetturaCompatibileDAO();
		ac[3].setNumberPlate("EA 210 BB");
		ac[3].setModel(ma[2]);
		ac[3].setLastRicambio(sost[3]);
		
		ac[4] = new AutovetturaCompatibileDAO();
		ac[4].setNumberPlate("ED 190 ES");
		ac[4].setModel(ma[2]);
		ac[4].setLastRicambio(sost[4]);
	
		ac[5] = new AutovetturaCompatibileDAO();
		ac[5].setNumberPlate("EF 580 AA");
		ac[5].setModel(ma[0]);
		ac[5].setLastRicambio(sost[5]);
		
		ac[6] = new AutovetturaCompatibileDAO();
		ac[6].setNumberPlate("EZ 711 PL");
		ac[6].setModel(ma[4]);
		ac[6].setLastRicambio(sost[6]);
		
		for (AutovetturaCompatibileDAO a : ac) a.save();
		
		cl[1].setOwnedCars(ac[0]);
		cl[3].setOwnedCars(ac[1]);
		cl[0].setOwnedCars(ac[2]);
		cl[0].setOwnedCars(ac[3]);
		cl[0].setOwnedCars(ac[4]);
		cl[0].setOwnedCars(ac[5]);
		cl[0].setOwnedCars(ac[6]);
		for (ClienteDAO c : cl) c.update();
	}
			
	public static BatteriaDAO testStazione (int idStazione, int idBatteria, int cicliRicarica, float costo, int idModello) {
		
		StazioneDAO s = StazioneDAO.findStation(idStazione);
		
		List<BatteriaDAO> list = s.getAvailableBatteries();
		int k = 0;
		while (k < list.size() ){
			if ((list.get(k).getID() == idBatteria) && 
				(list.get(k).getCyclesRecharge() == cicliRicarica) && 
				(Float.compare(list.get(k).getCostSubstitution(), costo) == 0) && 
				(list.get(k).getModel().getID() == idModello)){
					return list.get(k);
				} 
				k++;
			}		
		return null;
		
	}
	
	public static BatteriaDAO testSostituzione (String targa){
		AutovetturaCompatibileDAO auto = AutovetturaCompatibileDAO.findCar(targa);
		
		if (auto != null){
			UltimaSostituzioneDAO s = new UltimaSostituzioneDAO ();
			s = auto.getLastSubstitution();		
			return s.getBattery();		
		}
		return null;
	}
}


