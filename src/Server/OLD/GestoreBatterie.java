package Server.OLD;

import java.util.ArrayList;
import java.util.List;

import Server.Entity.Societa;


public class GestoreBatterie {


	private static int sogliaQuasiEsausta = 5;
	
	/**
	 * 
	 * @param IDstazione
	 */
	public static ArrayList<Batteria> retrieveBatterieQuasiEsauste(int IDstazione) {
		
		Server.DAO.StazioneDAO s = new Server.DAO.StazioneDAO();
		Societa.findStazione(s, IDstazione);
		ArrayList<Batteria> quasiEsauste = new ArrayList<Batteria>();
		List<Server.DAO.BatteriaDAO> lista = s.getBatterieDisp();
		
		for(int i = 0; i < lista.size(); i++){
			
			if(lista.get(i).getCicliRicarica() < sogliaQuasiEsausta){
				Server.BusinessLogic.Batteria nuova = new Server.BusinessLogic.Batteria();
				nuova.setBatteria(lista.get(i));
				quasiEsauste.add(nuova);
			}
		}
		return quasiEsauste;
	}

	/**
	 * 
	 * @param batteria
	 */
	public static boolean verifyRicarica(Batteria batteria) {
		
		Server.DAO.BatteriaDAO b = batteria.getBatteria();
		
		if(b.getCicliRicarica() > 0){
			return true;
		}else
			return false;
	}

}