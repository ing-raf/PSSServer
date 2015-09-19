package Server.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import Server.Entity.*;

public class GestoreDisponibilità{

	/**
	 * 
	 * @param modello
	 */
	public static boolean addBatteria(int IDstazione, int IDbatteria, float costosostituzione, int maxcicliricarica, Autovettura modello) {
		
		Server.Entity.Stazione s = new Server.Entity.Stazione();
		if (Società.findStazione(s, IDstazione) == false) return false;
		Server.Entity.Batteria b = new Server.Entity.Batteria(IDbatteria, costosostituzione, maxcicliricarica, modello.getAutovettura());
		
		s.insertBatteria(b);
		
		return true;
	
	}
	
	public static ArrayList<Batteria> retrieveBatterieCompatibili(Autovettura modello, int IDstazione) {
		
		ArrayList<Batteria> batterieCompatibili = new ArrayList<Batteria>();
		Server.Entity.ModelloAutovettura m = modello.getAutovettura();
		Server.Entity.Stazione s = new Server.Entity.Stazione();
		Società.findStazione(s, IDstazione);
		List<Server.Entity.Batteria> lista = s.getBatterieDisp();
		
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
		List<Server.Entity.Stazione> listaS = Società.getListaStazioni();
		ModelloAutovettura m = modello.getAutovettura();
		
		int k;
		boolean hit;
		
		for(int i=0; i<listaS.size(); i++){
			
			k = 0;
			hit = false;
			
			if(listaS.get(i).getID() != IDstazione){
				
				List<Server.Entity.Batteria> listaB = listaS.get(i).getBatterieDisp();
				
				while(hit != true || k < listaB.size()){
					if(listaB.get(k).getModello().equals(m)){
						Server.BusinessLogic.Stazione nuova = new Server.BusinessLogic.Stazione();
						nuova.setStazione(listaS.get(i));
						stazioniRemote.add(nuova);
						hit = true;
					}else k++;
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
		
		Server.Entity.Stazione s = new Server.Entity.Stazione();
		if ( Società.findStazione(s, IDstazione) == false) return false;
		Server.Entity.Batteria b = batteria.getBatteria();
		
		s.removeBatteria(b);
		
		return true;
		
	}

	/**
	 * 
	 * @param batteria
	 */
	public static boolean addBatteriaDisponibili(Batteria batteria, int IDstazione) {
		
		Server.Entity.Batteria b = batteria.getBatteria();
		Server.Entity.Stazione s = new Server.Entity.Stazione();
		
		int cicliNew = b.getCicliRicarica() - 1;
		if ( Società.findStazione(s, IDstazione) == false) return false;
		if(cicliNew > 0){
			b.setCicliRicarica(cicliNew);
			s.insertBatteria(b);
			return true;
		}else
			s.removeBatteria(b);
			return false;
	}

}