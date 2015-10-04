package Server.OLD;

import java.util.ArrayList;
import java.util.List;

import Server.DAO.*;
import Server.Entity.Societa;

public class GestoreAutovetture {

	/**
	 * 
	 * @param validazionebadge
	 */
	public static ArrayList<AutovetturaCliente> retrieveListaAutovetture(ValidazioneBadge validazionebadge) {
		
		ClienteDAO cliente = validazionebadge.getCliente();
		
		ArrayList<AutovetturaCliente> listaAutovetture = new ArrayList<AutovetturaCliente>();
		List<AutovetturaCompatibileDAO> lista = cliente.getAutoPossedute();
		
		for(int i = 0; i<lista.size(); i++){
			Server.BusinessLogic.AutovetturaCliente auto = new Server.BusinessLogic.AutovetturaCliente();
			auto.setAutovettura(lista.get(i));
			listaAutovetture.add(auto);
		}
		
		
		return listaAutovetture;
	}

	public static ArrayList<Autovettura> retrieveListaModelli() {
		
		ArrayList<Autovettura> listaModelli = new ArrayList<Autovettura>();
		List<ModelloAutovetturaDAO> lista = Societa.getListaModelli();
		
		for(int i = 0; i<lista.size(); i++){
			Autovettura m = new Autovettura();
			m.setAutovettura(lista.get(i));
			listaModelli.add(m);
		}
		
		return listaModelli;
	}

}