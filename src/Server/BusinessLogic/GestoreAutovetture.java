package Server.BusinessLogic;

import java.util.ArrayList;
import java.util.List;

import Server.Entity.*;

public class GestoreAutovetture {

	/**
	 * 
	 * @param validazionebadge
	 */
	public static ArrayList<AutovetturaCliente> retrieveListaAutovetture(ValidazioneBadge validazionebadge) {
		
		Cliente cliente = validazionebadge.getCliente();
		
		ArrayList<AutovetturaCliente> listaAutovetture = new ArrayList<AutovetturaCliente>();
		List<AutovetturaCompatibile> lista = cliente.getAutoPossedute();
		
		for(int i = 0; i<lista.size(); i++){
			Server.BusinessLogic.AutovetturaCliente auto = new Server.BusinessLogic.AutovetturaCliente();
			auto.setAutovettura(lista.get(i));
			listaAutovetture.add(auto);
		}
		
		
		return listaAutovetture;
	}

	public static ArrayList<Autovettura> retrieveListaModelli() {
		
		ArrayList<Autovettura> listaModelli = new ArrayList<Autovettura>();
		List<ModelloAutovettura> lista = Societa.getListaModelli();
		
		for(int i = 0; i<lista.size(); i++){
			Autovettura m = new Autovettura();
			m.setAutovettura(lista.get(i));
			listaModelli.add(m);
		}
		
		return listaModelli;
	}

}