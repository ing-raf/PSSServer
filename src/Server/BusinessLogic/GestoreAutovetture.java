package Server.BusinessLogic;

import java.util.ArrayList;
import Server.Entity.*;

public class GestoreAutovetture {

	/**
	 * 
	 * @param validazionebadge
	 */
	public static ArrayList<AutovetturaCliente> retrieveListaAutovetture(ValidazioneBadge validazionebadge) {
		
		Cliente cliente = validazionebadge.getCliente();
		
		ArrayList<AutovetturaCliente> listaAutovetture = new ArrayList<AutovetturaCliente>();
		ArrayList<AutovetturaCompatibile> lista = cliente.getListaAutovetture();
		
		for(int i = 0; i<lista.size(); i++){
			Server.BusinessLogic.AutovetturaCliente auto = new Server.BusinessLogic.AutovetturaCliente();
			auto.setAutovettura(lista.get(i));
			listaAutovetture.add(auto);
		}
		
		
		return listaAutovetture;
	}

	public static ArrayList<Autovettura> retrieveListaModelli() {
		
		Società s = new Società();
		ArrayList<Autovettura> listaModelli = new ArrayList<Autovettura>();
		ArrayList<ModelloAutovettura> lista = s.getListaModelli();
		
		for(int i = 0; i<lista.size(); i++){
			Autovettura m = new Autovettura();
			m.setAutovettura(lista.get(i));
			listaModelli.add(m);
		}
		
		return listaModelli;
	}

}