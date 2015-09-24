package Server.Entity;

import java.util.Calendar;

public class PopulateTestDatabase {
	
	public static void populate() {		
		Stazione[] st = new Stazione[3];
		
		st[0] = new Stazione();
		st[0].setID(1);
		st[0].setNome("Stazione Centrale");
		st[0].setIndirizzo("Piazzale Tecchio");
	
		st[1] = new Stazione();
		st[1].setID(2);
		st[1].setNome("Stazione Agnoli");
		st[1].setIndirizzo("Via Nuova Agnano");
		
		st[2] = new Stazione();
		st[2].setID(3);
		st[2].setNome("Stazione Stadio");
		st[2].setIndirizzo("Via Claudio");
		
		for (Stazione s : st) s.salva();
		
		ModelloAutovettura[] ma = new ModelloAutovettura[7];
		
		ma[0] = new ModelloAutovettura();
		ma[0].setID(1);
		ma[0].setFornitore("Maserati");
		ma[0].setModello("Quattroporte");
	
		ma[1] = new ModelloAutovettura();
		ma[1].setID(2);
		ma[1].setFornitore("Lamborghini");
		ma[1].setModello("Gallardo");
		
		ma[2] = new ModelloAutovettura();
		ma[2].setID(3);
		ma[2].setFornitore("Mercedes");
		ma[2].setModello("SLK");
		
		ma[3] = new ModelloAutovettura();
		ma[3].setID(12);
		ma[3].setFornitore("Alfa Romeo");
		ma[3].setModello("Giulietta");
		
		ma[4] = new ModelloAutovettura();
		ma[4].setID(13);
		ma[4].setFornitore("Alfa Romeo");
		ma[4].setModello("Mito");
		
		ma[5] = new ModelloAutovettura();
		ma[5].setID(21);
		ma[5].setFornitore("Peugeot");
		ma[5].setModello("207");
		
		ma[6] = new ModelloAutovettura();
		ma[6].setID(43);
		ma[6].setFornitore("Fiat");
		ma[6].setModello("Panda");
		
		for (ModelloAutovettura m : ma) m.salva();
		
		Batteria[] batt = new Batteria[15];
		
		batt[0] = new Batteria();
		batt[0].setID(1);
		batt[0].setCostoSostituzione(610.21f);
		batt[0].setCicliRicarica(121);
		batt[0].setModello(ma[2]);
	
		batt[1] = new Batteria();
		batt[1].setID(2);
		batt[1].setCostoSostituzione(550.50f);
		batt[1].setCicliRicarica(4);
		batt[1].setModello(ma[0]);
		
		batt[2] = new Batteria();
		batt[2].setID(3);
		batt[2].setCostoSostituzione(490.25f);
		batt[2].setCicliRicarica(79);
		batt[2].setModello(ma[0]);
		
		batt[3] = new Batteria();
		batt[3].setID(9);
		batt[3].setCostoSostituzione(250.25f);
		batt[3].setCicliRicarica(3);
		batt[3].setModello(ma[2]);
		
		batt[4] = new Batteria();
		batt[4].setID(10);
		batt[4].setCostoSostituzione(20.25f);
		batt[4].setCicliRicarica(2);
		batt[4].setModello(ma[5]);
		
		batt[5] = new Batteria();
		batt[5].setID(12);
		batt[5].setCostoSostituzione(21.50f);
		batt[5].setCicliRicarica(20);
		batt[5].setModello(ma[5]);
		
		batt[6] = new Batteria();
		batt[6].setID(21);
		batt[6].setCostoSostituzione(11.50f);
		batt[6].setCicliRicarica(24);
		batt[6].setModello(ma[6]);
		
		batt[7] = new Batteria();
		batt[7].setID(22);
		batt[7].setCostoSostituzione(9.90f);
		batt[7].setCicliRicarica(19);
		batt[7].setModello(ma[6]);
		
		batt[8] = new Batteria();
		batt[8].setID(31);
		batt[8].setCostoSostituzione(40.55f);
		batt[8].setCicliRicarica(6);
		batt[8].setModello(ma[3]);
		
		batt[9] = new Batteria();
		batt[9].setID(32);
		batt[9].setCostoSostituzione(10.23f);
		batt[9].setCicliRicarica(21);
		batt[9].setModello(ma[5]);
		
		batt[10] = new Batteria();
		batt[10].setID(33);
		batt[10].setCostoSostituzione(550.55f);
		batt[10].setCicliRicarica(78);
		batt[10].setModello(ma[1]);
		
		batt[11] = new Batteria();
		batt[11].setID(34);
		batt[11].setCostoSostituzione(470.98f);
		batt[11].setCicliRicarica(56);
		batt[11].setModello(ma[2]);
		
		batt[12] = new Batteria();
		batt[12].setID(35);
		batt[12].setCostoSostituzione(450.99f);
		batt[12].setCicliRicarica(70);
		batt[12].setModello(ma[2]);
		
		batt[13] = new Batteria();
		batt[13].setID(36);
		batt[13].setCostoSostituzione(530.30f);
		batt[13].setCicliRicarica(108);
		batt[13].setModello(ma[0]);
		
		batt[14] = new Batteria();
		batt[14].setID(37);
		batt[14].setCostoSostituzione(25.30f);
		batt[14].setCicliRicarica(20);
		batt[14].setModello(ma[4]);
		
		for (Batteria b : batt) b.salva();
		
		st[2].insertBatteria(batt[0]);
		st[0].insertBatteria(batt[1]);
		st[0].insertBatteria(batt[2]);
		st[1].insertBatteria(batt[3]);
		st[1].insertBatteria(batt[4]);
		st[2].insertBatteria(batt[5]);
		st[1].insertBatteria(batt[6]);
		st[0].insertBatteria(batt[7]);
		
		Cliente[] cl = new Cliente[4];
		Calendar[] cal = new Calendar[4];
		
		cl[0] = new Cliente();
		cl[0].setId(-2);
		cl[0].setNome("Sun");
		cl[0].setCognome("Hu");
		cal[0] = Calendar.getInstance();
		cal[0].clear();
		cal[0].set(1990, 10, 21);
		cl[0].setData(cal[0]);
		
		cl[1] = new Cliente();
		cl[1].setId(0);
		cl[1].setNome("Abbas");
		cl[1].setCognome("Aziz");
		cal[1] = Calendar.getInstance();
		cal[1].clear();
		cal[1].set(1996, 04, 13);
		cl[1].setData(cal[1]);
		
		cl[2] = new Cliente();
		cl[2].setId(1);
		cl[2].setNome("Rossi");
		cl[2].setCognome("Mario");
		cal[2] = Calendar.getInstance();
		cal[2].clear();
		cal[2].set(1984, 07, 03);
		cl[2].setData(cal[2]);
		
		cl[3] = new Cliente();
		cl[3].setId(3);
		cl[3].setNome("Brambilla");
		cl[3].setCognome("Paolo");
		cal[3] = Calendar.getInstance();
		cal[3].clear();
		cal[3].set(1965, 01, 30);
		cl[3].setData(cal[3]);
		
		for (Cliente c : cl) c.salva();
		
		Badge[] bg = new Badge[4];
		
		bg[0] = new Badge();
		bg[0].setCodice(-3);
		bg[0].setCredito(50.00f);
		bg[0].setCliente(cl[2]);
		
		bg[1] = new Badge();
		bg[1].setCodice(0);
		bg[1].setCredito(18.21f);
		bg[1].setCliente(cl[3]);
		
		bg[2] = new Badge();
		bg[2].setCodice(1);
		bg[2].setCredito(10.00f);
		bg[2].setCliente(cl[1]);
		
		bg[3] = new Badge();
		bg[3].setCodice(5);
		bg[3].setCredito(1000.00f);
		bg[3].setCliente(cl[0]);
		
		for (Badge b : bg) b.salva();
		
		Sostituzione[] sost = new Sostituzione[7];
		Calendar[] scal = new Calendar[7];
		
		sost[0] = new Sostituzione();
		sost[0].setID(1);
		scal[0] = Calendar.getInstance();
		scal[0].clear();
		scal[0].set(2015, Calendar.AUGUST, 29, 18, 32);
		sost[0].setDataOra(scal[0]);
		sost[0].setBatteria(batt[8]);
		sost[0].setStazione(st[1]);
		
		sost[1] = new Sostituzione();
		sost[1].setID(3);
		scal[1] = Calendar.getInstance();
		scal[1].clear();
		scal[1].set(2015, Calendar.JULY, 20, 21, 12);
		sost[1].setDataOra(scal[1]);
		sost[1].setBatteria(batt[9]);
		sost[1].setStazione(st[0]);
		
		sost[2] = new Sostituzione();
		sost[2].setID(5);
		scal[2] = Calendar.getInstance();
		scal[2].clear();
		scal[2].set(2015, Calendar.SEPTEMBER, 02, 10, 15);
		sost[2].setDataOra(scal[2]);
		sost[2].setBatteria(batt[9]);
		sost[2].setStazione(st[0]);
		
		sost[3] = new Sostituzione();
		sost[3].setID(6);
		scal[3] = Calendar.getInstance();
		scal[3].clear();
		scal[3].set(2015, Calendar.SEPTEMBER, 01, 13, 30);
		sost[3].setDataOra(scal[3]);
		sost[3].setBatteria(batt[10]);
		sost[3].setStazione(st[2]);
		
		sost[4] = new Sostituzione();
		sost[4].setID(7);
		scal[4] = Calendar.getInstance();
		scal[4].clear();
		scal[4].set(2015, Calendar.AUGUST, 20, 9, 20);
		sost[4].setDataOra(scal[4]);
		sost[4].setBatteria(batt[11]);
		sost[4].setStazione(st[1]);
		
		sost[5] = new Sostituzione();
		sost[5].setID(10);
		scal[5] = Calendar.getInstance();
		scal[5].clear();
		scal[5].set(2015, Calendar.JULY, 15, 18, 45);
		sost[5].setDataOra(scal[5]);
		sost[5].setBatteria(batt[12]);
		sost[5].setStazione(st[1]);
		
		sost[6] = new Sostituzione();
		sost[6].setID(11);
		scal[6] = Calendar.getInstance();
		scal[6].clear();
		scal[6].set(2015, Calendar.SEPTEMBER, 12, 15, 29);
		sost[6].setDataOra(scal[6]);
		sost[6].setBatteria(batt[13]);
		sost[6].setStazione(st[0]);
		
		for (Sostituzione s : sost) s.salva();
		
		AutovetturaCompatibile[] ac = new AutovetturaCompatibile[7];
		
		ac[0] = new AutovetturaCompatibile();
		ac[0].setNumeroTarga("AS 110 WA");
		ac[0].setModello(ma[3]);
		ac[0].setLastRicambio(sost[0]);
	
		ac[1] = new AutovetturaCompatibile();
		ac[1].setNumeroTarga("CB 739 HJ");
		ac[1].setModello(ma[5]);
		ac[1].setLastRicambio(sost[1]);
		
		ac[2] = new AutovetturaCompatibile();
		ac[2].setNumeroTarga("DZ 120 FP");
		ac[2].setModello(ma[1]);
		ac[2].setLastRicambio(sost[2]);
	
		ac[3] = new AutovetturaCompatibile();
		ac[3].setNumeroTarga("EA 210 BB");
		ac[3].setModello(ma[2]);
		ac[3].setLastRicambio(sost[3]);
		
		ac[4] = new AutovetturaCompatibile();
		ac[4].setNumeroTarga("ED 190 ES");
		ac[4].setModello(ma[2]);
		ac[4].setLastRicambio(sost[4]);
	
		ac[5] = new AutovetturaCompatibile();
		ac[5].setNumeroTarga("EF 580 AA");
		ac[5].setModello(ma[0]);
		ac[5].setLastRicambio(sost[5]);
		
		ac[6] = new AutovetturaCompatibile();
		ac[6].setNumeroTarga("EZ 711 PL");
		ac[6].setModello(ma[4]);
		ac[6].setLastRicambio(sost[6]);
		
		for (AutovetturaCompatibile a : ac) a.salva();
		
		cl[1].insertAutoPossedute(ac[0]);
		cl[3].insertAutoPossedute(ac[1]);
		cl[0].insertAutoPossedute(ac[2]);
		cl[0].insertAutoPossedute(ac[3]);
		cl[0].insertAutoPossedute(ac[4]);
		cl[0].insertAutoPossedute(ac[5]);
		cl[0].insertAutoPossedute(ac[6]);
			
	}

}
