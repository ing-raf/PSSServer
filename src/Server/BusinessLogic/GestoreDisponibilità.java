package Server.BusinessLogic;

import java.sql.SQLException;
import java.util.ArrayList;
import Server.Entity.*;

public class GestoreDisponibilità{

	/**
	 * 
	 * @param modello
	 */
	public static boolean addBatteria(int IDstazione, int IDbatteria, float costosostituzione, int maxcicliricarica, Autovettura modello) {
		
		Server.Entity.Stazione s = new Server.Entity.Stazione(IDstazione);
		Server.Entity.Batteria b = new Server.Entity.Batteria(IDbatteria, costosostituzione, maxcicliricarica, modello.getAutovettura());
		
		try{
			
			s.insertBatteria(b);
		
		}catch(SQLException e){
			
			e.printStackTrace();
			return false;
		}
		
		return true;
	
	}
	
	public static ArrayList<Batteria> retrieveBatterieCompatibili(Autovettura modello, int IDstazione) {
		
		ArrayList<Batteria> batterieCompatibili = new ArrayList<Batteria>();
		Server.Entity.ModelloAutovettura m = modello.getAutovettura();
		Server.Entity.Stazione s = new Server.Entity.Stazione(IDstazione);
		ArrayList<Server.Entity.Batteria> lista = s.getListaBatterie();
		
		for(int i=0; i<lista.size(); i++){
			
			if(lista.get(i).getModelloAutovettura().equals(m)){
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
		Societ� s = new Societ�();
		ArrayList<Server.Entity.Stazione> listaS = s.getListaStazioni();
		ModelloAutovettura m = modello.getAutovettura();
		
		int k;
		boolean hit;
		
		for(int i=0; i<listaS.size(); i++){
			
			k = 0;
			hit = false;
			
			if(listaS.get(i).getID() != IDstazione){
				
				ArrayList<Server.Entity.Batteria> listaB = listaS.get(i).getListaBatterie();
				
				while(hit != true || k == listaB.size() - 1){
					if(listaB.get(k).getModelloAutovettura().equals(m)){
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
		
		Server.Entity.Stazione s = new Server.Entity.Stazione(IDstazione);
		Server.Entity.Batteria b = batteria.getBatteria();
		
		try{
			
			s.removeBatteria(b);
		
		}catch(SQLException e){
			
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}

	/**
	 * 
	 * @param batteria
	 */
	public static boolean addBatteriaDisponibili(Batteria batteria, int IDstazione) {
		
		Server.Entity.Batteria b = batteria.getBatteria();
		Server.Entity.Stazione s = new Server.Entity.Stazione(IDstazione);
		int cicliNew = b.getCicliRicarica() - 1;
		
		if(cicliNew > 0){
			b.setCicliRicarica(cicliNew);
			s.insertBatteria(b);
			return true;
		}else
			s.removeBatteria(b);
			return false;
	}

}