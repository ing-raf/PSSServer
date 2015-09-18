package Server.BusinessLogic;

import java.util.ArrayList;
import java.util.Calendar;

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
		
		Server.BusinessLogic.Batteria vecchia = new Server.BusinessLogic.Batteria();
		Server.Entity.AutovetturaCompatibile a = autovettura.getAutovetturaCliente();
		Server.Entity.Sostituzione ultima = a.getLastRicambio();
		
		vecchia.setBatteria(ultima.getBatteria());
		ultima.setStazione(idStazione);
		ultima.setBatteria(batteria);
		ultima.setDataOra(Calendar.getInstance());
		
		return vecchia;
	
	}

}