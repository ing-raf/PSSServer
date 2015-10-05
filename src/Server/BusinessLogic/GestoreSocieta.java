package Server.BusinessLogic;

import java.util.ArrayList;

import Server.Entity.Societa;

public class GestoreSocieta {
	
	public GestoreSocieta() {
		
	}
	
	public ArrayList<AutovetturaBL> retrieveModelList() {
		Societa.getModelList();
		return null;
	}
	
	public ArrayList<StazioneBL> retrieveStationList() {
		return null;
	}

}
