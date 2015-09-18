package Server.BusinessLogic;

import java.util.ArrayList;


public class GestoreBatterie {


	private static int sogliaQuasiEsausta = 5;
	
	/**
	 * 
	 * @param IDstazione
	 */
	public static ArrayList<Batteria> retrieveBatterieQuasiEsauste(int IDstazione) {
		
		Server.Entity.Stazione s = new Server.Entity.Stazione(IDstazione);
		ArrayList<Batteria> quasiEsauste = new ArrayList<Batteria>();
		ArrayList<Server.Entity.Batteria> lista = s.getListaBatterie();
		
		for(int i = 0; i < lista.size(); i++){
			
			if(lista.get(i).getCicliCarica() < sogliaQuasiEsausta){
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
		
		Server.Entity.Batteria b = batteria.getBatteria();
		
		if(b.getCicliRicarica() > 0){
			return true;
		}else
			return false;
	}

}