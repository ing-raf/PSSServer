package Server.BusinessLogic;

import Server.Entity.AutovetturaCompatibile;
import Server.Entity.Batteria;
import Server.Entity.ModelloAutovettura;
import Server.Entity.Societa;
import Server.Entity.Stazione;
import Server.Entity.UltimaSostituzione;

public class GestoreStazione {
	
	private int ID;
	
	public GestoreStazione(int ID) {
		this.ID = ID;
	}
	
	public boolean updateSostituzione(AutovetturaClienteBL auto, BatteriaBL nuova, BatteriaBL vecchia) {
		AutovetturaCompatibile car = 
				AutovetturaCompatibile.getCar(auto.getNumberPlate());
		
		Batteria old = car.getLastSubstitution().getBattery();
		vecchia.setID(old.getID());
		vecchia.setCostSubstitution(old.getCostSubstitution());
		vecchia.setCyclesRecharge(old.getCyclesRecharge());
		vecchia.setBrand(old.getModel().getBrand());
		vecchia.setModel(old.getModel().getBrand());
		
		Batteria fresh = new Batteria();
		fresh.setID( nuova.getID() );
		fresh.setCostSubstitution( nuova.getCostSubstitution() );
		fresh.setCyclesRecharge( nuova.getCyclesRecharge() );
			ModelloAutovettura modello = new ModelloAutovettura();
			modello.setBrand( nuova.getBrand() );
			modello.setModel( nuova.getModel() );
		fresh.setModel(modello);
		
		Societa laSocieta = Societa.getSociety();
		Stazione locale = laSocieta.getStation(this.ID);
		
		
		
		return true;
	}

}
