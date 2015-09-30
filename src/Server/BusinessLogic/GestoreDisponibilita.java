package Server.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import Server.DAO.*;
import Server.Entity.Societa;

public class GestoreDisponibilita{

	/**
	 * 
	 * @param modello
	 */
	public static boolean addBatteria(int IDstazione, int IDbatteria, float costosostituzione, int maxcicliricarica, Autovettura modello) {
		
		Server.DAO.Stazione s = new Server.DAO.Stazione();
		if (Societa.findStazione(s, IDstazione) == false) return false;
		try {
			Server.DAO.Batteria b = new Server.DAO.Batteria(IDbatteria, costosostituzione, maxcicliricarica, modello.getAutovettura());
			s.insertBatteria(b);
		} catch (Exception ex) {
			return false;
	}
		return true;
	
	}
	
	public static ArrayList<Batteria> retrieveBatterieCompatibili(Autovettura modello, int IDstazione) {
		
		ArrayList<Batteria> batterieCompatibili = new ArrayList<Batteria>();
		Server.DAO.ModelloAutovettura m = modello.getAutovettura();
		Server.DAO.Stazione s = new Server.DAO.Stazione();
		Societa.findStazione(s, IDstazione);
		List<Server.DAO.Batteria> lista = s.getBatterieDisp();
		
		for(int i=0; i<lista.size(); i++){
			
			if(lista.get(i).getModello().equals(m)){
				Server.BusinessLogic.Batteria nuova = new Server.BusinessLogic.Batteria();
				nuova.setBatteria(lista.get(i));
				batterieCompatibili.add(nuova);
			}
		}
		
		return batterieCompatibili;
	}

	/**
	 * 
	 * @param modello
	 */
	public static ArrayList<Stazione> remoteRetrieveBatterieCompatibili(Autovettura modello, int IDstazione) {
		
			
		ArrayList<Stazione> stazioniRemote = new ArrayList<Stazione>();
		List<Server.DAO.Stazione> listaS = Societa.getListaStazioni();
		ModelloAutovettura m = modello.getAutovettura();
		
		int k;
		boolean hit;
		
		for(int i=0; i<listaS.size(); i++){
			
			k = 0;
			hit = false;
			
			if(listaS.get(i).getID() != IDstazione){
				
				List<Server.DAO.Batteria> listaB = listaS.get(i).getBatterieDisp();
				
				
				while(hit != true && k < listaB.size()){
					if(listaB.get(k).getModello().equals(m)){
						Server.BusinessLogic.Stazione nuova = new Server.BusinessLogic.Stazione();
						nuova.setStazione(listaS.get(i));
						stazioniRemote.add(nuova);
						hit = true;
					}
					k++;
					
				}
			}
		}

		
		return stazioniRemote;
		
	}

	/**
	 * 
	 * @param batteria
	 */
	public static boolean removeBatteria(Server.BusinessLogic.Batteria batteria, int IDstazione) {
		
		Server.DAO.Stazione s = new Server.DAO.Stazione();
		if ( Societa.findStazione(s, IDstazione) == false) return false;
		Server.DAO.Batteria b = batteria.getBatteria();
		
		s.deleteBatteria(b);
		
		return true;
		
	}

	/**
	 * 
	 * @param batteria
	 */
	public static boolean addBatteriaDisponibili(Batteria batteria, int IDstazione) {
		
		Server.DAO.Batteria b = batteria.getBatteria();
		Server.DAO.Stazione s = new Server.DAO.Stazione();
		
		if ( Societa.findStazione(s, IDstazione) == false) return false;
		int cicliNew = b.getCicliRicarica() - 1;
		if(cicliNew > 0){
			b.setCicliRicarica(cicliNew);
			s.insertBatteria(b);
			return true;
		}else
			throw new IllegalStateException("Il server ha ricaricato una batteria esausta");
	}
	
	

}