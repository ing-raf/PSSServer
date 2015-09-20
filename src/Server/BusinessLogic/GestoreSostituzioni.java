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
		Server.Entity.Sostituzione ultima = a.getLastRicambio();
		
		Server.Entity.Stazione stazione = new Server.Entity.Stazione();
		Società.findStazione(stazione, idStazione);
		Server.BusinessLogic.Batteria vecchia = new Server.BusinessLogic.Batteria();
		
		vecchia.setBatteria( ultima.updateSostituzione(stazione, batteria.getBatteria() ) );
		
		return vecchia;
	
	}

}