package Server.BusinessLogic;

import Server.Entity.*;

public class GestoreSostituzioni {

	public static Server.BusinessLogic.UltimaSostituzione findLastSostituzione(AutovetturaCliente auto) {
		
		Server.BusinessLogic.UltimaSostituzione ultima = new Server.BusinessLogic.UltimaSostituzione();
		Server.Entity.AutovetturaCompatibile a = auto.getAutovetturaCliente();
		
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

		Server.Entity.AutovetturaCompatibile a = autovettura.getAutovetturaCliente();
		Server.Entity.Sostituzione ultima = new Server.Entity.Sostituzione ();
		ultima = a.getLastRicambio();
		Server.Entity.Stazione stazione = new Server.Entity.Stazione();
		boolean ris = Società.findStazione(stazione, idStazione);
		if (ris == true ){
			stazione.getStazione(idStazione);
			Server.BusinessLogic.Batteria vecchia = new Server.BusinessLogic.Batteria();
			Server.Entity.Batteria b = new Server.Entity.Batteria ();
			b = ultima.updateSostituzione(stazione, batteria.getBatteria());
			vecchia.setBatteria(b);
			stazione.removeBatteria(batteria.getBatteria());
			return vecchia;
		} else return batteria ;
	
	}

}