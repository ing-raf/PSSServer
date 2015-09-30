package Server.BusinessLogic;

import Server.DAO.*;
import Server.Entity.Societa;

public class GestoreSostituzioni {

	public static Server.BusinessLogic.UltimaSostituzione findLastSostituzione(AutovetturaCliente auto) {
		
		Server.BusinessLogic.UltimaSostituzione ultima = new Server.BusinessLogic.UltimaSostituzione();
		Server.DAO.AutovetturaCompatibileDAO a = auto.getAutovetturaCliente();
		
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

		Server.DAO.AutovetturaCompatibileDAO a = autovettura.getAutovetturaCliente();
		Server.DAO.Sostituzione ultima = new Server.DAO.Sostituzione ();
		ultima = a.getLastRicambio();
		Server.DAO.StazioneDAO stazione = new Server.DAO.StazioneDAO();
		boolean ris = Societa.findStazione(stazione, idStazione);
		if (ris == true ){
			stazione.getStazione(idStazione);
			Server.BusinessLogic.Batteria vecchia = new Server.BusinessLogic.Batteria();
			Server.DAO.BatteriaDAO b = new Server.DAO.BatteriaDAO ();
			b = ultima.updateSostituzione(stazione, batteria.getBatteria());
			vecchia.setBatteria(b);
			stazione.removeBatteria(batteria.getBatteria());
			return vecchia;
		} else return batteria ;
	
	}

}