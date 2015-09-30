package Server.BusinessLogic;

import Server.DAO.*;
import Server.Entity.Societa;

public class GestoreSostituzioni {

	public static Server.BusinessLogic.UltimaSostituzione findLastSostituzione(AutovetturaCliente auto) {
		
		Server.BusinessLogic.UltimaSostituzione ultima = new Server.BusinessLogic.UltimaSostituzione();
		Server.DAO.AutovetturaCompatibile a = auto.getAutovetturaCliente();
		
		ultima.setSostituzione(a.getLastRicambio());
		
		return ultima;
	}

	/**
	 * 
	 * @param autovettura
	 * @param idStazione
	 * @param batteria
	 */
	public static Batteria updateSostituzione(AutovetturaCliente autovettura, int idStazione, Server.BusinessLogic.Batteria batteria) {

		Server.DAO.AutovetturaCompatibile a = autovettura.getAutovetturaCliente();
		Server.DAO.Sostituzione ultima = new Server.DAO.Sostituzione ();
		ultima = a.getLastRicambio();
		Server.DAO.Stazione stazione = new Server.DAO.Stazione();
		boolean ris = Societa.findStazione(stazione, idStazione);
		if (ris == true ){
			stazione.getStazione(idStazione);
			Server.BusinessLogic.Batteria vecchia = new Server.BusinessLogic.Batteria();
			Server.DAO.Batteria b = new Server.DAO.Batteria ();
			b = ultima.updateSostituzione(stazione, batteria.getBatteria());
			vecchia.setBatteria(b);
			stazione.removeBatteria(batteria.getBatteria());
			return vecchia;
		} else return batteria ;
	
	}

}